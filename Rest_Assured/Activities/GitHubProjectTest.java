package liveProject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class GitHubProjectTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJThsPQgRh6pPUA7pb0dNh4xOLbINXVCj7x4Xzp9PG9g";
    int sshKeyId;
    @BeforeClass
    public void setUp(){
        //Request Specification
        requestSpec=new RequestSpecBuilder().
                setBaseUri("https://api.github.com/user/keys").
                addHeader("Authorization", "token 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").
                addHeader("Content-Type","application/json").build();

        //Response Specification
        responseSpec = new ResponseSpecBuilder().
                expectResponseTime(lessThanOrEqualTo(5000L)).
                expectBody("title", equalTo("TestAPIKey")).
                expectBody("key", equalTo(sshKey)).build();
    }

    @Test(priority = 1) // Post Request
            public void postRequestTest(){
        //Request Body
        Map<String, String> reqBody= new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        //Generate response
        Response response= given().spec(requestSpec).
                body(reqBody).when().log().all().post();
        System.out.println(response.getBody().asPrettyString());

        //Extract PetId
        sshKeyId=response.then().extract().path("id");

        //Assertion
       response.then().statusCode(201).spec(responseSpec);

    }
    @Test(priority = 2)
    public void getRequestTest()
    {
       Response response= given().spec(requestSpec).pathParam("keyId", sshKeyId).
               when().log().all().get("/{keyId}");
        System.out.println(response.getBody().asPrettyString());
        //Assertion
       response.then().statusCode(200).spec(responseSpec);
    }
    @Test(priority = 3)
    public void deleteRequestTest(){
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
                when().delete("/{keyId}").then().statusCode(204);

    }

}
