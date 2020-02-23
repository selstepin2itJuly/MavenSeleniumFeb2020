package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCaseTwo {
	private WebDriver driver;
	LoginPage lp;
  @Test
  public void loginWrongUsername() {
	  lp.enterUsername("test");
	  Assert.assertTrue(lp.IsEmailErrorvisible());
		/*
		 * lp.enterPassword(TestBase.password); lp.clickOnLoginButton();
		 * Assert.assertTrue(lp.IsErrorvisible());
		 */
  }
  @Test
  public void loginWrongPassword() {
	  lp.enterUsername(TestBase.username);
	  lp.enterPassword("trsrewg");
	  lp.clickOnLoginButton();
	  Assert.assertTrue(lp.IsErrorvisible());
  }
  @Test
  public void loginWrongUsernameWrongPassword() {
	  lp.enterUsername("Test");
	  lp.enterPassword("test");
	  Assert.assertTrue(lp.IsEmailErrorvisible());
		/*
		 * lp.enterPassword("trsrewg"); lp.clickOnLoginButton();
		 * Assert.assertTrue(lp.IsErrorvisible());
		 */
  }
 
  @BeforeClass
  public void beforeClass() throws IOException {
	  driver=TestBase.getInstance();
	  lp=new LoginPage(driver);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  
}
