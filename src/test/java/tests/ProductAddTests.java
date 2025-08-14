package tests;

import base.TestBase;
import utils.JsonUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductAddTests extends TestBase {

    // 🔹 DataProvider method to load test cases from JSON file
    @DataProvider(name = "productData")
    public Object[][] getProductData() throws Exception {
        String filePath = "src/test/resources/payloads/addProduct.json";
        String content = JsonUtil.loadJson(filePath);
        JSONArray testDataArray = new JSONArray(content);

        Object[][] data = new Object[testDataArray.length()][1];
        for (int i = 0; i < testDataArray.length(); i++) {
            data[i][0] = testDataArray.getJSONObject(i);
        }
        return data;
    }

    // 🔹 Test method using the DataProvider
    @Test(dataProvider = "productData")
    public void testAddProduct(JSONObject product) {
        String testCase = product.optString("testCase", "Unknown Case");
        int expectedStatus = product.optInt("expectedStatus", 200);

        System.out.println("\n🧪 Running Test Case: " + testCase);

        given()
            .header("Authorization", "dN02jShBGvQMEt71zvPIJK1skwhEpSaCe5TidJANpqI")
            .contentType("application/json")
            .body(product.toString())
        .when()
            .post("/addProduct")
        .then()
            .statusCode(expectedStatus)
            .log().status();

        System.out.println("✅ " + testCase + " completed");
    }
}
