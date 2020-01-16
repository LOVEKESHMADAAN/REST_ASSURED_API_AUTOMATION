package restassured.restassured;
import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_DELETE 
{
    
	@Test
	void delete_data()
	{
		RestAssured.baseURI="https://reqres.in";
    	RequestSpecification httprequest=RestAssured.given();
    	Response res=httprequest.request(Method.DELETE,"/api/users/2");
    	String resbody =res.getBody().asString();
    	System.out.println("body is "+resbody);
    	int statuscode =res.getStatusCode();
    	Assert.assertEquals(statuscode, 204);
		
		
	}

}
