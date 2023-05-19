package com.utils;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;

public class RestUtils {

    /*Function to get response when send API get request*/
    public static Response sendGetRequest(String apiURL) {
         return sendGetRequest(apiURL, null);
    }

    /*Function to get response when send API get request*/
    public static Response sendGetRequest(String apiURL, String endpoint) {
        Response response=null;
        String baseURI=null;
        if(endpoint==null){
            baseURI=apiURL;
        }else{
            baseURI=apiURL+endpoint;
        }
        RestAssured.baseURI = baseURI;
        RequestSpecification request= RestAssured.given();
        request.header("Content-Type","application/json");
        response=request.get(baseURI);
        return response;
    }

    /*Function to get value from the response at given path*/
    public static String getValueFromResponse(Response response, String path){
        String value=null;
        value= JsonPath.read(response.asString(), path).toString();
        return value;
    }

    /*Function to get ArrayList from the response at given path*/
    public static ArrayList getArrayListFromResponse(Response response, String path){
        ArrayList value=null;
        value= JsonPath.read(response.asString(), path);
        return value;
    }

    /*Function to get Array length from the response at given path*/
    public static Integer getArrayLengthFromResponse(Response response, String path){
        try{
            Integer value=null;
            value= JsonPath.read(response.asString(), path+".length()");
            return value;
        }catch (Exception e){
            return null;
        }

    }

    /*Function to get check text contains in the response at given path*/
    public static boolean checkTextContainsInResponseBody(Response response, String expectedText, String elementName) {
        boolean verification = false;

        try {
            if(response.asString().contains(expectedText)){
                Utils.logStepInfo(true, elementName + " verified text contains successfully in Response Body");
                verification=true;
            }else{
                Utils.logStepInfo(false, elementName + " verification of text contains in Response Body failed. Response Body: "+response.asString()+", Expected : "+expectedText);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " verification of text contains in Response Body failed. Response Body: "+response.asString()+", Expected : "+expectedText);
        }
        return verification;
    }

    /*Function to send a get request with given header parameters */
    public static Response sendGetRequestWithHeader(String apiURL, String endpoint, HashMap<String,String> header) {
        Response response=null;
        String baseURI=null;
        if(endpoint==null){
            baseURI=apiURL;
        }else{
            baseURI=apiURL+endpoint;
        }
        RestAssured.baseURI = baseURI;
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification request= RestAssured.given();
        request.headers(header);
        response=request.get(baseURI);
        return response;
    }


}
