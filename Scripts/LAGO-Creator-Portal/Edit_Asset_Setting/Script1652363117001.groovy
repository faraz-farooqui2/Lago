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
import controllers.CommonMethodController
try {
	if(CommonMethodController.getInstance().openAssetSetting()){
		LagoLogUtils.markPassed("Setting button is present")
//		if(WebUI.waitForElementPresent(verification_ethereum_field, 30)) {
//			LagoLogUtils.markPassed("Ethereum field is not editable")
//			if(WebUI.waitForElementPresent(verification_tokenId_filed, 10)) {
//				LagoLogUtils.markPassed("Token ID field is not editable")
//				if(WebUI.waitForElementPresent(verify_image_beforeChange, 10)) {
//				//	WebUI.takeScreenshotAsCheckpoint("Image Before Change", FailureHandling.STOP_ON_FAILURE)
//					LagoLogUtils.markPassed("Asset setting has image icon")
//					if(WebUI.waitForElementPresent(btn_changeImage, 60)) {
//
//						if(Utility.isWindows()){
//							String Slash = "\\\\"
//							WebUI.uploadFile(btn_changeImage, GlobalVariable.folderPath +Slash+ GlobalVariable.fileName_Asset)
//
//						}else if(Utility.isMac()){
//							String Slash = "/"
//							WebUI.uploadFile(btn_changeImage, GlobalVariable.folderPathMac +Slash+ GlobalVariable.fileName_Asset)
//
//						}else {
//							LagoLogUtils.logInfo("Image file does not exist")
//						}
				//		WebUI.takeScreenshotAsCheckpoint("Image After Change", FailureHandling.STOP_ON_FAILURE)

						if(WebUI.waitForElementPresent(edit_assetName, 10)) {
							String getName = WebUI.getAttribute(edit_assetName, 'value')
							LagoLogUtils.logInfo("Name field text value : " + getName)
							WebUI.click(edit_assetName)
							String field_name = 'document.querySelector("input[name=\'name\']").value = ""';
							WebUI.executeJavaScript(field_name, null);

							WebUI.setText(edit_assetName, input_name_edit_value)

							String getName_Edit = WebUI.getAttribute(edit_assetName, 'value')
							LagoLogUtils.logInfo("Name field edited text value : " + getName_Edit)
							if(getName != getName_Edit) {
								LagoLogUtils.markPassed("Name before Edit : " + getName + "  Name After Edit : " + getName_Edit)


								if(WebUI.waitForElementPresent(edit_assetDescription, 10)) {
									String getDescription = WebUI.getText(edit_assetDescription)
									LagoLogUtils.logInfo("Description field text value : " + getDescription)
									WebUI.click(edit_assetDescription)

									String field_desc = 'document.querySelector("textArea[name=\'description\']").value = ""';
									WebUI.executeJavaScript(field_desc, null);

									WebUI.setText(edit_assetDescription, input_name_edit_value)
									String getDescription_Edit = WebUI.getText(edit_assetDescription)
									LagoLogUtils.logInfo("Description field edited text value : " + getDescription_Edit)
									if(getDescription != getDescription_Edit) {
										LagoLogUtils.markPassed("Description before Edit : " + getDescription + "  Description After Edit : " + getDescription_Edit)

										if(WebUI.waitForElementPresent(btn_done, 10)) {
											WebUI.click(btn_done)
											LagoLogUtils.markPassed("Clicked on done button in Asset setting dialogue")

											if(WebUI.waitForElementPresent(verification_save_changes_success, 10)) {
												LagoLogUtils.markPassed("Settings have been updated")
											}else {
												LagoLogUtils.markFailed("Settings have not been updated")
											}
										}else {
											LagoLogUtils.markFailed("Done button is not present in Asset setting dialogue")
										}
									}else {
										LagoLogUtils.markFailed("Description not edit in Asset setting dialogue")
									}
								}else {
									LagoLogUtils.markFailed("Description field in Asset setting dialogue is not present")
								}
							}else {
								LagoLogUtils.markFailed("Name field not edit in Asset setting dialogue")
							}
						}else {
							LagoLogUtils.markFailed("Name field in Asset setting dialogue is not present")
						}
//					}else {
//						LagoLogUtils.markFailed("Change image button is not present")
//					}
//				}else {
//					LagoLogUtils.markFailed("Asset setting does not have image icon")
//				}
//			}else {
//				LagoLogUtils.markFailed("Token ID field is editable in Asset settings")
//			}
//		}else {
//			LagoLogUtils.markFailed("Ethereum field is editable in Asset settings")
//		}
	}else {
		LagoLogUtils.markFailed("Setting button not present")
	}

}catch(Exception e) {
	e.printStackTrace().toString()
}