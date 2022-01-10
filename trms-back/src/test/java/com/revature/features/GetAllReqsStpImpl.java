package com.revature.features;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetAllReqsStpImpl {

	public static WebDriver driver;

	@BeforeAll
	public static void setupDriver() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
	}

	@Given("The Employee is on the home page")
	public void the_employee_is_on_the_home_page() {
		
	}
	
	@When("The home page is loaded")
	public void the_home_page_is_loaded() {
		driver.get("/Users/kimberlykohel-hayes/Documents/revature/p1-trms-kak79/trms-front/html/index.html");
	}


	@Then("The Reimbursement Requests Table loads with Requests in it")
	public void the_reimbursement_requests_table_loads_with_requests_in_it() {

	}


	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}
