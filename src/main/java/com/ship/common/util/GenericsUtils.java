package com.ship.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射工具类
 * @author Mryang
 * @createTime 2017年3月28日
 * @version 1.0
 */
public class GenericsUtils {
	 /**
     * 通过反射，获得指定类的父类的泛型参数的实际类型。如：BuyerServiceBean extends DaoSupport<Buyer>
     * @param clazz 需要反射的类,该类必须继承范型父类
     * @param index 泛型参数所在索引,从0开始
     * @return 范型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */
    public static Class getSuperClassGenricType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();//得到泛型的父类
        //如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class
        if(!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的Type对象的数组，数组里放的都是对应类型的Class，如BuyerServiceBean extends DaoSupport<Buyer,Contact>就返回Buyer和Contact类型
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        if(index >= params.length || index < 0) {
            throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出参数的总数"));
        }
        if(!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class)params[index];
    }


    /**
     * 通过反射，获得指定类的父类的第一个泛型参数的实际类型。如：BuyerServiceBean extends DaoSupport<Buyer>
     * @param clazz 需要反射的类,该类必须继承范型父类
     * @return 范型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */
    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }
}
