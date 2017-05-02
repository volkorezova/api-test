package com.api.test;

import com.api.domaine.credentials.CredentialsForSignIn;
import com.api.domaine.teamList.TeamList;
import com.api.domaine.api.SignInApi;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.PrintStream;
import java.io.StringWriter;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

/**
 * Created by tatyanavolkorezova on 13.04.17.
 */
public class TeamTest {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "http://35.163.170.147:3000/";
        RestAssured.basePath = "v1";
    }

    @Attachment(value = "Request log")
    public static byte[] request(String log) {
        return log.getBytes();
    }

    @Attachment(value = "Response log")
    public static byte[] response(String log) {
        return log.getBytes();
    }

    @Description("Check access to tem members")
    @Title("Check satus code 200 on getting request members")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testGetAccessToTeamMembers() {

        final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        given().filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .assertThat()
                .statusCode(200);

        request(writerRequest.toString());
        response(writerResponse.toString());

    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("Getting info of team members")
    @Description("Check the member's info on member request")
    @Test
    public void testGetInfoTeamMembers() {
        final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        given().filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .extract()
                .response()
                .prettyPrint();
        //.as(teamList.class).getData().get(0).getFirstName();
        request(writerRequest.toString());
        response(writerResponse.toString());

    }


    @Severity(SeverityLevel.CRITICAL)
    @Title("Validate team json schema")
    @Test
    public void testSchemaValidateTeam(){

        final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);


        given().filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema-validator/team-schema.json"));

        request(writerRequest.toString());
        response(writerResponse.toString());


    }


    @Test
    public void testGetUserInfoFromList(){

        final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        given().filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .response().asString().contains("58d140695566101814bff7f4");
                //.body("data", contains("58d140695566101814bff7f4"));
                //.body("data.firstName", equalTo("Artem"));



        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .assertThat()
                .extract()
                .response().asString().contains("Artem");
        //.body("data", contains("58d140695566101814bff7f4"));
        //.body("data.firstName", equalTo("Artem"));

        request(writerRequest.toString());
        response(writerResponse.toString());

    }


    @Test
    public void testGetArrTeamList(){
        final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        TeamList all  = new TeamList();
        TeamList all2  = new TeamList();

        all = given().filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .extract()
                .as(TeamList.class);

        String em = all.getData().get(0).getEmail();
        Assert.assertEquals(em,"eath@mail.com");


       Boolean all3 = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .extract()
                .response()
                .as(TeamList.class).getData().get(3).getNeverUpdated();
       Assert.assertTrue(all3);

       int leng = all.getData().size();
       System.out.println(leng);

       
for (int i = 0; i <leng; i++)
{
    System.out.println(i+")"+" "+ all.getData().get(i).getEmail());
    Assert.assertTrue(all.getData().get(i).getNeverUpdated());

}

        request(writerRequest.toString());
        response(writerResponse.toString());

    }


    @Test
    public  void testGetTypeMembers(){

        final StringWriter writerRequest = new StringWriter();
        final StringWriter writerResponse = new StringWriter();
        final PrintStream requestVar = new PrintStream(new WriterOutputStream(writerRequest), true);
        final PrintStream responseVar = new PrintStream(new WriterOutputStream(writerResponse), true);

        CredentialsForSignIn credentialsForSignIn = new CredentialsForSignIn("volkorezova@mail.com", "12345");
        String token = SignInApi.signInAsAndGetToken(credentialsForSignIn);

        TeamList all  = new TeamList();


        all = given().filters(new ResponseLoggingFilter(responseVar), new RequestLoggingFilter(requestVar))
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/team?skip=0")
                .then()
                .extract()
                .as(TeamList.class);

        int leng = all.getData().size();

        for (int i = 0; i <leng; i++)
        {
            Assert.assertEquals(all.getData().get(i).getType(),"athlete");
        }
        request(writerRequest.toString());
        response(writerResponse.toString());

    }


}
