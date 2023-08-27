package APIRequests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestCase1 {

    @Feature("Get Request")
    @Story("Get List of Users from the server")
    @Test(priority = 1)
    public void test_get() {

        baseURI = "http://localhost:3000";

        given().
                get("/users").
        then().
                statusCode(200).
                log().all();
    }

    @Feature("Get Request")
    @Story("Get a users details from the server")
    @Test(priority = 2)
    public void test_get2() {

        baseURI = "http://localhost:3000";

        given().
                param("name", "Automation").
                get("/subjects").
        then().
                statusCode(200).
                log().all();
    }

    @Feature("Post Request")
    @Story("Create new users' profile in the server")
    @Test(priority = 3)
    public void test_post() {

        JSONObject request = new JSONObject();

        request.put("firstName", "Tomi");
        request.put("lastName", "Vuori");
        request.put("subject", "DevOps");

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                post("/users").
        then().
               statusCode(201).
                log().all();

    }

    @Feature("Patch Request")
    @Story("Update part of a user's profile in server")
    @Test(priority = 4)
    public void test_patch() {

        JSONObject request = new JSONObject();

        request.put("lastName", "Hyypiä");

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                patch("/users/4").
        then().
                statusCode(200).
                log().all();

    }

    @Feature("Put Request")
    @Story("Update users information in the server")
    @Test(priority = 5)
    public void test_put() {

        JSONObject request = new JSONObject();

        request.put("firstName", "Jari");
        request.put("lastName", "Litmanen");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                put("/users/4").
        then().
                statusCode(200).
                log().all();
    }

    @Feature("Delete Request")
    @Story("Deleting user(s) profile from the server")
    @Test(priority = 6)
    public void test_delete() {

        baseURI = "http://localhost:3000";

            when().
                delete("/users/4").
            then().
                statusCode(200);

    }


}
