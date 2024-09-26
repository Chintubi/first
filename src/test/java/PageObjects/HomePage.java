package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	


	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;

	@FindBy(linkText="Login")
	WebElement login;

   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   
	public void clickMyAccount()
	{
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)); 
		myAccount.click();
	}
	public void clickRegister()
	{
		wait.until(ExpectedConditions.elementToBeClickable(register));
		register.click();
	}
	public void clicklogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
	}

}


//http://localhost/opencart/upload/
//http://localhost/opencart/upload/admin/
