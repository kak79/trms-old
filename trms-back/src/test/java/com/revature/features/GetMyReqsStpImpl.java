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

public class GetMyReqsStpImpl {

	public static WebDriver driver;

	@BeforeAll
	public static void setupDriver() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
	}

	@Given("Given The Employee is Logged In")
	public void given_the_employee_is_logged_in() {
		
	}
	
	@When("The Employee clicks on the link to My Submitted Requests")
	public void the_employee_clicks_on_the_link_to_my_submitted_requests() {
		driver.get("/Users/kimberlykohel-hayes/Documents/revature/p1-trms-kak79/trms-front/html/myreqs.html");
	}


	@Then("The Employee has requests and they are displayed")
	public void the_employee_has_requests_and_they_are_displayed() {

	}

	@Then("The Employee does not have requests so they are not displayed")
	public void the_employee_does_not_have_requests_so_they_are_not_displayed() {

	}

	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}
