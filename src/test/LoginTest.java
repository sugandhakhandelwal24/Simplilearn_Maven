package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;


@Listeners(TestNGListenerExample.class)
public class LoginTest extends Baseclass {
	
	
	@Test(enabled=false)
	@Parameters({"username","password"})
	//
	public void LoginTestCase(String uname, String pwd) {

		
		LoginPage loginPageObj= new LoginPage();
		loginPageObj.Login(uname, pwd);
		
	}
	
	@Test
	public void LoginTestCase2() {

		
		LoginPage loginPageObj= new LoginPage();
		String uname = sheet.getRow(1).getCell(0).getStringCellValue();
        String pwd = sheet.getRow(1).getCell(1).getStringCellValue();
		loginPageObj.Login(uname, pwd);
		
	}
}
