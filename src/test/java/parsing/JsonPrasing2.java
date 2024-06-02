package parsing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class JsonPrasing2 {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="https://fakestoreapi.com";
		
		String response=given()
				.when().get("/products")
				.then().extract().response().asString();
		System.out.println(response);
		
		//number of items //20
		
		int length= JsonPath.read(response, "$.length()");
		System.out.println("size "+length);
		
		//Print the all price where id is 3 --$[?(@.id==3)].price
		
		List<Double> price= JsonPath.read(response, "$[?(@.id==3)].price");
		System.out.println("price of id 3==> "+price);
		
		for(Double p:price) {
			System.out.println(p);
		}
		
		//print the title and prices of the products where category is jewelery --$[?(@.category=="jewelery")].title,price

		   List<Map<String,Object>> value = JsonPath.read(response, "$[?(@.category==\"jewelery\")].[\"title\",\"price\"]");
		System.out.println("==> "+value);
		
		
		for(Map<String,Object> val:value) {
			
			String title=(String) val.get("title");
			Object price1= val.get("price");
			System.out.println("titile===>"+title);
			System.out.println("price===>"+price1);
			System.out.println("====================");
			
		}
		
		
		
		
		
		
	}

}
