package tests;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;

public class ProductGETTests extends TestBase {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testViewAllProducts() {
        // Send the GET request and store the response
    	System.out.println("🔍 Running Test: View All Products");
        Response response =
            given()
                .header("Authorization", "dN02jShBGvQMEt71zvPIJK1skwhEpSaCe5TidJANpqI")
            .when()
                .get("/getAllProducts")
            .then()
                .log().status()
                .extract().response();

        int statusCode = response.statusCode();
        softAssert.assertEquals(statusCode, 200, "View All Products Failed");

        // Print full response body
        System.out.println("🔽 All Products:");
        System.out.println(response.getBody().asPrettyString());

        softAssert.assertAll();
    }


    @Test
    public void testViewProductById() {
        // Send request and get response
    	System.out.println("🔍 Running Test: View Product by ID (ID = 2)");
        Response response =
            given()
                .header("Authorization", "dN02jShBGvQMEt71zvPIJK1skwhEpSaCe5TidJANpqI")
            .when()
                .get("/getProductbyId/2")
            .then()
                .log().status()
                .extract().response();

        int statusCode = response.statusCode();
        softAssert.assertEquals(statusCode, 200, "View Product by ID Failed");

        // Print the product details
        System.out.println("📦 Product Details (ID = 2):");
        System.out.println(response.getBody().asPrettyString());

        softAssert.assertAll();
    }


    @Test
    public void testViewProductByName() {
        // Send GET request and store the response
    	System.out.println("🔍 Running Test: View Product by Name (Name = Laptop)");
        Response response =
            given()
                .header("Authorization", "dN02jShBGvQMEt71zvPIJK1skwhEpSaCe5TidJANpqI")
            .when()
                .get("/viewProductByName?name=Laptop")
            .then()
                .log().status()
                .extract().response();

        int statusCode = response.statusCode();
        softAssert.assertEquals(statusCode, 200, "View Product by Name Failed");

        // Print the full product details
        System.out.println("📦 Product Details (Name = Laptop):");
        System.out.println(response.getBody().asPrettyString());

        softAssert.assertAll();
    }

}