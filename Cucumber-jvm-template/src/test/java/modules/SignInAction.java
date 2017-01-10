package test.java.modules;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import test.java.helpers.Log;
import test.java.pageobjects.AutomationHomePage;
import test.java.pageobjects.LoginPage;


public class SignInAction {

	public static void Execute(WebDriver driver,HashMap<String,String> map) throws Exception{
		
		AutomationHomePage.sign_in.click();
		Log.info("Click action is perfromed on My Account link" );

		LoginPage.userId.sendKeys(map.get("userId"));

		Log.info(" is entered in UserName text box" );
		
		LoginPage.password.sendKeys(map.get("password"));
		Log.info(" is entered in Password text box" );

		LoginPage.btnGo2.click();
		Log.info("Click action is performed on Submit button");

		Reporter.log("SignIn Action is successfully perfomred");

	}
}
