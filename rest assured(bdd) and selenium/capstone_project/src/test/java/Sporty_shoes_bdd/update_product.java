package Sporty_shoes_bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class update_product {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("tester goes to the website to update")
	public void a_user_api_should_exist_to_add() {
		request = RestAssured.given().baseUri(BASE_URL);
	}

	@When("updates product by providing details")
	public void adds_product_by_providing_details() {
	    // Write code here that turns the phrase above into concrete actions
		response = request.when().post("/update-shoe?id=101&image=image_url&name=SampleShoe&category=Running&sizes=9&price=1000");

	}


	@Then("validate put request outcomes status code is {int}")
	public void validate_post_request_outcomes_status_code_is(Integer statusCode) {
		response.then().statusCode(statusCode);
	}

}
