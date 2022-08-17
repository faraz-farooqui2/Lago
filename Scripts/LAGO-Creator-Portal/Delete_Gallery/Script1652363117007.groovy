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
	if(CommonMethodController.getInstance().openMenu()){
		LagoLogUtils.markPassed("Three Dot Menu opens")
		if(WebUI.waitForElementPresent(btn_deleteGallery, 30)) {
			WebUI.click(btn_deleteGallery)
			LagoLogUtils.markPassed("Clicked on delete button")

			if(WebUI.waitForElementPresent(dialogue_deleteGallery, 30)) {
				LagoLogUtils.markPassed("Delete Gallery dialogue is open")

				if(WebUI.waitForElementPresent(btn_DeleteIt, 30)) {
					WebUI.click(btn_DeleteIt)
					LagoLogUtils.markPassed("Clicked on Delete button")
					if(WebUI.waitForElementPresent(msg_deleteSuccess, 30)) {
						LagoLogUtils.markPassed("Gallery Deleted Successfully")

					}else {
						LagoLogUtils.markFailed("Gallery has not Deleted Successfully")
					}

				}else {
					LagoLogUtils.markFailed("Delete button is not visible in specified time")
				}

			}else {
				LagoLogUtils.markFailed("Delete Gallery dialogue is not open")
			}

		}else {
			LagoLogUtils.markFailed("Delete button is not visible in specified time")
		}

	}else {
		LagoLogUtils.markFailed("Three Dot Menu not open")
	}

}catch(Exception e) {
	e.printStackTrace().toString()
}

