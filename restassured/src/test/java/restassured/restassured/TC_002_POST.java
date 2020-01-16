package restassured.restassured;

import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC_002_POST {

	@Test(dataProvider = "insert")
	void insert_details(String name, String job) {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httprequest = RestAssured.given();

		JSONObject par = new JSONObject();
		par.put("name", name);
		par.put("job", job);
		httprequest.header("Content-Type", "application/json");
		httprequest.body(par.toJSONString());
		Response res = httprequest.request(Method.POST, "/api/users");
		String resbody = res.getBody().asString();
		System.out.println("body is " + resbody);
		int statuscode = res.getStatusCode();
		Assert.assertEquals(statuscode, 201);

	}

	@DataProvider(name = "insert")
	String[][] insertdata() {
		String data[][] = { { "a", "b" }, { "c", "d" } };
		String path = "/Users/lovekesh.madaan/Desktop/REST_ASSURED_API_TESTCASES.xlsx";

		return data;
	}

}
