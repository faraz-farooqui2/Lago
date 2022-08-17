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

	//if(CommonMethodController.getInstance().openGallery()){

	if(WebUI.waitForElementPresent(btn_AddAPiece, 10)) {
		WebUI.click(btn_AddAPiece)
		LagoLogUtils.markPassed("Clicked on Add A Piece button")

		if(WebUI.waitForElementPresent(btn_upload_piece, 10)) {
			WebUI.click(btn_upload_piece)
			LagoLogUtils.markPassed("Clicked on Upload Piece button")

			if(WebUI.waitForElementPresent(dialogue_upload_piece, 10)) {
				LagoLogUtils.markPassed("Upload piece dialogue has opened")
				//			if(WebUI.waitForElementPresent(input_ethereum, 10)) {
				//				LagoLogUtils.markPassed("Ethereum Address field is present")
				//
				//				if(WebUI.waitForElementPresent(input_tokenId, 10)) {
				//					LagoLogUtils.markPassed("Token ID field is present")

				if(Utility.isWindows()){
					String Slash = "\\\\"
					WebUI.uploadFile(btn_uploadFile_Manual, GlobalVariable.folderPath +Slash+ GlobalVariable.fileName_Asset)

				}else if(Utility.isMac()){
					String Slash = "/"
					WebUI.uploadFile(btn_uploadFile_Manual, GlobalVariable.folderPathMac +Slash+ GlobalVariable.fileName_Asset)

				}else {
					LagoLogUtils.logInfo("Image file does not exist")
				}

				if(WebUI.waitForElementPresent(image_uploadedSuccess, 30)) {
					LagoLogUtils.markPassed("Image uploaded successfully")

					if(WebUI.waitForElementPresent(input_name_Manual, 30)) {
						WebUI.click(input_name_Manual)
						WebUI.setText(input_name_Manual, input_name_Manual_Value)
						LagoLogUtils.markPassed("Name  " + input_name_Manual_Value + "  is set in name field")

						if(WebUI.waitForElementPresent(textArea_description_Manual, 30)) {
							WebUI.click(textArea_description_Manual)
							WebUI.setText(textArea_description_Manual, input_description_Manual_Value)
							LagoLogUtils.markPassed("Description  " + input_description_Manual_Value + "  is set in description text area")

							if(WebUI.waitForElementPresent(btn_Add, 10)) {
								WebUI.click(btn_Add)
								LagoLogUtils.markPassed("Clicked on Add button")

								if(WebUI.waitForElementPresent(verification_uploadAssetSuccess, 60)) {
									LagoLogUtils.markPassed("Asset Uploaded Successfully ")
								}else {
									LagoLogUtils.markFailed("Asset not Uploaded Successfully")
								}

							}else {
								LagoLogUtils.markFailed("Not clicked on Add button")
							}
						}else {
							LagoLogUtils.markFailed("Description field is not present")
						}

					}else {
						LagoLogUtils.markFailed("Name field is not present")
					}
				}else {
					LagoLogUtils.markFailed("Image not uploaded")
				}
				//				}else {
				//					LagoLogUtils.markFailed("Token ID field is not present")
				//				}
				//			}else {
				//				LagoLogUtils.markFailed("Ethereum Address field is not present")
				//			}

			}else {
				LagoLogUtils.markFailed("Upload piece dialogue has not opened")
			}
		}else {
			LagoLogUtils.markFailed("Upload piece button is not present")
		}
	}else {
		LagoLogUtils.markFailed("Add A Piece button is not present")
	}
	//	}else{
	//		LagoLogUtils.markFailed("Gallery not found")
	//	}

}catch(Exception e) {
	e.printStackTrace().toString()
}

