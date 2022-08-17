import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import com.lago.LagoLogUtils
import com.lago.Utility

Mobile.startApplication(GlobalVariable.Lago_Staging_apk, false)

if (Mobile.waitForElementPresent(login, 30)) {
	LagoLogUtils.markPassed('Login button present')
	Mobile.tap(login, 30)

	if (Mobile.waitForElementPresent(login_google, 30)) {
		LagoLogUtils.markPassed('Login with google button present')
		Mobile.tap(login_google, 30)

		if (Mobile.waitForElementPresent(email_field, 30)) {
			LagoLogUtils.markPassed('Email field present')
			Mobile.tap(email_field, 30)
			Mobile.hideKeyboard()
			Mobile.setText(email_field, 'lagowalet1@gmail.com', 30)

			if (Mobile.waitForElementPresent(email_next, 30)) {
				LagoLogUtils.markPassed('Next button is present')
				Mobile.tap(email_next, 0)

				if (Mobile.waitForElementPresent(password_field, 30)) {
					LagoLogUtils.markPassed('Password field is present')
					Mobile.tap(password_field, 30)
					Mobile.hideKeyboard()
					Mobile.setText(password_field, 'P@ss1234', 30)

					if (Mobile.waitForElementPresent(password_next, 30)) {
						LagoLogUtils.markPassed('Next button is present')
						Mobile.tap(password_next, 30)

						if (Mobile.waitForElementPresent(frameyourart_text, 30)) {
							LagoLogUtils.markPassed('Frame Your art collection text is displayed')


						}else {LagoLogUtils.markFailed('Frame your art collection text is not displayed')}
						
					}else {LagoLogUtils.markFailed('Next button is no present')}
					
				}else {LagoLogUtils.markFailed('Password field is not present')}
				
			}else {LagoLogUtils.markFailed('Next button is not present')}
			
		}else {LagoLogUtils.markFailed('Email field is not present')}
		
	}else {LagoLogUtils.markFailed('Login with google button is not present')}
	
}else {LagoLogUtils.markFailed('Login button is not present')}
