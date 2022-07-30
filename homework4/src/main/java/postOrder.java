import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class postOrder {

    Response response;
    HttpHeaders headers;
    RestTemplate restTemplate;
    private final com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
    Pet pet = new Pet();
    public postOrder(){
        baseURI = "https://petstore.swagger.io/v2/store/";
    }

    @Test
    public void orderunirest() throws UnirestException, JsonProcessingException {


        int randomint = (int)(Math.random()*(10-0+1)+0);
        pet.setId(randomint);
        pet.setPetid(randomint);
        pet.setQuantity(randomint);
        pet.setStatus("placed");
        pet.setShipDate("2022-07-30T15:20:48.883Z");
        pet.setComplete(true);

        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(pet);

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = (HttpResponse<String>) Unirest.post("https://petstore.swagger.io/v2/store/order")
                .header("Content-Type", "application/json")
                .body(jsonString)
                .asString();
        Assert.assertEquals(200,response.statusCode());

    }

    @Test
    public void orderhttpentty(){


    }

    @Test
    public void orderRestassured() throws JsonProcessingException {

        String jsonString = mapper.writeValueAsString(pet);
        response = given().header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post("order")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

    }





}
