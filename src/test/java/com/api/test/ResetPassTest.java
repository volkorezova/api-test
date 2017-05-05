package com.api.test;

import com.api.domaine.credentials.CredentialsForResetPass;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by tatyanavolkorezova on 13.04.17.
 */
public class ResetPassTest {

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


    @Description("Test can reset password - check the status code 200")
    @Title("Can reset password 200 OK")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testCanResetPassword() {

//        final StringWriter writerRequest = new StringWriter();
//        final StringWriter writerResponse = new StringWriter();
//        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
//        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForResetPass credentialsRes = new CredentialsForResetPass("volkorezova@mail.com");
        given()//.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))//
                .contentType("application/json")
                .body(credentialsRes)
                .when()
                .post("/auth/reset")
                .then()
                .assertThat()
                .statusCode(200)
                .and().assertThat().body("code", equalTo("OK"));
//        request(writerRequest.toString());
//        response(writerResponse.toString());

    }




    @Severity(SeverityLevel.CRITICAL)
    @Title("Get error message on invalid emamvn il when try to reset password")
    @Description("Check the process of reset password - email is not associated with any account")
    @Test
    public void testGetErrorOnInvalidEmailResetPass(){
//
//        final StringWriter writerRequest = new StringWriter();
//        final StringWriter writerResponse = new StringWriter();
//        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
//        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);
        CredentialsForResetPass credentialsRes = new CredentialsForResetPass("vol@mai.com");
        given()//.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))//
                .contentType("application/json")
                .body(credentialsRes)
                .when()
                .post("/auth/reset")
                .then()
                .assertThat()
                .statusCode(400)
                .and().assertThat().body("message", equalTo("User not found"));
//        request(writerRequest.toString());
//        response(writerResponse.toString());

    }


    @Test
    public void testValidateUserSchemaOnResetPassword(){

//        final StringWriter writerRequest = new StringWriter();
//        final StringWriter writerResponse = new StringWriter();
//        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
//        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);
        CredentialsForResetPass credentialsRes = new CredentialsForResetPass("volkorezova@mail.com");
        given()//.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))//
                .contentType("application/json")
                .body(credentialsRes)
                .when()
                .post("/auth/reset")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema-validator/userONreset-schema.json"));
//        request(writerRequest.toString());
//        response(writerResponse.toString());

    }
}
