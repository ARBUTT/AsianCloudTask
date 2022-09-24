package TestCases;

import Objects.MiscObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Helpers.DriverBase;
import Helpers.StatusCheck;

public class NavigationTest extends DriverBase {

  MiscObject MiscObject = new MiscObject();
  public static SoftAssert softAssertionforlogin = new SoftAssert();
  public static SoftAssert softAssertionforloginstatus = new SoftAssert();
  StatusCheck statuscheckobj = new StatusCheck();

  @BeforeSuite
  public void BeforeSuit() {

    driver = new ChromeDriver();
    System.setProperty(MiscObject.Chrome, MiscObject.path + MiscObject.Browserpath);

  }

  @Test
  public void NavigationPage_01_navigateToUrl() {
    // navigate to the web site
    driver.get(MiscObject.URL);
    driver.manage().window().maximize();
    // Validate Sign IN Page
    Assert.assertEquals(driver.getTitle(), "Sign in to Asians - User System");
  }

  @Test
  public void NavigationPage_02_StatusCodeCheck() {

    String currenturl = driver.getCurrentUrl();
    int loginstatuscode = statuscheckobj.httpResponseCodeViaGet(currenturl);
    System.out.println("Page status code is " + loginstatuscode);

    softAssertionforloginstatus.assertEquals(loginstatuscode, 200, "login page doesnt have status 200..");
    softAssertionforloginstatus.assertAll();
  }

  @AfterSuite
  public void AfterSuit() {

    // close and quit the browser
    driver.quit();
  }
}