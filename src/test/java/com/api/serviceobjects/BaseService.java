package com.api.serviceobjects;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseService {

    private static final String BASE_URI = "http://64.227.160.186:8080";
    protected RequestSpecification requestSpecification;

    public BaseService(){
        this.requestSpecification = given().baseUri(BASE_URI)
                .header("Content-Type","application/json");
    }

    Response postRequest(String endPoint,Object payload){
        return requestSpecification.body(payload).when().post(endPoint);
    }
}
