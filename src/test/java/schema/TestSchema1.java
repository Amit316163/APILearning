package schema;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;




public class TestSchema1 {
	
	@Test
	public void getSchemaTestValidation() {
RestAssured.baseURI="https://gorest.co.in";
		
		given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
		.when().get("/public/v2/users")
		.then().log().all()
		.body(matchesJsonSchemaInClasspath("GetSchemaFile.json"));
		
	}

}
