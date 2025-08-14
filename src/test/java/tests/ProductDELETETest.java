package tests;

import base.TestBase;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class ProductDELETETest extends TestBase {

	@Test
	public void testDeleteProductById() {
	    int productIdToDelete = 2;
        
	    System.out.println("\n🗑️ Running Test: Delete Product (ID = " + productIdToDelete + ")");
	    Response deleteResponse =
	        given()
	            .header("Authorization", "dN02jShBGvQMEt71zvPIJK1skwhEpSaCe5TidJANpqI")
	        .when()
	            .delete("/delProduct/" + productIdToDelete)
	        .then()
	            .extract().response();

	    // Convert response body to JSON array and print it
	    JSONArray updatedProducts = new JSONArray(deleteResponse.getBody().asString());

	    System.out.println("📦 Products after deletion:");
	    System.out.println(updatedProducts.toString(2));  // Pretty print with indentation
	}

}
