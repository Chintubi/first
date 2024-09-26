package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("**************Starting TC001AccountRegistrationTest**************");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		arp.setFirstName("chintu");
		logger.info("Clicked on FirstName");
		
		arp.setLastName("das");
		logger.info("Clicked on Last name");
		arp.setEmail("cchfinnthhdhgkgftuu@gmail.com"); //arp.setEmail(randomString()+"@gmail.com"); // randomly generated the email
		logger.info("Clicked on email");
		arp.setphone("565623565");
		logger.info("Clicked on telephone");
		arp.setPassword("chintu");
		logger.info("Clicked on password");
		arp.cnfpassword("chintu");
		logger.info("Clicked on Conf Password");
		
		
		arp.setAgree();
		logger.info("Clicked on agree btn");
		arp.clickContinue();
		logger.info("Clicked on continue btn");
		
		String confmsg=arp.checkConf();
		if (confmsg.equals("Your Account Has Been Created!"))
				{
					Assert.assertTrue(true);
				}
		else
		{
			logger.error("Test failed");
			logger.debug("debug logs...");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("********** Finish TestCases ***********");
	}
	
}















