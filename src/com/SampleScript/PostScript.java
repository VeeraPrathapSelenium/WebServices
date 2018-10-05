package com.SampleScript;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PostScript {
	public static  Properties prop;
	
	
	@BeforeTest
	
	
	public static void loadPropertiesFile() throws IOException
	{
		File f=new File("Env.properties");
		FileInputStream fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
		
		
		
	}
	@Test
	public static  void vlidatepost()
	{
		RestAssured.baseURI=prop.getProperty("BaseUrl");
		Response res=given().
		queryParam("key= "+prop.getProperty("Key")).
		body("{" + 
				"    \"location\":{\r\n" + 
				"        \"lat\" : -38.383494,\r\n" + 
				"        \"lng\" : 33.427362\r\n" + 
				"    },\r\n" + 
				"    \"accuracy\":50,\r\n" + 
				"    \"name\":\"Frontline house\",\r\n" + 
				"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
				"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
				"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
				"    \"website\" : \"http://google.com\",\r\n" + 
				"    \"language\" : \"French-IN\"\r\n" +"}").
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK"))
		.extract().response();
		System.out.println(res.asString());
		
		
		JsonPath jsnpth=new JsonPath(res.asString());
		
		jsnpth.get("place_id");
		
		
		System.out.println(jsnpth.get("place_id").toString());
		
		
		
		
		

	}

}
