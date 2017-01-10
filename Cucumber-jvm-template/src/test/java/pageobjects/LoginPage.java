package test.java.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver){
		super(driver);
	}    

	
	@FindBy(how=How.ID, using="userId")
	public static WebElement userId;
	
	@FindBy(how=How.ID, using="passwd")
	public static WebElement password;
	
	@FindBy(how=How.ID, using="btnGo2")
	public static WebElement btnGo2;
	

	@FindBy(how=How.ID, using="email_create")
	public static WebElement email_create;

	@FindBy(how=How.ID, using="SubmitCreate")
	public static WebElement submit_create;
	
	
		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
