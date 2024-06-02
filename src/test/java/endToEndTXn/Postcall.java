package endToEndTXn;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Reusable;

import static io.restassured.RestAssured.*;

import java.io.File;

public class Postcall {
	
	@DataProvider(name="user")
	public Object[][] testData() {
		
		return new Object[][] {
			{"API","male",Reusable.randomEmailID(),"active"}
			};
	}
	
	
	
	
	
	@Test(dataProvider = "user")
	public void postMethod(String name,String gender,String email,String status) {
		
		
		//post
		RestAssured.baseURI="https://gorest.co.in";
		
		Response postResponse=given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
				.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"gender\": \""+gender+"\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
				+ "    \"status\": \""+status+"\"\r\n"
				+ "}")
		.when().post("/public/v2/users")
		.then().log().all().extract().response();
		
		int statusCode=postResponse.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		//fetch the id 
		JsonPath js=new JsonPath(postResponse.asString());
		
		int id=js.get("id");
		System.out.println("id =="+id);
		
		System.out.println("========================================================");
		
		
		
		
	}

}