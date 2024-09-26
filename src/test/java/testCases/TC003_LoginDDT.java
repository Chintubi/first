package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;
import utilites.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String password, String exp) {
		logger.info("**********starting TC_003LoginDDT***********");
		
		try {
		//HomePAge
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clicklogin();
		
		//LginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		//my account
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageExists();
		
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				map.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
			{
				Assert.fail();
			}
		
		logger.info("**********Finished TC_003LoginDDT************");
		
	}

}
