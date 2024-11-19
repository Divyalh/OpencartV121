package testCases;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")  //getting data from different class
	public void LoginDDT(String email, String password, String exp)
	{
		logger.info("**TC003_LoginDDT started***");
		try
		{
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
		
		/*Data is valid  - login success - test pass  - logout
		                  -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		                  -- login failed - test pass
		*/
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(target_page==true)
			{
				myacc.ClickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(target_page==true)
			{
				myacc.ClickLogout();
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
		logger.info("**TC003_LoginDDT ended***");
	}
}
