package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement eMail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement passwordConfirm;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement agree;

	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement conformation;

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		eMail.sendKeys(email);
	}
	
	public void setphone(String num)
	{
		telephone.sendKeys(num);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
    public void cnfpassword(String pwd) {
    	passwordConfirm.sendKeys(pwd);
    }
	
    public void setAgree() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(agree));
        agreeButton.click();
    }

    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(btn_continue));
        continueButton.click();
    }
		// btn_continue.submit();

		// using actions class
		// Actions act=new Actions(driver);
		// act.moveToElement(btn_continue).click().build().perform(); 

		// using javascriptexecutor
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("argument[0].click();",btn_continue);

		// btn_continue.sendKeys(Keys.RETURN);

		// using wait
		// WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		// mywait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();
	

    public String checkConf() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOf(conformation));
            return confirmationElement.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
