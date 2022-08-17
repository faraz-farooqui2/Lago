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
import com.lago.Utility

try {
	if(WebUI.waitForElementPresent(btn_CreateAGallery, 10)) {
		LagoLogUtils.markPassed("Create A Gallery button is present")
		WebUI.click(btn_CreateAGallery)

		if(WebUI.waitForElementPresent(dialogue_create_a_gallery, 10)) {
			LagoLogUtils.markPassed("Create A Gallery dialogue is opened")

			if(Utility.isWindows()){
				String Slash = "\\\\"
				WebUI.uploadFile(btn_uploadFile, GlobalVariable.folderPath +Slash+ GlobalVariable.fileName_Gallery)
				LagoLogUtils.logInfo("Image uploaded successfully")
			}else if(Utility.isMac()){
				String Slash = "/"
				WebUI.uploadFile(btn_uploadFile, GlobalVariable.folderPathMac +Slash+ GlobalVariable.fileName_Gallery)
				LagoLogUtils.logInfo("Image uploaded successfully")
			}else {
				LagoLogUtils.logInfo("Image file does not exist")
			}

			if(WebUI.waitForElementPresent(input_nameField, 10)) {
				WebUI.click(input_nameField)
				WebUI.setText(input_nameField, input_nameFieldText)
				LagoLogUtils.markPassed("Name  " + input_nameFieldText + "  is set in name field")

				if(WebUI.waitForElementPresent(textArea_description, 10)) {
					WebUI.click(textArea_description)
					WebUI.setText(textArea_description, textArea_descriptionText)
					LagoLogUtils.markPassed("Description  " + textArea_description + "  is set in description text area")

					if(WebUI.waitForElementPresent(btn_create, 10)) {
						WebUI.click(btn_create)
						LagoLogUtils.markPassed("Create button is present")
						
						if(WebUI.waitForElementPresent(verification_Gallery_Created, 60)) {
							LagoLogUtils.markPassed("Gallery Created Successfully")
	
						}else {
							LagoLogUtils.markFailed("Gallery not created")
						}
					}else {
						LagoLogUtils.markFailed("Create button is not present")
					}
				}else {
					LagoLogUtils.markFailed("Description is not set in description text area")
				}
			}else {
				LagoLogUtils.markFailed("Name is not set in name field")
			}

		}else {
			LagoLogUtils.markFailed("Create A Gallery dialogue is not opened")
		}
	}else {
		LagoLogUtils.markFailed("Create A Gallery button is not present")
	}

}catch(Exception e) {
	e.printStackTrace().toString()
}