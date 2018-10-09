package GoogleMAPAPI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getAllPlaces {
	
	@Test
	public static void getAllPlacesAPI(){
		
		//Step 1: To get the Base URL
		RestAssured.baseURI="https://maps.googleapis.com";
		
		///Step 2: 
		Response res=given().
				param("location", "-33.8670522,151.1957362").
				param("radius", "1500").
				param("type", "restaurant").
				param("keyword", "cruise").
				param("key", "AIzaSyB7H0316xLzvKN2XgbAr-P2buShzhxbB2k").
				
		when().get("/maps/api/place/nearbysearch/json").
		
		then().assertThat().statusCode(200).and().extract().response();
		
		//System.out.println(res.asString());
		
		JsonPath json_obj= new JsonPath(res.asString());
		
		///System.out.println(json_obj.get("results.size()").toString());
		//System.out.println(json_obj.get("results[0].name").toString());
		
		for(int i=0; i<=(int) json_obj.get("results.size()")-1;i++)
		{
			
			System.out.println(json_obj.get("results["+i+"].name").toString());
		}
		
			
		
		
	}

}
