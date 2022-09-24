package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Objects.LoginPageObjects;
import Objects.MiscObject;
import Helpers.DriverBase;

public class LoginCases extends DriverBase {

  LoginPageObjects loginObj = new LoginPageObjects();
  MiscObject MiscObject = new MiscObject();
  public static SoftAssert softAssertionforloginstatus = new SoftAssert();
  public static SoftAssert softAssertionforlogin = new SoftAssert();
  public static SoftAssert softAssertionforHomeVerification = new SoftAssert();

  @Test
  public void loginCases_01_Email_field_check() throws InterruptedException {

    boolean CheckEmailField = driver.findElement(By.xpath(loginObj.EmailInputField)).isDisplayed();
    softAssertionforlogin.assertTrue(CheckEmailField);
    softAssertionforlogin.assertAll();
  }

  @Test
  public void loginCases_02_Password_field_check() throws InterruptedException {

    boolean CheckPasswordField = driver.findElement(By.xpath(loginObj.PasswordInputField)).isDisplayed();
    softAssertionforlogin.assertTrue(CheckPasswordField);
    softAssertionforlogin.assertAll();
  }

  @Test
  public void loginCases_03_SignIn_Button_check() throws InterruptedException {

    boolean CheckSignInButton = driver.findElement(By.xpath(loginObj.SignInButton)).isDisplayed();
    softAssertionforlogin.assertTrue(CheckSignInButton);
    softAssertionforlogin.assertAll();
  }

  @Test
  public void loginCases_04_LoginWith_BothFieldsInvalidCreds_check() throws InterruptedException {

    driver.findElement(By.xpath(loginObj.EmailInputField)).sendKeys(MiscObject.InvalidEmail);
    driver.findElement(By.xpath(loginObj.PasswordInputField)).sendKeys(MiscObject.InvalidEmail);
    driver.findElement(By.xpath(loginObj.SignInButton)).click();
    driver.findElement(By.xpath(loginObj.EmailInputField)).clear();
    driver.findElement(By.xpath(loginObj.PasswordInputField)).clear();
  }

  @Test
  public void loginCases_05_LoginWith_EmailInvalidCreds_check() throws InterruptedException {

    driver.findElement(By.xpath(loginObj.EmailInputField)).sendKeys(MiscObject.InvalidEmail);
    driver.findElement(By.xpath(loginObj.PasswordInputField)).sendKeys(MiscObject.validPassword);
    driver.findElement(By.xpath(loginObj.SignInButton)).click();
    driver.findElement(By.xpath(loginObj.EmailInputField)).clear();
    driver.findElement(By.xpath(loginObj.PasswordInputField)).clear();
  }

  @Test
  public void loginCases_06_LoginWith_PasswordInvalidCreds_check() throws InterruptedException {

    driver.findElement(By.xpath(loginObj.EmailInputField)).sendKeys(MiscObject.validEmail);
    driver.findElement(By.xpath(loginObj.PasswordInputField)).sendKeys(MiscObject.InvalidPassword);
    driver.findElement(By.xpath(loginObj.SignInButton)).click();
    driver.findElement(By.xpath(loginObj.EmailInputField)).clear();
    driver.findElement(By.xpath(loginObj.PasswordInputField)).clear();
  }

  @Test
  public void loginCases_07_LoginWith_BothEmptyCreds_check() throws InterruptedException {

    driver.findElement(By.xpath(loginObj.EmailInputField)).sendKeys("");
    driver.findElement(By.xpath(loginObj.PasswordInputField)).sendKeys("");
    driver.findElement(By.xpath(loginObj.SignInButton)).click();
  }

  @Test
  public void loginCases_08_LoginWith_BothValidCreds_check() throws InterruptedException {

    driver.findElement(By.xpath(loginObj.EmailInputField)).sendKeys(MiscObject.validEmail);
    driver.findElement(By.xpath(loginObj.PasswordInputField)).sendKeys(MiscObject.validPassword);
    driver.findElement(By.xpath(loginObj.SignInButton)).click();
  }

  public void loginCases_09_VerifyLoggedIn() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, MiscObject.smallTimeOut);
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(MiscObject.HomeVerification), 0));
    boolean Homeverification = driver.findElements(By.xpath(MiscObject.HomeVerification)).size() > 0;
    softAssertionforHomeVerification.assertTrue(Homeverification);
    softAssertionforHomeVerification.assertAll();

  }

}