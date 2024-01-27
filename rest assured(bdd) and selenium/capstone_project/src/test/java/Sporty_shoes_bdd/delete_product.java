package Sporty_shoes_bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class delete_product {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("tester goes to the website")
	public void a_user_api_should_exist_for_delete() {
		request = RestAssured.given().baseUri(BASE_URL);
	}

	@When("delete product by id {int}")
	public void a_user_deleted_by_userid(Integer Id) {
		response = request.pathParam("id", Id).when().delete("/delete-shoe?id={id}");

	}

	@Then("validate delete request outcomes status code is {int}")
	public void validate_delete_request_outcomes_status_code_is(Integer statusCode) {
		response.then().statusCode(statusCode);
	}
}
