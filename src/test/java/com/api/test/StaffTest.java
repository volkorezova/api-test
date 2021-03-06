package com.api.test;

import com.api.domaine.api.SignInApi;
import com.api.domaine.assertions.staffList.DatumAssert;
import com.api.domaine.credentials.CredentialsForSignIn;
import com.api.domaine.staffList.StaffList;
import com.api.utils.LogListener;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

/**
 * Created by tatyanavolkorezova on 13.04.17.
 */
@Listeners(LogListener.class)
public class StaffTest {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "http://35.163.170.147:3000/";
        RestAssured.basePath = "v1";
    }

//    @Attachment(value = "Request log")
//    public static byte[] request(String log) {
//        return log.getBytes();
//    }
//
//    @Attachment(value = "Response log")
//    public static byte[] response(String log) {
//        return log.getBytes();
//    }



    @Test
    @Title("staff 11111")
    public void testGetAccessToStaffMembers(){

//        final StringWriter writerRequest = new StringWriter();
//        final StringWriter writerResponse = new StringWriter();
//        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
//        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);
        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        given()//.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))//
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/staff?skip=0")
                .then()
                .assertThat()
                .statusCode(200);
//        request(writerRequest.toString());
//        response(writerResponse.toString());

    }

    @Title("staff 222222")
    @Test
    public void testSchemaValidateStaff(){

//        final StringWriter writerRequest = new StringWriter();
//        final StringWriter writerResponse = new StringWriter();
//        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
//        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);


        given()//.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))//
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema-validator/staff-schema.json"));
//        request(writerRequest.toString());
//        response(writerResponse.toString());

    }

    @Title("staff  33333")
    @Test
    public  void testGetTypeStaffMembers(){

//       //
        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        StaffList all  = new StaffList();


        all = given()//.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))//
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

//        request(writerRequest.toString());
//        response(writerResponse.toString());

    }



    @Title("staff 444444")
    @Test
    public void testGetNewUser(){

//        final StringWriter writerRequest = new StringWriter();
//        final StringWriter writerResponse = new StringWriter();
//        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
//        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        StaffList all  = new StaffList();


        all = given()//.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))//
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
//        request(writerRequest.toString());
//        response(writerResponse.toString());

    }


}
