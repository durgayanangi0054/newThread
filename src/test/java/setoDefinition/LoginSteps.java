package setoDefinition;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Hooks;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage;
	

@Given("I am on the Rahul Shetty Academy login page")
public void i_am_on_the_rahul_shetty_academy_login_page() {
   driver= Hooks.getDriver();
    driver.get("https://rahulshettyacademy.com/client");
    utils.Log.info("Navigated to the login page");
    loginPage = new LoginPage(driver);
}

@When("I enter username {string} and password {string}")
public void i_enter_username_and_password(String string, String string2) {
	utils.Log.info("Entering username");
	loginPage.enterUsername(string);
	utils.Log.info("Entering password");
	loginPage.enterPassword(string2);
	
}

@When("I click the login button")
public void i_click_the_login_button() {
	utils.Log.info("Clicking the login button");
    loginPage.clickLoginButton();
}

@Then("I should be redirected to the homepage")
public void i_should_be_redirected_to_the_homepage() {
	utils.Log.info("Verifying redirection to homepage");
	Assert.assertEquals(loginPage.displaySignOutbutton(),"Sign Out");
}
}
