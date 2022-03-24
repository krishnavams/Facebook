package com.facebook.genaric;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void openUrl() {
		driver.get("https://www.facebook.com");
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);
	}
}/*
@BeforeTest
public void openBrowser() {
Reporter.log("openBrowser",true);
 driver=new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@AfterTest
public void closeBrowser() {
Reporter.log("closeBrowser",true);
driver.close();
}
@BeforeMethod
public void login() throws IOException {
Reporter.log("login",true);	
FileLib f=new FileLib();
String url = f.getPropertyData("url");
String un = f.getPropertyData("username");
String pw = f.getPropertyData("password");
driver.get(url);
LoginPage l=new LoginPage(driver);
l.setLogin(un, pw);

}
@AfterMethod
public void logout() {
Reporter.log("logout",true);	
HomePage h=new HomePage(driver);
h.setLogout();
}

}*/
