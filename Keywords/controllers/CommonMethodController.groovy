package controllers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.lago.LagoLogUtils
import com.lago.Utility

public class CommonMethodController {

	private static CommonMethodController mInstance = null

	private CommonMethodController(){
	}

	public static CommonMethodController getInstance(){
		if(mInstance == null){
			mInstance = new CommonMethodController()
		}

		return mInstance
	}


	public boolean openGallery(){

		boolean result = false

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.delay(10)
		String list_galleries_xpath = findTestObject('Object Repository/Creator-Portal/OR_EDIT_GALLERY/list_open_gallery').findPropertyValue('xpath').toString()
		List<WebElement> list_galleries = driver.findElements(By.xpath(list_galleries_xpath))

		if(list_galleries.size() > 0) {
			list_galleries.get(0).click()
			LagoLogUtils.logInfo("Clicked on a Gallery")

			TestObject btn_AddAPiece = findTestObject('Object Repository/Creator-Portal/OR_EDIT_GALLERY/btn_AddAPiece')
			TestObject btn_Publish = findTestObject('Object Repository/Creator-Portal/OR_EDIT_GALLERY/btn_Publish')

			if(WebUI.waitForElementPresent(btn_AddAPiece, 10) && WebUI.waitForElementPresent(btn_Publish, 10)) {
				LagoLogUtils.markPassed("Gallery has opened")
				result = true
			}else {
				LagoLogUtils.markFailed("Gallery has not opened")
			}
		}
		else{
			LagoLogUtils.markFailed("Gallery not found  :   " + list_galleries.size())
		}
		return result
	}



	public boolean openMenu(){

		boolean result = false

		WebUI.delay(2)
		WebUI.refresh()

		TestObject Obj = findTestObject('Object Repository/Creator-Portal/OR_EDIT_GALLERY/btn_ThreeDotMenu')

		if(WebUI.waitForElementPresent(Obj, 30)) {
			WebUI.click(Obj)
			LagoLogUtils.logInfo("Clicked on Three Dot Menu")
			TestObject edit_gallery = findTestObject('Object Repository/Creator-Portal/OR_EDIT_GALLERY/btn_editGallery')
			TestObject delete_gallery = findTestObject('Object Repository/Creator-Portal/OR_EDIT_GALLERY/btn_deleteGallery')
			if(WebUI.waitForElementPresent(edit_gallery, 30) && WebUI.waitForElementPresent(delete_gallery , 30)){
				LagoLogUtils.logInfo("Three dot menu has opened")
				result = true
			}
			else{
				LagoLogUtils.markFailed("Three dot menu has opened")
			}
		}else {

			LagoLogUtils.markFailed("Three dot menu is not present within specified time")
		}

		return result
	}

	public boolean openAssetSetting(){

		boolean result = false

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.delay(10)
		String list_setting_xpath = findTestObject('Object Repository/Creator-Portal/OR_SETTINGS/btn_settings').findPropertyValue('xpath').toString()
		List<WebElement> list_setting = driver.findElements(By.xpath(list_setting_xpath))

		if(list_setting.size() > 0) {
			list_setting.get(0).click()
			LagoLogUtils.logInfo("Clicked on a Setting button")

			TestObject setting_dialogue = findTestObject('Object Repository/Creator-Portal/OR_SETTINGS/verification_setting_dialogue')

			if(WebUI.waitForElementPresent(setting_dialogue, 10)) {
				LagoLogUtils.markPassed("Setting dialogue has opened")
				result = true
			}else {
				LagoLogUtils.markFailed("Setting dialogue has not opened")
			}
		}
		else{
			LagoLogUtils.logInfo("Setting button not found  :   " + list_setting.size())
		}
		return result
	}

	public boolean openProfile(){

		boolean result = false

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.delay(2)

		TestObject Obj = findTestObject('Object Repository/Creator-Portal/OR_PROFILE/icon_profile_image')
		if(WebUI.waitForElementPresent(Obj, 30)) {
			WebUI.click(Obj)
			LagoLogUtils.logInfo("Clicked on Profile image")
			TestObject my_galleries = findTestObject('Object Repository/Creator-Portal/OR_PROFILE/btn_my_galleries')
			TestObject my_profile = findTestObject('Object Repository/Creator-Portal/OR_PROFILE/btn_my_profile')
			TestObject logout = findTestObject('Object Repository/Creator-Portal/OR_PROFILE/btn_logout')

			if(WebUI.waitForElementPresent(my_galleries, 30) && WebUI.waitForElementPresent(my_profile , 30) && WebUI.waitForElementPresent(logout , 30)){
				LagoLogUtils.logInfo("Profile dropdown has opened")
				result = true
			}
			else{
				LagoLogUtils.markFailed("Profile dropdown has not opened")
			}
		}else {

			LagoLogUtils.markFailed("Profile image is not present")
		}

		return result
	}

	public boolean logout(){

		boolean result = false

		if(openProfile()) {
			TestObject btn_logout = findTestObject('Object Repository/Creator-Portal/OR_PROFILE/btn_logout')
			WebUI.click(btn_logout)
			LagoLogUtils.logInfo("Clicked on log out")
			result = true
		}else {
			LagoLogUtils.markFailed("Log out button not clicked")
		}

		return result
	}
}

