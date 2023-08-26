package APIRequests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestCase3 extends DataForTest{

   @Test(priority = 1, dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId) {

        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subject", subjectId);

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


    @Test(priority = 2, dataProvider = "DeleteData")
    public void test_delete(int userId) {

        baseURI = "http://localhost:3000";

            when().
                delete("/users/" + userId).
            then().
                statusCode(200).
                log().all();

    }
}
