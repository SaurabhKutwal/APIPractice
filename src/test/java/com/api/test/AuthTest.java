package com.api.test;

import com.api.pojomodels.request.LoginRequest;
import com.api.pojomodels.request.ResetPasswordRequest;
import com.api.pojomodels.request.SignupRequest;
import com.api.pojomodels.response.LoginResponse;
import com.api.serviceobjects.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest {

    private static String token = null;
    AuthService authService;
    Response response;

    @Test(description = "Checking login functionality of API", groups = {"smoke"})
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("ace19","ACE19@techwithjatin");
        authService = new AuthService();

        response = authService.login(loginRequest);

        Assert.assertEquals(response.getStatusCode(),200);

        LoginResponse loginResponse = response.then().extract().as(LoginResponse.class);

        token = loginResponse.getToken();

        System.out.println("token : " + loginResponse.getToken());
        System.out.println("type : " + loginResponse.getType());
    }

    @Test(description = "Checking singUp functionality of API")
    public void signUpTest(){
        SignupRequest signupRequest = new SignupRequest("blabla3","asdf@qwer","3kjghgcadso@gmail.com","mota",
                "panda","1234567891");

        authService = new AuthService();
        response = authService.signup(signupRequest);

        response.then().assertThat().statusCode(200);
        System.out.println(response.asPrettyString());
    }

    @Test(description = "Checking reset password functionality of API")
    public void resetPasswordTest(){
        loginTest();
        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest("BlackP34rl#01","BlackP34rl#01",token);
        response = authService.resetPassword(resetPasswordRequest);

        response.then().log().all().assertThat().statusCode(200);
        System.out.println(response.asPrettyString());
    }
}
