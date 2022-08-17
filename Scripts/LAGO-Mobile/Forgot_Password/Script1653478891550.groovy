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

if (Mobile.waitForElementPresent(loginbtn, 30)) {
	LagoLogUtils.markPassed('Login button present')
	Mobile.tap(loginbtn, 30)

	if (Mobile.waitForElementPresent(forgotpwd_link, 30)) {
		LagoLogUtils.markPassed('Forgot password link present')
		Mobile.tap(forgotpwd_link, 30)

		if (Mobile.waitForElementPresent(email_field, 30)) {
			LagoLogUtils.markPassed('Email field present')
			Mobile.tap(email_field, 30)
			Thread.sleep(2000)
			Mobile.setText(email_field, 'lagocreator11@gmail.com', 30)

			if (Mobile.waitForElementPresent(Submit_btn, 30)) {
				LagoLogUtils.markPassed('Submit button present')
				Mobile.tap(Submit_btn, 30)


				String usernotexist = Mobile.getAttribute(user_notexist_text, 'content-desc' , 30)
				System.out.println(usernotexist)
				Mobile.verifyEqual(usernotexist, '')
				Thread.sleep(2000)

				if (Mobile.waitForElementPresent(email_field, 30)) {
					LagoLogUtils.markPassed('Email field present')
					Mobile.tap(email_field, 30)
					Thread.sleep(2000)
					Mobile.clearText(email_field, 30)
					Thread.sleep(2000)
					Mobile.setText(email_field, 'lagowalet1@gmail.com', 30)

					if (Mobile.waitForElementPresent(Submit_btn, 30)) {
						LagoLogUtils.markPassed('Submit button present')
						Mobile.tap(Submit_btn, 30)

						if (Mobile.waitForElementPresent(opt_field, 30)) {
							LagoLogUtils.markPassed('OTP field present')
							Mobile.tap(opt_field, 30)
							Mobile.setText(opt_field, '12345678', 30)

							if (Mobile.waitForElementPresent(newpwd_field, 30)) {
								LagoLogUtils.markPassed('New password field present')
								Mobile.tap(newpwd_field, 30)
								Mobile.setText(newpwd_field, 'P@ss1234', 30)

								if (Mobile.waitForElementPresent(submit_btn_newpwd, 30)) {
									LagoLogUtils.markPassed('Submit button present')
									Mobile.tap(submit_btn_newpwd, 30)


									String invalidotp = Mobile.getAttribute(invalid_otp_text, 'content-desc', 30)
									System.out.println(invalidotp)
									Mobile.verifyEqual(invalidotp, '')


								}else {LagoLogUtils.markFailed('Submit button not present')}

							}else {LagoLogUtils.markFailed('New password filed not present')}

						}else {LagoLogUtils.markFailed('OTP field not present')}

					}else {LagoLogUtils.markFailed('Submit button not present')}

				}else {LagoLogUtils.markFailed('Email field not present')}

			}else {LagoLogUtils.markFailed('Submit button not present')}

		}else {LagoLogUtils.markFailed('Email field not present')}

	}else {LagoLogUtils.markFailed('Forgot password link not present')}

}else {LagoLogUtils.markFailed('Login button not present')}
