import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil
try {
	WebDriver driver = DriverFactory.getWebDriver()
	WebUI.navigateToUrl(url)
	WebUI.waitForPageLoad(30)

	TestObject svg = findTestObject('Object Repository/OR_SVG')
	TestObject video_mp4 = findTestObject('Object Repository/OR_MP4_VIdeo')
	TestObject video_wav = findTestObject('Object Repository/OR_WAV_Video')
	TestObject jpg = findTestObject('Object Repository/OR_JPG')
	TestObject image = findTestObject('Object Repository/OR_Image')
	TestObject canvas = findTestObject('Object Repository/OR_Canvas')
	TestObject video = findTestObject('Object Repository/OR_Video')


	if(assetType.equals("2")) {
		
		if(WebUI.waitForElementPresent(video, 5)) {
			
			
		video_url = driver.findElement(By.xpath("//body/video/source[@src='"+WebUI.getUrl()+"']"))
		KeywordUtil.markPassed("Correct Asset Type for Video >>> " + video_url)
		
		}else {
			KeywordUtil.markFailed("Asset Type Not Correct For Video >>>>>>>>>>> " + WebUI.getUrl())
			
		}
	}else if(assetType.equals("3")) {

		

		if(WebUI.waitForElementPresent(image, 5)) {

			image_url = driver.findElement(By.xpath("//body/img[@src='"+url+"']"))
			KeywordUtil.markPassed("Correct Asset Type for Image >>> " + image_url)

		}else if (WebUI.waitForElementPresent(canvas, 5)) {

			canvas_url = WebUI.getUrl()
			KeywordUtil.markPassed("Correct Asset Type for Canvas >>> " + canvas_url)

		}else if (WebUI.waitForElementPresent(video_wav, 5)) {
			
			wav_url = WebUI.getUrl()
			KeywordUtil.markPassed("Correct Asset Type for Wav >>> " + wav_url)

		}else if (WebUI.waitForElementPresent(svg, 5)) {
			
			svg_url = WebUI.getUrl()
			KeywordUtil.markPassed("Correct Asset Type for SVG >>> " + svg_url)
		}
		else {
			KeywordUtil.markFailed("Asset Type Not Correct For Image >>>>>>>>>>> " + WebUI.getUrl())
		}

	}else {
		String incorrect_url = WebUI.getUrl()
		KeywordUtil.markFailed("Asset Type not exist in Excel file for Asset >>> " + incorrect_url)

	}

	//	if(assetType.equals("2") && video_mp4) {
	//
	//		video_mp4_url = driver.findElement(By.xpath("//body/video/source[@src='"+url+"']"))
	//		KeywordUtil.markPassed("Correct Asset Type for Video MP4 >>> " + video_mp4_url)
	//
	//	}else if(assetType.equals("3") && video_wav) {
	//		video_wav_url = driver.findElement(By.xpath("//body/video/source[@src='"+url+"']"))
	//		KeywordUtil.markPassed("Correct Asset Type for Video >>> " + video_wav_url)
	//
	//	}else if(assetType.equals("3") && jpg ) {
	//		image_url = driver.findElement(By.xpath("//body/img[@src='"+url+"']"))
	//		KeywordUtil.markPassed("Correct Asset Type for JPG Image >>> " + image_url)
	//
	//	}else if(assetType.equals("3") && svg){
	//
	//		image_svg_url = driver.findElement(By.xpath("//svg"))
	//		KeywordUtil.markPassed("Correct Asset Type for SVG >>> " + image_svg_url)
	//	}
	//	else {
	//		String incorrect_url = WebUI.getUrl()
	//		KeywordUtil.markFailed("Incorrect URL >>> " + incorrect_url)
	//		WebUI.takeScreenshot()
	//	}
}catch (NoSuchElementException e) {
	KeywordUtil.markWarning(e.getMessage())
}