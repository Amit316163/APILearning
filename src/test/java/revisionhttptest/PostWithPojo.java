package revisionhttptest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import revision.PojoTest;
import utils.Reusable;

public class PostWithPojo {
	
	
	
	@Test
	public void postMethod() {
		
		//object creation
		PojoTest pojo=new PojoTest("xyz", "male", Reusable.randomEmailID(), "active");
		
		
		//post
		RestAssured.baseURI="https://gorest.co.in";
		
		Response postResponse=given().log().all().header("Authorization","Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378")
				.header("Content-Type","application/json")
		.body(pojo)//ser
		.when().post("/public/v2/users")
		.then().log().all().extract().response();
		
		System.out.println(postResponse);
		
	//Deser
		//json to Object
		ObjectMapper object=new ObjectMapper();
		PojoTest objectPojo = null;
		try {
			 objectPojo=object.readValue(postResponse.asString(), PojoTest.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int id=objectPojo.getId();
		System.out.println(id);
		Assert.assertNotNull(id);
		
		String email=objectPojo.getEmail();
		System.out.println(email);
		
		
		
		
	}

}
