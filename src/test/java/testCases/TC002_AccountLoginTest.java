package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verif_login() {
		logger.info("**********Starting TC002_AccountLoginTest********");
		
		try {
		//HomePAge
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clicklogin();
		
		//LginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**********Finished TC002_AccountLoginTest********");
	}

}
