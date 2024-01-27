package ATE_capstone.capstone_project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;


public class Sporty_shoes {
	@BeforeClass
    public void setUp() {
        // Set the base URI of your API
        RestAssured.baseURI = "http://localhost:9010"; 
    }

	@Test(description="retrieve all products")
	public void testGetProductList() {

		given().log().all()
        .when().get("/get-shoes")
        .then().log().all()
        .statusCode(200); // Add more assertions based on your requirements

    }
	@Test(description="retrieve all users")
	public void testGetusers() {

		given().log().all()
        .when().get("/get-users")
        .then().log().all()
        .statusCode(200); // Add more assertions based on your requirements
    }
	@Test(description="add product")
	public void testAddproduct() {

		given().log().all()
        .when().post("/add-shoe?id=101&image=image_url&name=SampleShoe&category=Running&sizes=9&price=1000")
        .then().log().all()
        .statusCode(200); // Add more assertions based on your requirements
    }
	@Test(description="delete product")
	public void testDeleteproduct() {

		given().log().all()
        .when().post("/delete-shoe?id=101")
        .then().log().all()
        .statusCode(405); // Add more assertions based on your requirements
    }
	@Test(description="update product")
	public void testUpdateproduct() {

		given().log().all()
        .when().put("/update-shoe?id=101&image=image_url&name=SampleShoe&category=Running&sizes=9&price=1000")
        .then().log().all()
        .statusCode(200); // Add more assertions based on your requirements
    }
	
}
