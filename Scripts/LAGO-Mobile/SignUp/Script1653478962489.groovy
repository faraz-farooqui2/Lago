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
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection
import com.detroitlabs.katalonmobileutil.touch.Scroll as Scroll
import com.detroitlabs.katalonmobileutil.touch.Scroll.ScrollFactor as ScrollFactor
import com.kms.katalon.core.util.KeywordUtil
import com.lago.LagoLogUtils
import com.lago.Utility

Mobile.startApplication(GlobalVariable.Lago_Staging_apk, false)

if (Mobile.waitForElementPresent(create_account, 30)) {
	LagoLogUtils.markPassed('Application opened and Landing page dispalyed')
	Mobile.tap(create_account, 30)

	if (Mobile.waitForElementPresent(email_btn, 30)) {
		LagoLogUtils.markPassed('Email button is dispalyed')
		Mobile.tap(email_btn, 30)


		if (Mobile.waitForElementPresent(email_f, 30)) {
			LagoLogUtils.markPassed('Email field is dispalyed')
			Mobile.setText(email_f, 'lagocreator@gmail.com', 30)

			Mobile.hideKeyboard()

			if (Mobile.waitForElementPresent(pwd_f, 30)) {
				LagoLogUtils.markPassed('Password filed is displayed')
				Mobile.tap(pwd_f, 2)
				Mobile.setText(pwd_f, 'P@ss1234', 30)

				if (Mobile.waitForElementPresent(next_btn, 30)) {
					LagoLogUtils.markPassed('Next button is dispalyed')
					Mobile.tap(next_btn, 30)

					CustomKeywords.'customswipe.swipe3x'()

					if (Mobile.waitForElementPresent(agree_term_btn, 30)) {
						LagoLogUtils.markPassed('Agree terms button is displayed')
						Mobile.tap(agree_term_btn, 0)

						CustomKeywords.'customswipe.swipe12x'()

						if (Mobile.waitForElementPresent(agree_privacy_btn, 30)) {
							LagoLogUtils.markPassed('Agree privay button is displayed')
							Mobile.tap(agree_privacy_btn, 0)

							if (Mobile.waitForElementPresent(back_to_login_btn, 30)) {
								LagoLogUtils.markPassed('Back to login button is displayed')
								Mobile.tap(back_to_login_btn, 0)





							}else {LagoLogUtils.markFailed('back to login button is not displayed')}

						}else {LagoLogUtils.markFailed('agree privacy button is not displayed')}

					}else {LagoLogUtils.markFailed('agree terms button is not displayed')}

				}else {LagoLogUtils.markFailed('next button is not displayed')}

			}else {LagoLogUtils.markFailed('password field is not dispalyed')}

		}else {LagoLogUtils.markFailed('Email field is not dispalyed')}

	}else {LagoLogUtils.markFailed('Email button is not dispalyed')}

}else {LagoLogUtils.markFailed('Login landing page is not dispalyed')}