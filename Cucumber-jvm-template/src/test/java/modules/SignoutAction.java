package test.java.modules;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import test.java.helpers.Log;
import test.java.pageobjects.AutomationHomePage;



public class SignoutAction {

	public static void Execute(WebDriver driver) throws Exception{
		
		AutomationHomePage.sign_out.click();
		Log.info("Sign out is performed");

		Reporter.log("Sign out is performed");

	}
}
