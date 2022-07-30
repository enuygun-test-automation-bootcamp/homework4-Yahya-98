import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class orderInventory {

    Response response;

    public orderInventory(){
        baseURI = "https://petstore.swagger.io/v2/store/";

    }

    @Test
    public void inventoryUnirest() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/inventory")
                .asString();

    }

    @Test
    public void inventoryRestassured(){

        response = given()
                .when()
                .post("inventory")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

    }
}
