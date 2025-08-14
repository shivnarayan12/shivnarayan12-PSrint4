package tests;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class ProductPUTTest extends TestBase {

	@Test
	public void testUpdateProduct() {
	    SoftAssert softAssert = new SoftAssert();
        
	    System.out.println("🔧 Running Test: Update Product");
	    // ✅ Payload to update product
	    JSONObject payload = new JSONObject();
	    payload.put("id", 2);
	    payload.put("name", "Shirt");
	    payload.put("amount", 4500);

	    System.out.println("\n🛠️ Running Test: Update Product (ID = 2)");

	    // ✅ Send PUT request to update product
	    Response response =
	        given()
	            .header("Authorization", "dN02jShBGvQMEt71zvPIJK1skwhEpSaCe5TidJANpqI")
	            .contentType("application/json")
	            .body(payload.toString())
	        .when()
	            .put("/updateProduct/2")
	        .then()
	            .log().status()
	            .extract().response();

	    // ✅ Assert status code
	    int statusCode = response.statusCode();
	    softAssert.assertEquals(statusCode, 200, "Update Product Failed");

	    // ✅ Print updated product response
	    System.out.println("📦 Updated Product Details:");
	    System.out.println(response.getBody().asPrettyString());

	    softAssert.assertAll();
	}

}