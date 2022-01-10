package com.revature.features;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStepImpl {
	public static WebDriver driver;
	
	@FindBy(id="username")
	private WebElement usernameInput;
	@FindBy(id="password")
	private WebElement passwordInput;
	@FindBy(id="loginBtn")
	private WebElement loginBtn;

	@BeforeAll
	public static void setupDriver() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
	}

	@Given("Employee is on the Home Page")
	public void given_employee_is_on_the_home_page() {
		driver.get("/Users/kimberlykohel-hayes/Documents/revature/p1-trms-kak79/trms-front/html/index.html");
	}

//	@Given("Given Employee exists in the DataBase")
//	public void given_employee_exists_in_the_dataBase() {
//	}

	@And("Employee enters the correct <username>")
	public void given_employee_enters_the_correct_usrnm(String username) {
		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(username);
	}

	@And("Employee enters the correct <password>")
	public void given_employee_enters_the_correct_psswrd(String password) {
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
	}

	@When("Employee clicks Submit to LogIn")
	public void the_employee_clicks_the_submit_button_to_login() {
		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
		loginBtn.click();
	}

	@Then("nav bar will display {string}")
	public void the_navbar_says(String username) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.id("loginForm"), 1));

		WebElement navLink = driver.findElement(By.id("manageUser"));

		assertEquals(username, navLink.getText());

		driver.findElement(By.id("logout")).click();
	}

	@Then("Incorrect Credentials is displayed")
	public void the_page_says_incorrect_credentials() {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50)).ignoring(NoAlertPresentException.class);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		assertTrue(alert.getText().toLowerCase().contains("incorrect"));
		alert.accept();
	}

	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
}
