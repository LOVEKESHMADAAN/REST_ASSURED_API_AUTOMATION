package restassured.restassured;



import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CONFIGFILEREADER.Config_file;
import DATA_DRIVEN.UTILITY_CLASS;
 
public class POST_READFORMXL {
     
	@Test(dataProvider = "insert")
	void insert_details(String name, String job, String expected) throws Exception {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httprequest = RestAssured.given();
		String path = Config_file.getConfigValue("url");
		JSONObject par = new JSONObject();
		par.put("name", name);
		par.put("job", job);
		httprequest.header("Content-Type", "application/json");
		httprequest.body(par.toJSONString());
		Response res = httprequest.request(Method.POST, "/api/users");
		String resbody = res.getBody().asString();
		String id=res.jsonPath().get("id");
		String name1=res.jsonPath().get("name");
		String job1=res.jsonPath().get("job");
		System.out.println("id is " + res.jsonPath().get("id"));
		System.out.println("body is " + resbody);
		int statuscode = res.getStatusCode();
		Assert.assertEquals(statuscode, Integer.parseInt(expected));
       // row++;
	}

	@DataProvider(name = "insert")
	String[][] insertdata() throws IOException {
		// String data[][]= {{"a","b"},{"c","d"}};
		String path = Config_file.getConfigValue("url");
		// String path
		// ="/Users/lovekesh.madaan/Desktop/REST_ASSURED_API_TESTCASES.xlsx";
		int rowc = UTILITY_CLASS.getRowCount(path, "sheet2");
		int colc = UTILITY_CLASS.getCellCount(path, "sheet2", 1);
		String data[][] = new String[rowc][colc];
		for (int i = 1; i <= rowc; i++) {
			for (int j = 0; j < colc; j++) {
				data[i - 1][j] = UTILITY_CLASS.getCellData(path, "sheet2", i, j);
			}

		}

		return data;
	}



}






