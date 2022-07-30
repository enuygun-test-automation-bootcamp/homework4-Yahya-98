import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class getOrder {

    Response response;

    public getOrder(){
        baseURI = "https://petstore.swagger.io/v2/store/";
    }

    @Test
    public void orderUnirest() {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = (HttpResponse<String>) Unirest.get("https://petstore.swagger.io/v2/store/order/{orderId}")
                .header("Content-Type", "application/json")
                .getBody();
        Assert.assertEquals(200,response.getStatus());

    }

    @Test
    public void orderRestassured() throws JsonProcessingException{

        response = given().header("Content-Type", "application/json")
                .body("2")
                .when()
                .post("order/{orderId}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
    }
}
