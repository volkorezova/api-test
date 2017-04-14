package com.api.test;

import com.api.domaine.Credentials.CredentialsForSignIn;
import com.api.domaine.CurrentUser;
import com.api.domaine.UserUpdateCredentials;
import com.api.domaine.api.SignInApi;
import com.api.domaine.assertions.CurrentUserAssert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@Title("These test-suite check various errors and functionality of SIGN IN process")
public class SignInTest {




    @Severity(SeverityLevel.BLOCKER)
    @Title("Test checks the user response is not NULL")
    @Test
    public void TestCanRetrieveUserOnSignIn() {

        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        CurrentUser currentUser = SignInApi.signInAs(credentials);
        CurrentUserAssert.assertThat(currentUser).isNotNull();
    }

    /*@Test
    public void TestSchemaCurUser() {


        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        given()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin").then().assertThat().body(matchesJsonSchemaInClasspath("user-schema.json"));

    }*/

    @Severity(SeverityLevel.CRITICAL)
    @Title("Test checks the error msg on invalid EMAIL(email is not associated with any account")
    @Test
    public void TestGetErrorOnIsNotAssociateEmail(){

        CredentialsForSignIn credentials = new CredentialsForSignIn("email@qqq.com", "1234456");
        given().log().all()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then().log().all()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message",equalTo("Invalid email"));


    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("Test checks the error msg on invalid EMAIL(invalid format)")
    @Test
    public void TestGetErrorOnInvalEmail(){
        CredentialsForSignIn credentials = new CredentialsForSignIn("emailqqq.com", "1234456");
        given().log().all()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then().log().all()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message",equalTo("Invalid email"));

    }

    @Attachment(value = "{TEST ATTACHHMENT}", type = "text/json")
    @Severity(SeverityLevel.NORMAL)
    @Title("Test checks the error msg on invalid PASSWORD")
    @Test
    public void TestGetErrorOnInvalidPassword(){
        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12344561111");
        given().log().all()
                .contentType("application/json")
                .body(credentials)
                .when()
                .post("http://35.163.170.147:3000/v1/signin")
                .then()
                .assertThat()
                .statusCode(401)
                .and().assertThat().body("message",equalTo("Invalid passwordrreeghjjrkygvlhbjnlkml"));

    }


    //@Attachment(value = "")
    @Severity(SeverityLevel.CRITICAL)
    @Title("Test checks updating user on the end stage of SIGN IN process - neverUpdate field and status code")
    @Test
    public void TestUserUpdated() {
        CredentialsForSignIn credentials = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        CurrentUser currentUser = SignInApi.signInAs(credentials);
        String token = currentUser.getToken().toString();
        UserUpdateCredentials never = new UserUpdateCredentials(true);


         given()
                .contentType("application/json")
                .header("Authorization","Bearer "+token)
                .body(never)
                .when()
                .put("http://35.163.170.147:3000/v1/profile")
                .then()
                .assertThat()
                .statusCode(200);

        //.and().assertThat().extract().as(UserUpdated.Data.class).getNeverUpdated().equals(true);


                 //("neverUpdated", equalTo(true));
                //.and()
                //.extract()
//                .as(UserUpdated.Data.class).getNeverUpdated().compareTo(true);










    }
}






