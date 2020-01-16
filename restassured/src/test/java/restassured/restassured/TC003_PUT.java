package restassured.restassured;
import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC003_PUT {

@Test
void put_data()
{

	RestAssured.baseURI="https://reqres.in";
	RequestSpecification httprequest=RestAssured.given();
	   JSONObject par=new JSONObject();
       par.put( "name","HELLO");
       par.put(  "job", "IT");
       httprequest.header("Content-Type","application/json");
       httprequest.body(par.toJSONString());
	Response res=httprequest.request(Method.PUT,"/api/users/2");
	
	
	String resbody =res.getBody().asString();
	System.out.println("body is "+resbody);
	int statuscode =res.getStatusCode();
	Assert.assertEquals(statuscode, 200);
	
}


}
