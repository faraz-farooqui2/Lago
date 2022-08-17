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

	if(CommonMethodController.getInstance().openGallery()){

		if(CommonMethodController.getInstance().openMenu()){
			if(WebUI.waitForElementPresent(btn_EditGallery, 10)) {
				WebUI.click(btn_EditGallery)
				LagoLogUtils.markPassed("Clicked on Edit Gallery button")
				if(WebUI.waitForElementPresent(verify_CreateAGalleryDialogue, 10)) {
					LagoLogUtils.markPassed("Create A Gallery dialogue is present on Edit Gallery")
					if(WebUI.waitForElementPresent(verify_background_image, 10)) {
						LagoLogUtils.markPassed("Background image is present on Edit Gallery")
						if(WebUI.waitForElementPresent(input_name_edit, 10)) {
							String getName = WebUI.getAttribute(input_name_edit, 'value')
							LagoLogUtils.logInfo("Name field text value : " + getName)
							WebUI.click(input_name_edit)
							String field_name = 'document.querySelector("#name-input").value = ""';
							WebUI.executeJavaScript(field_name, null);
							WebUI.setText(input_name_edit, input_name_edit_value)
							String getName_Edit = WebUI.getAttribute(input_name_edit, 'value')
							LagoLogUtils.logInfo("Name field edited text value : " + getName_Edit)
							if(getName != getName_Edit) {
								LagoLogUtils.markPassed("Name before Edit : " + getName + "  Name After Edit : " + getName_Edit)


								if(WebUI.waitForElementPresent(input_description_edit, 10)) {
									String getDescription = WebUI.getText(input_description_edit)
									LagoLogUtils.logInfo("Description field text value : " + getDescription)
									WebUI.click(input_description_edit)

									String field_desc = 'document.querySelector("#description-input").value = ""';
									WebUI.executeJavaScript(field_desc, null);
									
									WebUI.setText(input_description_edit, input_description_edit_value)
									String getDescription_Edit = WebUI.getText(input_description_edit)
									LagoLogUtils.logInfo("Description field edited text value : " + getDescription_Edit)
									if(getDescription != getDescription_Edit) {
										LagoLogUtils.markPassed("Description before Edit : " + getDescription + "  Description After Edit : " + getDescription_Edit)
										if(WebUI.waitForElementPresent(btn_Save, 30)) {
											WebUI.click(btn_Save)
											LagoLogUtils.markPassed("Clicked on Save button")
											if(WebUI.waitForElementPresent(verification_Changes_Saved, 30)) {
												LagoLogUtils.markPassed("Changes saved successfully")
											}else {
												LagoLogUtils.markFailed("Changes not saved")
											}
										}else {
											LagoLogUtils.markFailed("Save button not present")
										}
									}else {
										LagoLogUtils.markFailed("Description not edit")
									}
								}else {
									LagoLogUtils.markFailed("Name text fied not present on Edit Gallery dialogue")
								}

							}else {
								LagoLogUtils.markFailed("Name not edit")
							}
						}else {
							LagoLogUtils.markFailed("Name text fied not present on Edit Gallery dialogue")
						}
					}else {
						LagoLogUtils.markFailed("Create A Gallery dialogue is not present on Edit Gallery")
					}
				}else {
					LagoLogUtils.markFailed("Background image is not present on Edit Gallery")
				}

			}else {
				LagoLogUtils.markFailed("Unable to click on Edit Gallery button")
			}
		}else{
			LagoLogUtils.markFailed("Menu not opened")
		}
	}else{
		LagoLogUtils.markFailed("Gallery not opened")
	}

}catch(Exception e) {
	e.printStackTrace().toString()
}

