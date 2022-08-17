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

	//	if(CommonMethodController.getInstance().openGallery()){
	WebUI.refresh()
	if(WebUI.waitForElementPresent(btn_AddAPiece, 10)) {
		WebUI.click(btn_AddAPiece)
		LagoLogUtils.markPassed("Clicked on Add A Piece button")

		if(WebUI.waitForElementPresent(btn_add_via_blockchain, 10)) {
			WebUI.click(btn_add_via_blockchain)
			LagoLogUtils.markPassed("Clicked on Add via Blockchain button")

			if(WebUI.waitForElementPresent(dialogue_add_via_blockchain, 10)) {
				LagoLogUtils.markPassed("Add via blockchain dialogue has opened")
				if(WebUI.waitForElementPresent(input_ethereum, 10)) {
					LagoLogUtils.markPassed("Ethereum Address field is present")
					WebUI.click(input_ethereum)
					LagoLogUtils.logInfo("Clicked on Ethereum Address field")
					WebUI.setText(input_ethereum, EthAddress)
					LagoLogUtils.logInfo(" Ethereum Address :  " + EthAddress + "  set in the ethereum input field")


					if(WebUI.waitForElementPresent(input_tokenId, 10)) {
						LagoLogUtils.markPassed("Token ID field is present")
						WebUI.click(input_tokenId)
						LagoLogUtils.logInfo("Clicked on Token ID field")
						WebUI.setText(input_tokenId, Token_ID)
						LagoLogUtils.logInfo(" Token ID :  " + Token_ID + "  set in the token id input field")

						if(WebUI.waitForElementPresent(verification_nftFetched, 30)) {
							LagoLogUtils.markPassed("NFT data is fetched successfully")

							if(WebUI.waitForElementPresent(verification_image, 30)) {
								LagoLogUtils.markPassed("NFT asset image is fetched")


								if(WebUI.waitForElementPresent(verification_name, 30)) {
									LagoLogUtils.markPassed("NFT asset name is fetched")

									if(WebUI.waitForElementPresent(btn_Add, 10)) {
										WebUI.click(btn_Add)
										LagoLogUtils.markPassed("Clicked on Add button")

										if(WebUI.waitForElementPresent(verification_nftAddedSuccessfully, 30)) {
											LagoLogUtils.markPassed("Asset Uploaded Successfully ")
										}else {
											LagoLogUtils.markFailed("Asset not Uploaded Successfully")
										}

									}else {
										LagoLogUtils.markFailed("Not clicked on Add button")
									}
								}else {
									LagoLogUtils.markFailed("NFT asset name is not fetched")
								}

							}else {
								LagoLogUtils.markFailed("NFT asset image is not fetched")
							}
						}else {
							LagoLogUtils.markFailed("NFT data is not fetched")
						}
					}else {
						LagoLogUtils.markFailed("Token ID field is not present")
					}
				}else {
					LagoLogUtils.markFailed("Ethereum Address field is not present")
				}

			}else {
				LagoLogUtils.markFailed("Add a Piece dialogue has not opened")
			}
		}else {
			LagoLogUtils.markFailed("Add via blockchain button is not present")
		}
	}else {
		LagoLogUtils.markFailed("Add A Piece button is not present")
	}
	//	}else{
	//		LagoLogUtils.markFailed("Gallery not found")
	//	}

}catch(Exception e) {
	e.printStackTrace()
}

