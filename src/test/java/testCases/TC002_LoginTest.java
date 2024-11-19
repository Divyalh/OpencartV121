package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity", "Master"})
	public void verify_Login()
	{

	logger.info("***Starting TC001_LoginTest***");
	
	try 
	{
	//HomePage
	HomePage hp = new HomePage(driver);
	hp.clickMyaccount();
	hp.clickLogin();
	
	//Login
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	//myaccount
	MyAccountPage myacc= new MyAccountPage(driver);
	boolean target_page=myacc.isMyAccountPageExists();
	Assert.assertTrue(target_page);
	}
	catch(Exception e) 
	{
		Assert.fail();
	}
	logger.info("*** ending the test case***");
	
	}
}
