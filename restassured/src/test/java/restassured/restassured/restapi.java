package restassured.restassured;

import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restapi {
	
      public static void main(String[] args) {
		// TODO Auto-generated method stub
	  System.out.println("hello");
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/1";
	  RequestSpecification http=RestAssured.given();
      Response res= http.request(Method.GET);
	  System.out.print(res.body().asString());
	  
	}

}
