package com.api.domaine.api;

import com.api.domaine.credentials.CredentialsForSignIn;
import com.api.domaine.CurrentUser;
import com.jayway.restassured.RestAssured;

/**
 * Created by tatyanavolkorezova on 12.04.17.
 */
public class SignInApi {



    public static CurrentUser signInAs(CredentialsForSignIn credentials){

        return RestAssured.given()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then()
                .extract()
                .response().as(CurrentUser.class);
    }


    public static String signInAsAndGetToken(CredentialsForSignIn credentials){

        return RestAssured.given()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then()
                .extract()
                .response()
                .as(CurrentUser.class).getToken();

    }







    }

