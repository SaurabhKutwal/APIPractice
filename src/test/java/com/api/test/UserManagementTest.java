package com.api.test;

import com.api.pojomodels.request.LoginRequest;
import com.api.pojomodels.response.LoginResponse;
import com.api.pojomodels.response.UserProfileResponse;
import com.api.serviceobjects.AuthService;
import com.api.serviceobjects.UserManagement;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserManagementTest {

    Response response;
    String token;

    @BeforeTest(description = "Getting token for making get request for user profile.")
    public void reqToken(){
        LoginRequest loginRequest = new LoginRequest("ace19","ACE19@techwithjatin");
        AuthService authService = new AuthService();
        response = authService.login(loginRequest);

        Assert.assertEquals(response.getStatusCode(),200);

        LoginResponse loginResponse = response.then().extract().as(LoginResponse.class);
        token = loginResponse.getToken();
    }

    @Test(description = "Checking get user profile service of API.")
    public void getProfileTest(){

        UserManagement userManagement = new UserManagement();
        response = userManagement.getUserProfile(token);

        Assert.assertEquals(response.getStatusCode(),200);

        UserProfileResponse userProfile = response.then().extract().as(UserProfileResponse.class);

        System.out.println("Id :" + userProfile.getId());
        System.out.println("UserName : " + userProfile.getUsername());
        System.out.println("Email : " + userProfile.getEmail());
        System.out.println("FirstName : " + userProfile.getFirstName());
        System.out.println("LastName : " + userProfile.getLastName());
        System.out.println("Mobile No : " + userProfile.getMobileNumber());
    }
}
