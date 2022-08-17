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

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MultiTouchAction as MultiTouchAction
import io.appium.java_client.TouchAction as TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import com.lago.LagoLogUtils
import com.lago.Utility

Mobile.startApplication('/Users/mac/Downloads/app-release (5).apk', false)

if (Mobile.verifyElementExist(login, 0)) {
	LagoLogUtils.markPassed('Login landing page opened successfully')
	Mobile.tap(login, 0)

	if (Mobile.verifyElementExist(email_field, 0)) {
		LagoLogUtils.markPassed('Email field displayed')
		Mobile.tap(email_field, 2)
		Mobile.setText(email_field, 'lagocreator@gmail.com', 2)

		if (Mobile.verifyElementExist(next_btn, 0)) {
			LagoLogUtils.markPassed('Next button displayed')
			Mobile.tap(next_btn, 2)

			if (Mobile.verifyElementExist(pwd_field, 0)) {
				LagoLogUtils.markPassed('password field displayed')
				Mobile.tap(pwd_field, 2)
				Mobile.setText(pwd_field, 'P@ss1234', 2)

				if (Mobile.verifyElementExist(login_btn, 0)) {
					LagoLogUtils.markPassed('login button dispplayed')
					Mobile.tap(login_btn, 2)

					Thread.sleep(18000)
					
					AppiumDriver<?> driver = MobileDriverFactory.getDriver()
					
					action = new TouchAction (driver)
					
//					for ( int i = 1; i < 7; i++) {
					action.press(PointOption.point(677, 813))
					action.moveTo(PointOption.point(32, 802))
					action.release()
					action.perform()
					
					Thread.sleep(4000)
								
					action.press(PointOption.point(28, 823))
					action.moveTo(PointOption.point(683, 813))
					action.release()
					action.perform()
					

				}else {LagoLogUtils.markFailed('login button is not dispalyed')}

			}else {LagoLogUtils.markFailed('password field is not dispalyed')}

		}else {LagoLogUtils.markFailed('Next button is not dispalyed')}

	}else {LagoLogUtils.markFailed('email field is not dispalyed')}

}else {LagoLogUtils.markFailed('login landing page not displayed')}
