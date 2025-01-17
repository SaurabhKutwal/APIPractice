package com.api.serviceobjects;

import io.restassured.response.Response;

public class UserManagement extends BaseService{
    public static final String BASE_PATH = "/api/users/";

    public Response getUserProfile(String token){
        setToken(token);
        return getRequest(BASE_PATH + "profile");
    }
}
