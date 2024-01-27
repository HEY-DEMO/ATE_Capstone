package ATE_capstone.capstone_project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sporty_shoes_selenium {
	 private static WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");

	        // Initialize ChromeDriver
	        driver = new EdgeDriver();

	        // Maximize the browser window
	        driver.manage().window().maximize();
	    }

	    @Test(description = "Test Login Page")
	    public void testLoginPage() {
	        // Navigate to the login page
	        driver.get("http://localhost:9010/");

	        // Perform actions on the login page (e.g., enter username and password)
	        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/form/button"));

	        usernameInput.sendKeys("john@example.com");
	        passwordInput.sendKeys("john123");
	        loginButton.click();
	        shot("login-success.png");

	    }
	    @Test(description = "Test Registration Page")
	    public void testRegistrationPage() {
	        // Navigate to the registration page
	        driver.get("http://localhost:9010/register");

	        // Perform actions on the registration page (e.g., fill out registration form)
	        WebElement NameInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[2]/form/button"));

	        NameInput.sendKeys("abc");
	        emailInput.sendKeys("abc@something.com");
	        registerButton.click();
	        shot("register-success.png");
	    }

	    @Test(description = "Test Add Product to Cart Page")
	    public void testAddProductToCartPage() throws InterruptedException {
	        // Navigate to the add product to cart page
	        driver.get("http://localhost:9010/");

	        // Perform actions on the login page (e.g., enter username and password)
	        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/form/button"));

	        usernameInput.sendKeys("john@example.com");
	        passwordInput.sendKeys("john123");
	        loginButton.click();
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.PAGE_DOWN).perform();

	        driver.findElement(By.xpath("//*[@id=\"cart201\"]")).click();
	        driver.findElement(By.xpath("//*[@id=\"shoe201\"]")).click();
	        driver.findElement(By.xpath("/html/body/div[4]/div/div/a")).click();
	        driver.findElement(By.xpath("//*[@id=\"mynavbar\"]/ul/li[1]/a")).click();

	        // Perform actions on the add product to cart page (e.g., select a product and add to cart)
	        driver.findElement(By.xpath("//*[@id=\"mynavbar\"]/ul/li[1]/a")).click();
	        shot("added-to-cart.png");
	       
	    }

	    @Test(description = "Test Place Order Page")
	    public void testPlaceOrderPage() {
	        // Navigate to the place order page
	    	driver.get("http://localhost:9010/");

	        // Perform actions on the login page (e.g., enter username and password)
	        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/form/button"));

	        usernameInput.sendKeys("john@example.com");
	        passwordInput.sendKeys("john123");
	        loginButton.click();
	        driver.findElement(By.xpath("//*[@id=\"mynavbar\"]/ul/li[1]/a")).click();
	        driver.findElement(By.xpath("//*[@id=\"place-order\"]")).click();
	        shot("order-placed.png");
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    private static void shot(String filename) {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File src = sc.getScreenshotAs(OutputType.FILE);
			try {
			FileHandler.copy(src, new File("output\\"+filename));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
