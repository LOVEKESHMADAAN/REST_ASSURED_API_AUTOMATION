package restassured.restassured;
import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

    
public class TC001_GET {
    @Test
    void getdetails ()
    {
    	RestAssured.baseURI="https://reqres.in";
    	RequestSpecification httprequest=RestAssured.given();
    	Response res=httprequest.request(Method.GET,"/api/users/2");
    	String resbody =res.getBody().asString();
    	System.out.println("body is "+resbody);
    	int statuscode =res.getStatusCode();
    	Assert.assertEquals(statuscode, 200);
    	
    }





}
