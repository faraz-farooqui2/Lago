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

//if (Mobile.waitForElementPresent(login_email, 0)) {
//	LagoLogUtils.markPassed('Login button present')
//	Mobile.tap(login_email, 30)
//
//	if (Mobile.waitForElementPresent(email_field, 0)) {
//		LagoLogUtils.markPassed('Email field present')
//		Mobile.tap(email_field, 30)
//		Mobile.hideKeyboard()
//		Mobile.setText(email_field, 'lagocreator@gmail.com', 30)
//
//		if (Mobile.waitForElementPresent(next_btn, 0)) {
//			LagoLogUtils.markPassed('Next button present')
//			Mobile.tap(next_btn, 30)
//
//			if (Mobile.waitForElementPresent(pwd_field, 0)) {
//				LagoLogUtils.markPassed('Password field present')
//				Mobile.setText(pwd_field, 'P@ss1234', 30)
//
//				if (Mobile.waitForElementPresent(login_btn, 0)) {
//					LagoLogUtils.markPassed('Login button present')
//					Mobile.tap(login_btn, 30)

					if (Mobile.waitForElementPresent(frames_tab, 0)) {
						LagoLogUtils.markPassed('Frames tab menu button present')
						Mobile.tap(frames_tab, 30)

						if (Mobile.waitForElementPresent(add_frame, 0)) {
							LagoLogUtils.markPassed('Add frame button present')
							Mobile.tap(add_frame , 30)

							if (Mobile.waitForElementPresent(frame_conect_btn, 0)) {
								LagoLogUtils.markPassed('Connect to frame button present')
								Mobile.tap(frame_conect_btn, 30)

								if (Mobile.waitForElementPresent(wifi_field, 0)) {
									LagoLogUtils.markPassed('Wifi field present')
									Mobile.tap(wifi_field, 30)
									Mobile.setText(wifi_field, 'd3v1G1t@L', 30)

									if (Mobile.waitForElementPresent(done_btn, 0)) {
										LagoLogUtils.markPassed('Done button present')
										Mobile.tap(done_btn, 30)



									}else {LagoLogUtils.markFailed('Done button not present')}
									
								}else {LagoLogUtils.markFailed('Wifi field not present')}
								
							}else {LagoLogUtils.markFailed('Connect to frame button not present')}
							
						}else {LagoLogUtils.markFailed('Add frame button not present')}
						
					}else {LagoLogUtils.markFailed('Frames tab menu button not present')}
//					
//				}else {LagoLogUtils.markFailed('Login button not present')}
//				
//			}else {LagoLogUtils.markFailed('Password field not present')}
//			
//		}else {LagoLogUtils.markFailed('Next button not present ')}
//		
//	}else {LagoLogUtils.markFailed('Email field not present')}
//	
//}else {LagoLogUtils.markFailed('Login button not present')}