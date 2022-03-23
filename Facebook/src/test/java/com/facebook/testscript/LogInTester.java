package com.facebook.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.facebook.genaric.BaseClass;
import com.facebook.genaric.Filelib;
import com.facebook.pom.PageLogInOrSignUp;

public class LogInTester extends BaseClass{
	@Test
	public void loginPageTester() throws EncryptedDocumentException, IOException {
		Reporter.log("passed", true);
		PageLogInOrSignUp p1 = new PageLogInOrSignUp(driver);
//		Filelib f = new Filelib("./Support/GenaricData1.xlsx");
		p1.getEmailBox().sendKeys("directcommand88@gmail.com");//f.getExcelData("Sheet1", 2, 1)
		p1.getPasswordBox().sendKeys("$!tesh@150");//f.getExcelData("Sheet1", 2, 2)
		p1.getLoginButton().click();
	}
	@Test
	public void excel() throws EncryptedDocumentException, IOException {
		Filelib f = new Filelib("./Support/GenaricData1.xlsx");
		String lg = f.getExcelData("Sheet1", 2, 1);
		String pw = f.getExcelData("Sheet1", 2, 2);
		Reporter.log(lg);
		Reporter.log(pw);
		
	}
}
