package stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.ConfigFileReader;

public class PwnedCheck {

	// create an object on WebDriver class
	WebDriver driver;
	@FindBy(xpath = "//input[@id='Account']")
	WebElement searchIDBar;

	@FindBy(xpath = "//button[@id='searchPwnage']")
	WebElement SearchpwnedButton;

	@FindBy(xpath = "//h2[contains(text(),'Oh no — pwned!')]")
	WebElement PwnedtextMsg;

	@FindBy(xpath = "//h2[contains(text(),'Good news — no pwnage found!')]")
	WebElement NotPwnedMsg;

	ConfigFileReader configFileReader;

	@Given("User is on the HIBP home page")
	public void user_is_on_the_HIBP_home_page() {

		// Get the path below where Chrome driver application is located and configure
		configFileReader = new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());

		// initialize the web driver browser to point to chrome
		driver = new ChromeDriver();

		// get the url from configuration file
		System.out.println(configFileReader.getApplicationUrl());
		driver.get(configFileReader.getApplicationUrl());

		// maximize the window
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@When("User types a {string} into the search field")
	public void user_types_a_email_id_into_the_search_field(String id) {
		// Search the email id from the feature file and find out whether it is pawned
		// or not
		WebElement element = driver.findElement(By.name("Account"));
        element.sendKeys(id);
	}

	@And("User clicks on the pwned? button to search")
	public void user_clicks_the_Enter_key_on_the_keyboard() {
		// to click on the search button
		WebElement element = driver.findElement(By.id("searchPwnage"));
        element.submit();
	}

	@Then("message appears saying account is pwned or not")
	public void user_is_able_to_see_the_message_Oh_no_pwned() {
		// to display message in console informing about the status of breach
		try {
            if (isVisible(PwnedtextMsg)) {
                System.out.println("ID is pwned");
            } else if (isVisible(NotPwnedMsg)) {
            	System.out.println("ID is not pwned");
            } 
        } catch (Exception e) {
        	System.out.println("error occured while checking for id");
        } 

	}

	 public Boolean isVisible(WebElement element) {
	        try {
	            WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
	            webDriverWait.until(ExpectedConditions.visibilityOf(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
}}
