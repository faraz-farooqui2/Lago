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
gql.setQuery("{\"query\":\"{\\n    userInviteEmail(\\n        token: \\\"61f7eb142226e934641e24fe\\\",\\n    )\\n    {\\n        id\\n        userId\\n        emailId\\n        role\\n    }\\n}\",\"variables\":{}}")

def response = gql.sendRequest()

def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


if(payload.data.userInviteEmail != null) {
	
	LagoLogUtils.markPassed("Id : " + payload.data.userInviteEmail.id)
	LagoLogUtils.markPassed("User Id : " + payload.data.userInviteEmail.userId)
	LagoLogUtils.markPassed("Email Id : " + payload.data.userInviteEmail.emailId)
	LagoLogUtils.markPassed("Role : " + payload.data.userInviteEmail.role)

}else {
	LagoLogUtils.markFailed("User Invite Email : " + payload.data.userInviteEmail)
	
}


