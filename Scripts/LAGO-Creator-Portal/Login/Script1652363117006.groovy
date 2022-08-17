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
import com.lago.LagoLogUtils
try {

	if(WebUI.waitForElementPresent(txt_login, 10)) {
		LagoLogUtils.markPassed("User is on Login Page")

		if(WebUI.waitForElementPresent(txt_email, 10)) {
			LagoLogUtils.markPassed("User is on Email screen in Login Page")

			if(WebUI.waitForElementPresent(input_email_field, 10)) {
				LagoLogUtils.markPassed("Email input field is present")

				WebUI.setText(input_email_field, emailAddress)
				LagoLogUtils.logInfo("Email Address  :" + emailAddress + " sets in input field")

				if(WebUI.waitForElementPresent(btn_next, 10)) {
					WebUI.click(btn_next)
					LagoLogUtils.markPassed("Next button is clicked -- Email Screen")

					if(WebUI.waitForElementPresent(txt_password, 10)) {
						LagoLogUtils.markPassed("User is on Password screen in Login Page")

						if(WebUI.waitForElementPresent(input_password_field, 10)) {
							LagoLogUtils.markPassed("Password input field is present")

							WebUI.setText(input_password_field, password)
							LagoLogUtils.logInfo("Password  :" + password + " sets in input field")

							if(WebUI.waitForElementPresent(btn_next_password, 10)) {
								WebUI.click(btn_next_password)
								LagoLogUtils.markPassed("Next button is clicked -- Password Screen")

								if(WebUI.waitForElementPresent(msg_success, 10)) {
									
									String current_url = WebUI.getUrl()
									LagoLogUtils.logInfo("Current Page URL : "  + current_url)
									LagoLogUtils.markPassed("User logged in Successfully")

								}else {
									LagoLogUtils.markFailed("User not logged into Creator Portal")
								}

							}else {
								LagoLogUtils.markFailed("Next button in Password screen is not present")
							}

						}else {
							LagoLogUtils.markFailed("Password input field is not present")
						}
					}else {
						LagoLogUtils.markFailed("User is not on Password screen in Login Page")
					}

				}else {
					LagoLogUtils.markFailed("Next button in Email screen is not present")
				}

			}else {
				LagoLogUtils.markFailed("Email input field is not present")
			}
		}else {
			LagoLogUtils.markFailed("User is not on Email screen in Login Page")
		}

	}else {
		LagoLogUtils.markFailed("User is not on Login Page")
	}


}catch(Exception e) {

	e.printStackTrace().toString()
}finally {
	
}