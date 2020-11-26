/*package com.scripted.apistepdefs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Listeners;

import com.scripted.Allure.AllureListener;
import com.scripted.api.RequestParams;
import com.scripted.api.RestAssuredWrapper;
import com.scripted.roi.ROIExeTime;

import io.cucumber.core.api.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



@Listeners({ AllureListener.class })
public class stepdefinitions {
	RequestParams Attwrapper = new RequestParams();
	RestAssuredWrapper raWrapper = new RestAssuredWrapper();
	private Scenario scenario;
	public String setComplexity;
	
	@Before("@High")
	public void setComplexityHigh(Scenario scenario) {
		this.scenario = scenario;
		setComplexity = "High";
		
	}
	@Before("@Medium")
	public void setComplexityMedium(Scenario scenario) {
		this.scenario = scenario;
		setComplexity = "Medium";

	}
	@Before("@Low")
	public void setComplexityLow(Scenario scenario) {
		this.scenario = scenario;
		setComplexity = "Low";
	}
	@Before
	public void beforeScenario(Scenario scenario) {
		ROIExeTime.startTime();
	}
	@After
	public void afterScenario(Scenario scenario) {
		try {
			String totalhours = ROIExeTime.endTime();
			//ROIAPIrequest.callROIApi(setComplexity,totalhours);			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Given("I have sample Get API")
	public void i_have_sample_get_api() throws Throwable {

	}

	@When("I send a {string} Request with {string} properties")
	public void i_send_a_something_request_with_something_properties(String strMethod, String strPropFileName)
			throws Throwable {
		raWrapper.setAPIFileProName(strPropFileName + ".properties");
		//RequestSpecification reqSpec = raWrapper.CreateRequest(Attwrapper);
		raWrapper.sendRequest(strMethod, reqSpec);
	}

	@Then("I should get response code {int}")
	public void i_should_get_response_code_something(int strCode) throws Throwable {
		raWrapper.valResponseCode(strCode);
	}

	@And("the response should contain:")
	public void the_response_should_contain(DataTable respTable) throws Throwable {
		List<Map<String, String>> resplist = respTable.asMaps(String.class, String.class);
		for (int i = 0; i < resplist.size(); i++) {
			String jsonPath = resplist.get(i).get("JsonPath");
			String expVal = resplist.get(i).get("ExpectedVal");

			if (expVal.matches("-?(0|[1-9]\\d*)")) {
				int intExpVal = Integer.parseInt(expVal);
				raWrapper.valJsonResponseVal(jsonPath, intExpVal);
			} else {
				raWrapper.valJsonResponseVal(jsonPath, expVal);
			}

		}

	}
}*/
