package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiValidation {

	private static ApiValidation apiValidation;

	public Response response;

	public static ApiValidation getInstance() {
		if (apiValidation == null) {
			apiValidation = new ApiValidation();
		}
		return apiValidation;
	}

	/*public Response getResponseFromURI(String uri, String code) {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(code);
		return response;
	}*/
	public Response getResponseFromURI(String uri, String code) {
		RestAssured.baseURI = uri + code;
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.get()
				.then()
				.extract().response();
		return response;
	}

	public Response getResponseFromURIWithParams(String uri, String code) {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.param("q",code)
				.when()
				.get()
				.then()
				.extract().response();
		return response;
	}

	public String getNodeFromResponse(Response response, String key) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String value = jsonPathEvaluator.get(key);
		return value;

	}

	public String extractStoryID(String s) {
		String storyID = "";
		Pattern p = Pattern.compile("\\-([0-9]+)\\.");
		Matcher m = p.matcher(s);
		while (m.find()) {
			storyID = m.group(1);
		}
		return storyID;
	}
}
