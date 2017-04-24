package com.api.test;

import com.api.domaine.Credentials.CredentialsForResetPass;
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

    @Description("Test can reset password - check the status code 200")
    @Title("Can reset password 200 OK")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testCanResetPassword() {

        CredentialsForResetPass credentialsRes = new CredentialsForResetPass("volkorezova@mail.com");
        given()
                .contentType("application/json")
                .body(credentialsRes)
                .when()
                .post("http://35.163.170.147:3000/v1/auth/reset")
                .then()
                .assertThat()
                .statusCode(200)
                .and().assertThat().body("code", equalTo("OK"));
    }




    @Severity(SeverityLevel.CRITICAL)
    @Title("Get error message on invalid emamvn il when try to reset password")
    @Description("Check the process of reset password - email is not associated with any account")
    @Test
    public void testGetErrorOnInvalidEmailResetPass(){

        CredentialsForResetPass credentialsRes = new CredentialsForResetPass("vol@mai.com");
        given()
                .contentType("application/json")
                .body(credentialsRes)
                .when()
                .post("http://35.163.170.147:3000/v1/auth/reset")
                .then()
                .assertThat()
                .statusCode(400)
                .and().assertThat().body("message", equalTo("User not found"));

    }


    @Test
    public void testValidateUserSchemaOnResetPassword(){

        CredentialsForResetPass credentialsRes = new CredentialsForResetPass("volkorezova@mail.com");
        given()
                .contentType("application/json")
                .body(credentialsRes)
                .when()
                .post("http://35.163.170.147:3000/v1/auth/reset")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema-validator/userONreset-schema.json"));

    }
}
