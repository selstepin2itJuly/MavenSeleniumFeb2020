package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Utility;

public class TestBase {

	public static WebDriver dr;
	public static Properties prop;
	public static String username;
	public static String password;
	public static String browserName;
	
	public static WebDriver getInstance() throws IOException {
		prop=new Properties();
		String configFile="./src/main/resources/config/config.properties";
		FileInputStream file= new FileInputStream(new File(configFile));
		prop.load(file);
		browserName = prop.getProperty("browser");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		System.out.println("Initializing Driver!");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications"); 
			//opt.addArguments("--start-fullscreen");
			//opt.addArguments("--incognito");
			opt.addArguments("--disable-infobars");
			//opt.addExtensions(new File("C:\\Users\\fakhr\\Downloads\\extension_1_7_1_2.crx"));
			opt.merge(cap);
			dr=new ChromeDriver(opt);
		} 
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("Firefoxdriver"));
			dr=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEdriver"));
			dr=new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("Edgedriver"));
			dr=new EdgeDriver();
		}
		else 
		{
			Throwable error=new Throwable(); 
			error.initCause(null);
		}
		dr.get(prop.getProperty("url"));
		return dr;
	}

	public static void scrollToElement (WebElement ele) {
		/*
		 * JavascriptExecutor je=(JavascriptExecutor) dr;
		 * je.executeScript("arguments[0].scrollIntoView(false);", ele);
		 * je.executeScript("window.scrollBy(0,400)", "");
		 */
		((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView(false);", ele);
		((JavascriptExecutor)dr).executeScript("window.scrollBy(0,400)", "");
	}
	public static void clickOnElementjs (WebElement ele) {
		/*
		 * JavascriptExecutor je=(JavascriptExecutor) dr;
		 * je.executeScript("arguments[0].scrollIntoView(false);", ele);
		 * je.executeScript("window.scrollBy(0,400)", "");
		 */
		((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView(false);", ele);
		((JavascriptExecutor)dr).executeScript("window.scrollBy(0,400)", "");
		((JavascriptExecutor)dr).executeScript("arguments[0].click();", ele);
		
	}
	
	public static void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(dr, 40);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public static void captureScreenshot() throws IOException {
		File f=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		System.out.println(Utility.getCurrentDate());
		FileHandler.copy(f, new File("C:\\Users\\fakhr\\Downloads\\"+Utility.getCurrentDate()+"_image.jpg"));
	}
}
