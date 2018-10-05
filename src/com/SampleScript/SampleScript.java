package com.SampleScript;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.when;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class SampleScript {

	
	
	@Test
	public static void validateResponse() {
		//Step1
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Step2
		
		given().
				param("input", "Museum%20of%20Contemporary%20Art%20Australia").
				param("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
				param("key", "AIzaSyCmb7tqBzV3k-3wJxZb1S-SeFnGLVVjpUc").
				param("inputtype", "textquery").
		
		when().
				get("/maps/api/place/findplacefromtext/json").
				
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
		.body("candidates.name[0]",equalTo("Museum of Contemporary Art Australia"));

	}

}
