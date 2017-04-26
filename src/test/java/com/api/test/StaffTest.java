package com.api.test;

import com.api.domaine.Credentials.CredentialsForSignIn;
import com.api.domaine.StaffList.StaffList;
import com.api.domaine.api.SignInApi;
import com.api.domaine.assertions.StaffList.DatumAssert;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

/**
 * Created by tatyanavolkorezova on 13.04.17.
 */
public class StaffTest {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "http://35.163.170.147:3000/";
        RestAssured.basePath = "v1";
    }



    @Test
    public void testGetAccessToStaffMembers(){

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/staff?skip=0")
                .then()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void testSchemaValidateStaff(){

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);


        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema-validator/staff-schema.json"));


    }

    @Test
    public  void testGetTypeStaffMembers(){

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        StaffList all  = new StaffList();


        all = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/staff?skip=0")
                .then()
                .extract()
                .response()
                .as(StaffList.class);

        int leng = all.getData().size();

        for (int i = 0; i <leng; i++)
        {
            Assert.assertEquals(all.getData().get(i).getType(),"staff");
        }

    }



    @Test
    public void testGetNewUser(){

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        StaffList all  = new StaffList();


        all = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/staff?skip=0")
                .then()
                .extract()
                .response()
                .as(StaffList.class);

        DatumAssert.assertThat(all.getData().get(0))
                .hasEmail("letrghfbwkrebhd")
                .hasAccessLevel(75)
                .hasId("erwh,fdmsbjrn")
                .hasPhoneNumber("regyfhbdcireufkhsbdhuorfd");


    }


}
