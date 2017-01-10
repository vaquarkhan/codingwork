package test.java.step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.java.modules.SignInAction;
import test.java.modules.SignoutAction;
import test.java.pageobjects.AutomationHomePage;
import test.java.pageobjects.LoginPage;

public class ShoppingCart {
	public WebDriver driver;
	// public List<HashMap<String,String>> datamap = DataHelper.data();
	public static List<HashMap<String, String>> datamap = null;

	public ShoppingCart() {
		driver = Hooks.driver;

		datamap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> sampleData = new HashMap<String, String>();
		sampleData.put("username", "cad3613");
		sampleData.put("password", "AZ2020az");
		System.out.println("Current data" + sampleData);
		datamap.add(sampleData);
	}

	@When("^I open cna.com website$")
	public void i_open_automationpractice_website() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(
				"https://www.cna.com/web/guest/cna/agentcenterpublic/!ut/p/b1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOJNDLy9Q3xMQo28jI1NDRz93Q1MDP28jUwCzIEKIpEVOPl5GgIV-AMJP1OD0GBD4vQb4ACOBoT0e-lHpefkJwGdGq4fhVexpSm6AiyOBSvA4xo_j_zcVP2C3NCIymBPXQBq-mkG/dl4/d5/L2dBISEvZ0FBIS9nQSEh/");
	}

	@When("^I sign in$")
	public void i_sign_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PageFactory.initElements(driver, AutomationHomePage.class);
		PageFactory.initElements(driver, LoginPage.class);

		SignInAction.Execute(driver, datamap.get(0));
	}

	@Then("^I sign out$")
	public void i_sign_out() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SignoutAction.Execute(driver);
	}

}