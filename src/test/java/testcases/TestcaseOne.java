package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestcaseOne {
 private WebDriver driver;	
 LoginPage lp;
 DashboardPage dp;
  @Test
  public void LogingSuccessful() {
	 lp.enterUsername(TestBase.username);
	 lp.enterPassword(TestBase.password);
	 lp.clickOnLoginButton();
	 Assert.assertTrue(dp.isLogoutVisible());
  }
  @Test
  public void getListOfOptiononLeftPane() {
	  System.out.println("Test 2 - func2");
	  lp.enterUsername(TestBase.username);
	  lp.enterPassword(TestBase.password);
	  lp.clickOnLoginButton();
	  Assert.assertTrue(dp.isLogoutVisible());
	  List<String> str = dp.getListOfPane();
	  System.out.print(str);
	  Assert.assertEquals(str.size(), 10);
  }
  @Test
  public void getListofCards() {
	  System.out.println("Test 3 - func3");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.out.println("Before Method");
	  driver=TestBase.getInstance();
	  lp=new LoginPage(driver);
	  dp= new DashboardPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
	  driver.quit();
  }

	/*
	 * @BeforeClass public void beforeClass() throws IOException {
	 * System.out.println("Before Class");
	 * 
	 * }
	 * 
	 * @AfterClass public void afterClass() { System.out.println("After Class");
	 * 
	 * }
	 */
	/*
	 * @BeforeTest public void beforeTest() { System.out.println("Before Test"); }
	 * 
	 * @AfterTest public void afterTest() { System.out.println("After Test"); }
	 * 
	 * @BeforeSuite public void beforeSuite() { System.out.println("Before suite");
	 * }
	 * 
	 * @AfterSuite public void afterSuite() { System.out.println("After Suite"); }
	 */

}
