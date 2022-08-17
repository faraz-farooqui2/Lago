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
gql.setQuery("{\"query\":\"{\\r\\n  userProfile(userId:\\\"620fb8187803c565a9441737\\\"){\\r\\n    about\\r\\n    name\\r\\n    profileImageUrl\\r\\n  }\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()

def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


if(payload.data.userProfile != null) {

	LagoLogUtils.logInfo("About : " + payload.data.userProfile.about)
	LagoLogUtils.logInfo("Name: " + payload.data.userProfile.name)
	LagoLogUtils.logInfo("ProfileImageUrl: " + payload.data.userProfile.profileImageUrl)

}else {
	LagoLogUtils.markFailed("userProfile : " + payload.data.userProfile.toString())
}


