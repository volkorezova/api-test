package com.api.test;

import com.api.domaine.CurrentUser;
import com.api.domaine.UserUpdateCredentials;
import com.api.domaine.UserUpdated;
import com.api.domaine.api.SignInApi;
import com.api.domaine.assertions.CurrentUserAssert;
import com.api.domaine.credentials.CredentialsForSignIn;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.PrintStream;
import java.io.StringWriter;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;


@Listeners({com.api.utils.LogListener.class})
@Title("This test-suite check various errors and functionality of SIGN IN process")


public class SignInTest {





    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://35.163.170.147:3000/";
        RestAssured.basePath = "v1";
    }



//   @Attachment(value = "Request log")
//    public static byte[] request(String log) {
//        return log.getBytes();
//    }
//
//    @Attachment(value = "Response log")
//    public static byte[] response(String log) {
//        return log.getBytes();
//    }



    @Severity(SeverityLevel.BLOCKER)
    @Title("111111- Test checks the user response is not NULL")
    @Test
    public void testCanRetrieveUserOnSignIn() {
        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        CurrentUser currentUser = SignInApi.signInAs(credentials);
        CurrentUserAssert.assertThat(currentUser).isNotNull();
    }




    @Title("222222 - Test checks the user right schema")
    @Test
    public void testSchemaCurUser() {


       /* final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);*/

        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        given()/*.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))*/
        .contentType("application/json")
                .body(credentials)
                .when()
                .post("/signin")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema-validator/user-schema.json"));
        /*request(writerRequest.toString());
        response(writerResponse.toString());*/

    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("333333- Test checks the error msg on invalid EMAIL(email is not associated with any account")
    @Test
    public void testGetErrorOnIsNotAssociateEmail() {

      /*  final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);*/


        CredentialsForSignIn credentials = new CredentialsForSignIn("email@qqq.com", "1234456");

        given()/*.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))*/
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("/signin")
                .then().log().all()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message", equalTo("Invalid email"));
       // System.out.println("Passed??????");

        /*request(writerRequest.toString());
        response(writerResponse.toString());*/


    }



    @Severity(SeverityLevel.CRITICAL)
    @Title("444444  - Test checks the error msg on invalid EMAIL(invalid format)")
    @Test
    public void testGetErrorOnInvalEmail() {
       /* final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);*/

        CredentialsForSignIn credentials = new CredentialsForSignIn("emailqqq.com", "1234456");

        given()/*.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))*/
                 .contentType("application/json")
                .body(credentials)
                .when()
                .post("/signin")
                .then().log().all()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message", equalTo("Invalid email"));

        /*request(writerRequest.toString());
        response(writerResponse.toString());*/

    }


    @Severity(SeverityLevel.NORMAL)
    @Title("555555 - Test checks the error msg on invalid PASSWORD")
    @Test
    public void testGetErrorOnInvalidPassword() {

     /*   final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);*/

        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12344561111");
        given()/*.filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))*/
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("/signin")
                .then()
                .assertThat()
                .statusCode(401)
                .and()
                .assertThat()
                .body("message", equalTo("Invalid passwordrreeghjjrkygvlhbjnlkml"));

       // request(writerRequest.toString());
        //response(writerResponse.toString());

    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("666666 - Test checks updating user on the end stage of SIGN IN process - neverUpdate field and status code")
    @Test
    public void testUserUpdated() {

        final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);


        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");

        CurrentUser currentUser = SignInApi.signInAs(credentials);
        String token = currentUser.getToken().toString();
        UserUpdateCredentials never = new UserUpdateCredentials(true);

        Boolean neverUpdated = given().filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(never)
                .when()
                .put("/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .extract().as(UserUpdated.class).getData().getNeverUpdated();
        assertTrue(neverUpdated);

//       request(writerRequest.toString());
//        response(writerResponse.toString());


    }



}






