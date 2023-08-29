package liveProject;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //Declare headers

    Map<String, String> headers = new HashMap<>();

    //Create the PACT
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        //Headers
        headers.put("Content-Type", "application/json");

        //Request Response Body
        DslPart requestResponseBody= new PactDslJsonBody().
                numberType("id", 123).
                stringType("firstName", "vaishali").
                stringType("lastName", "verma").
                stringType("email", "vaishali@gmail.com");

        //Generate Contract
        return builder.given("Post Request").
                uponReceiving("request to create a user").
                method("Post").
                path("/api/users").
                headers(headers).
                body(requestResponseBody).
                willRespondWith().
                status(201).
                body(requestResponseBody).
                toPact();

    }

    //Test with Mock Provider
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public  void  consumerTest(){
        //Request Body
        Map<String, Object> reqBody= new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "vaishali");
        reqBody.put("lastName", "verma");
        reqBody.put("email", "vaishali@gmail.com");

        //send Request
        given().headers(headers).body(reqBody).when().
                post("http://localhost:8282/api/users").then().
                statusCode(201).body("firstName", equalTo("vaishali")).log().all();
    }
}
