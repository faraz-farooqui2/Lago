package controllers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.lago.Utility
import com.lago.LagoLogUtils

public class FlutterLoginController {

	private static FlutterLoginController mInstance = null

	private FlutterLoginController(){
	}

	public static FlutterLoginController getInstance(){
		if(mInstance == null){
			mInstance = new FlutterLoginController()
		}

		return mInstance
	}

	public Login_flutter(String emailAddress , String password) {

		TestObject login = findTestObject('Object Repository/Flutter-Android/Lago/Login button main')
		TestObject email_field = findTestObject('Object Repository/Flutter-Android/Lago/Email field Login')
		TestObject next_btn = findTestObject('Object Repository/Flutter-Android/Lago/next btn')
		TestObject pwd_field = findTestObject('Object Repository/Flutter-Android/Lago/passowrd field login')
		TestObject login_btn = findTestObject('Object Repository/Flutter-Android/Lago/btn_login')
		
		
		//verify login button is displayed and tap
		if(Mobile.verifyElementExist(login, 30)) {
			LagoLogUtils.markPassed('Login button is dispalyed on Login landing page')
			Mobile.tap(login, 30)

			//Verify that email field is displayed and enter email
			if(Mobile.verifyElementExist(email_field, 30)) {
				LagoLogUtils.markPassed('Email filed is displayed')
				Mobile.tap(email_field, 30)
				Mobile.setText(email_field, emailAddress, 30)

				//verify next button is displayed and tap
				if(Mobile.verifyElementVisible(next_btn, 30)) {
					LagoLogUtils.markPassed('Next button is present')
					Mobile.tap(next_btn, 30)

					//Verify password filed is displayed and enter password
					if(Mobile.verifyElementExist(pwd_field, 30)) {
						LagoLogUtils.markPassed('Password filed dispalyed successfully')
						Mobile.setText(pwd_field, password, 30)

						//Verify login button is displayed and tap
						if(Mobile.verifyElementExist(login_btn, 30)) {
							LagoLogUtils.markPassed('Login button is displayed successfully')
							Mobile.tap(login_btn, 30)



						}else {
							LagoLogUtils.markFailed('Login button is not dispalyed')
						}

					}else {
						LagoLogUtils.markFailed('Password field is not dispalyed')
					}

				}else {
					LagoLogUtils.markFailed('Next button is not present')
				}

			}else {
				LagoLogUtils.markFailed('Email field is not dispalyed')
			}

		}else {
			LagoLogUtils.markFailed('Login button is not dispalyed on Login landing page')
		}

	}

}
