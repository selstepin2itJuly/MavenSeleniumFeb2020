package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private static WebDriver d;
	public LoginPage(WebDriver dr) {
		this.d=dr;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(css="#Email")
	WebElement username;
	
	@FindBy(css="#Password")
	WebElement password;
	
	@FindBy(css="#Email-error")
	WebElement emailError;
	
	@FindBy(css="[type='submit']")
	WebElement loginButton;
	
	@FindBy(css="[class='message-error validation-summary-errors']")
	WebElement error;
	public void enterUsername(String user) 
	{
		username.clear();
		username.sendKeys(user);
	}
	public void enterPassword(String user) 
	{
		password.clear();
		password.sendKeys(user);
	}
	public void clickOnLoginButton() 
	{
		loginButton.click();
	}
	public boolean IsEmailErrorvisible() {
		boolean b=false;
		try {
			waitForElement(emailError);
			b=emailError.isDisplayed();
		}catch(Exception e) 
		{
			
		}
		
		return b;
	}
	public boolean IsErrorvisible() {
		boolean b=false;
		try {
			waitForElement(error);
			b=error.isDisplayed();
		}catch(Exception e) 
		{
			
		}
		
		return b;
	}
	public static void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
