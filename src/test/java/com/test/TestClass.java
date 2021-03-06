package com.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.representation.Form;
import javax.ws.rs.core.MediaType;

/**
 * @author yang
 * @version 1.0
 * @createTime 2017/4/6.
 */
public class TestClass {


    public static void main(String[] args) {
        String apiUrl = "http://127.0.0.1:8080";
        String resourceUrl = "admin/login.do";
        String account = "admin";
        String password = "admin123";

        Form param = new Form();
        param.putSingle("account",account);
        param.putSingle("password",password);

        Client client = new Client();
        String messs =  client.resource(apiUrl).path(resourceUrl).queryParams(param).type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
        .accept(MediaType.APPLICATION_JSON).post(String.class);
        System.out.println(messs);

    }


}
