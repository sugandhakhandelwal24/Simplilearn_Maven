package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.LINUX);
		cap.setBrowserName("chrome");
		String sURL = "http://172.17.0.1:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(sURL),cap);
		driver.get("https://www.saucedemo.com/");
		driver.quit();
	}

}
