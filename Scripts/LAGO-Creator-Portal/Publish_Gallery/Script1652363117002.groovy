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
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.lago.LagoLogUtils
import com.lago.Utility
import controllers.CommonMethodController

WebDriver driver = DriverFactory.getWebDriver()
try {

	if(WebUI.waitForElementPresent(btn_Publish, 30)) {
		WebUI.click(btn_Publish)
		LagoLogUtils.markPassed("Clicked on Publish Gallery")
		if(WebUI.waitForElementPresent(verification_Publish_Success, 60)) {

			LagoLogUtils.markPassed("Gallery Published successfully")
		}
		else {
			LagoLogUtils.markFailed("Gallery not Published")
		}
	}else if(WebUI.waitForElementPresent(btn_Publish_Disable, 30)) {
		LagoLogUtils.markPassed("Gallery already Published")
	}else {
		LagoLogUtils.markFailed("Publish Gallery button not found")
	}

}catch(Exception e) {
	e.printStackTrace().toString()
}

