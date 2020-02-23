package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	private static WebDriver d;
	public DashboardPage(WebDriver dr) {
		this.d=dr;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//ul[@class='sidebar-menu tree']/li")
	List<WebElement> leftPane;
	//Get the logout visible
	public boolean isLogoutVisible() {
		boolean b=false;
		try {
			b=logout.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	
	public List<String> getListOfPane(){
		List<String> str=new ArrayList<String>();
		for(WebElement e:leftPane) {
			str.add(e.getText());
		}
		return str;
	}

}
