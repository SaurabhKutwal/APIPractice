package com.api.serviceobjects;

import io.restassured.response.Response;

public class AuthService extends BaseService{
    private final String basePath = "/api/auth/";

    public Response login(Object payload){
        return  postRequest(basePath + "login",payload);
    }

    public Response signup(Object payload){
        return  postRequest(basePath + "signup",payload);
    }

    public Response resetPassword(Object payload){
        return postRequest(basePath + "reset-password",payload);
    }
}
