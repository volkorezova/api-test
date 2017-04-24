package com.api.test;

import com.api.domaine.Credentials.CredentialsForSignIn;
import com.api.domaine.CurrentUser;
import com.api.domaine.UserUpdateCredentials;
import com.api.domaine.UserUpdated;
import com.api.domaine.api.SignInApi;
import com.api.domaine.assertions.CurrentUserAssert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;

@Title("These test-suite check various errors and functionality of SIGN IN process")
public class SignInTest {


    @Severity(SeverityLevel.BLOCKER)
    @Title("Test checks the user response is not NULL")
    @Test
    public void testCanRetrieveUserOnSignIn() {

        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        CurrentUser currentUser = SignInApi.signInAs(credentials);
        CurrentUserAssert.assertThat(currentUser).isNotNull();

       /* FileWorker fil = new FileWorker();
        fil.write("test.json", currentUser.toString());
        saveHtmlAttach("test.json");*/



    }

    @Test
    public void testSchemaCurUser() {


        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        given()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema-validator/user-schema.json"));


    }

    @Severity(SeverityLevel.CRITICAL)
    @Title("Test checks the error msg on invalid EMAIL(email is not associated with any account")
    @Test
    public void testGetErrorOnIsNotAssociateEmail() {

        CredentialsForSignIn credentials = new CredentialsForSignIn("email@qqq.com", "1234456");
        given().log().all()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then().log().all()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message", equalTo("Invalid email"));
        System.out.println("Passed??????");

    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("Test checks the error msg on invalid EMAIL(invalid format)")
    @Test
    public void testGetErrorOnInvalEmail() {
        CredentialsForSignIn credentials = new CredentialsForSignIn("emailqqq.com", "1234456");
        given().log().all()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then().log().all()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message", equalTo("Invalid email"));


    }



    @Attachment(value = "{TEST ATTACHHMENT}", type = "text/json")
    @Severity(SeverityLevel.NORMAL)
    @Title("Test checks the error msg on invalid PASSWORD")
    @Test
    public void testGetErrorOnInvalidPassword() {
        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12344561111");
        given().log().all()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message", equalTo("Invalid passwordrreeghjjrkygvlhbjnlkml"));


    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("Test checks updating user on the end stage of SIGN IN process - neverUpdate field and status code")
    @Test
    public void testUserUpdated() {
        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        CurrentUser currentUser = SignInApi.signInAs(credentials);
        String token = currentUser.getToken().toString();
        UserUpdateCredentials never = new UserUpdateCredentials(true);


       Boolean neverUpdated = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(never)
                .when()
                .put("http://35.163.170.147:3000/v1/profile")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .extract().as(UserUpdated.class).getData().getNeverUpdated();
       assertTrue(neverUpdated);

    }


  /*  @Attachment(value = "json", type = "text/html")
    public static byte[] saveHtmlAttach(String attachName) {
        try {
            URL defaultImage = SignInTest.class.getResource("/test.html");
            File imageFile = new File(defaultImage.toURI());
            return toByteArray(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }*/

}






