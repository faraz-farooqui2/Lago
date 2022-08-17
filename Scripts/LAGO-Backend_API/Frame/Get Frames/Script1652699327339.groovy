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
import groovy.json.JsonSlurper
import com.lago.LagoLogUtils
import com.lago.Utility

GQL gql = new GQL()
gql.setUrl(GlobalVariable.baseurl)
gql.setQuery("{\"query\":\"{\\r\\n  frames(getFramesDto:{userId:\\\"6229c090e20708b804d203e6\\\" status:CONNECTED }\\r\\n    paginationDto:{pageNo:1 pageSize:10}) {\\r\\n    id\\r\\n    frameId\\r\\n    status\\r\\n    batteryhealth\\r\\n    location\\r\\n    locationName\\r\\n    mobileDeviceId\\r\\n    volume\\r\\n    userId\\r\\n    ownerEmail\\r\\n    frameDeviceId\\r\\n    frameMac\\r\\n    framedAssets\\r\\n    {\\r\\n      assetId\\r\\n      dateAdded\\r\\n      assetUrl\\r\\n      assetType{\\r\\n          type\\r\\n      }\\r\\n      status\\r\\n    }\\r\\n    assets\\r\\n    {\\r\\n      name\\r\\n      assetUrl\\r\\n       assetType{\\r\\n          type\\r\\n      }\\r\\n      association\\r\\n    }\\r\\n    frameSettings\\r\\n    {\\r\\n      id\\r\\n      autoBrightness\\r\\n      brightness\\r\\n      userId\\r\\n    }\\r\\n    createdDate\\r\\n    createdby\\r\\n  }\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()

def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


	if(!payload.data.frames.toString().equals("[]")) {


		for (def member : payload.data.frames) {
			LagoLogUtils.logInfo("ID : " + member.id)
			LagoLogUtils.logInfo("Frame ID : " + member.frameId)
			LagoLogUtils.logInfo("Status : " + member.status)
			LagoLogUtils.logInfo("Battery Health : " + member.batteryhealth.toString())
			LagoLogUtils.logInfo("Location : " + member.location.toString())
			LagoLogUtils.logInfo("Location Name : " + member.locationName)
			LagoLogUtils.logInfo("Mobile Device Id : " + member.mobileDeviceId)
			LagoLogUtils.logInfo("Volume : " + member.volume.toString())
			LagoLogUtils.logInfo("User Id : " + member.userId)
			LagoLogUtils.logInfo("Owner Email : " + member.ownerEmail)
			LagoLogUtils.logInfo("Frame Device Id : " + member.frameDeviceId)
			LagoLogUtils.logInfo("Frame Mac : " + member.frameMac)

			for (def framedAssets : member.framedAssets) {
				LagoLogUtils.logInfo("Asset ID : " + framedAssets.assetId)
				LagoLogUtils.logInfo("Date Added : " + framedAssets.dateAdded.toString())
				LagoLogUtils.logInfo("Asset Url : " + framedAssets.assetUrl)
				LagoLogUtils.logInfo("Type : " + framedAssets.assetType.type)
				LagoLogUtils.logInfo("Status : " + framedAssets.status)
			}

			for (def assets : member.assets) {
				LagoLogUtils.logInfo("Name : " + assets.name)
				LagoLogUtils.logInfo("Asset Url : " + assets.assetUrl)
				LagoLogUtils.logInfo("Asset Type : " + assets.assetType.type)
				LagoLogUtils.logInfo("Association : " + assets.association)
			}

			LagoLogUtils.logInfo("Frame Settings : " + member.frameSettings)
			LagoLogUtils.logInfo("Created Date : " + member.createdDate)
			LagoLogUtils.logInfo("Created By : " + member.createdby)

		}

	}else {
		LagoLogUtils.markFailed("Get Frames data is " + payload.data.frames )
	}
