package com.api.serviceobjects;

import com.api.Filter.LogFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseService {

    private static final String BASE_URI = "http://64.227.160.186:8080";
    protected RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LogFilter());
    }
    public BaseService(){
        this.requestSpecification = given().baseUri(BASE_URI)
                .header("Content-Type","application/json");
    }
    protected void setToken(String token){
        requestSpecification.header("Authorization","Bearer " + token);
    }
    protected Response postRequest(String endPoint,Object payload){
        return requestSpecification.body(payload).when().post(endPoint);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.when().get(endpoint);
    }
}
