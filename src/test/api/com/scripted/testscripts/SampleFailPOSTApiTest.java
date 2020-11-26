package com.scripted.testscripts;

import com.scripted.api.RequestParams;
import com.scripted.api.RestAssuredWrapper;

import io.restassured.specification.RequestSpecification;

public class SampleFailPOSTApiTest {

	public static void main(String[] args) {		
		RequestParams Attwrapper = new RequestParams();
		RestAssuredWrapper raWrapper = new RestAssuredWrapper();
		Attwrapper.setJsonbody("PostApiJsonFailReq");
		raWrapper.setAPIFileProName("SampleFailPOSTApi.properties");
		RequestSpecification reqSpec = raWrapper.CreateRequest(Attwrapper);		
		raWrapper.sendRequest("Post",reqSpec);
		raWrapper.valResponseCode(400);
		raWrapper.valJsonResponseVal("error","Missing password");
	}
}
