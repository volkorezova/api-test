package com.api.test;

import com.api.domaine.Credentials.CredentialsForSignIn;
import com.api.domaine.api.SignInApi;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static io.restassured.RestAssured.given;

/**
 * Created by tatyanavolkorezova on 13.04.17.
 */
public class TeamTest {

    @Description("Check access to tem members")
    @Title("Check satus code 200 on getting request members")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testGetAccessToTeamMembers(){
        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        given()
                .contentType("application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get("http://35.163.170.147:3000/v1/team?skip=0")
                .then()
                .assertThat()
                .statusCode(200);

    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("Getting info of team members")
    @Description("Check the member's info on member request")
    @Test
    public void testGetInfoTeamMembers(){
        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

         given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("http://35.163.170.147:3000/v1/team?skip=0")
                .then()
                 .extract().response().prettyPrint();
        //.as(TeamList.class).getData().get(0).getFirstName();


















    }


}
