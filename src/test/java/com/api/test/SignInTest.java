package com.api.test;

import com.api.domaine.User;
import com.api.domaine.assertions.UserAssert;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;



public class SignInTest {
    @BeforeClass
            public void setup(){

        RestAssured.baseURI = "http://35.163.170.147:3000/";
        RestAssured.basePath = "v";




    }





    String myBody = "{\"email\":\"volkorezova@mail.com\",\"password\":\"12345}";

    @Test
    public void Test_01() {
        RestAssured.given()
                .contentType("application/json")
                .body(myBody)
                .when()
                .post("/signin")
                .then()
                .extract()
                .response()
                .prettyPrint();

    }
       @Test
       public void Test_02(){
        RestAssured.given().get("/team?skip=0").then().extract().response().prettyPrint();


        }

    @Test
    public void testName() throws Exception {
    }

    @Test
    public void Test_03(){
            User curUser = when()
                    .post("/signin")
                    .then()
                    .statusCode(200)
                    .extract()
                    .body()
                    .as(User.class);

            System.out.println(curUser);

            assertEquals(curUser.getEmail(),"email");

            UserAssert.assertThat(curUser).hasId("eh837i4ythn").hasAccessLevel(1).hasFirstName("ksbdfzc");


        }

        @Test
    public void Test_04(){
            User curUser = (User) given()
                    .contentType("application/json")
                    .body(myBody)
                    .when()
                    .post("/signin"). then().statusCode(200)
                    .body(matchesJsonSchemaInClasspath("user-schema.json"));

        }

        @Test
    public void Test_auth(){

        User auth = (User) given().auth().basic("volkorezova@mail.com","12345").when().post("/signin").then().statusCode(200);


        }









    }


