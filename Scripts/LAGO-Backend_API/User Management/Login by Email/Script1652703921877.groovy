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
gql.setQuery("{\"query\":\"mutation {\\r\\n  loginUserByEmail(loginInputDto: {emailAddress: \\\"lagowalet1@gmail.com\\\",\\r\\n   password: \\\"UEBzczEyMzQ=\\\"}) {\\r\\n    statusCode\\r\\n    success\\r\\n    message\\r\\n    data {\\r\\n      accessToken\\r\\n      expiresIn\\r\\n      idToken\\r\\n      refreshToken\\r\\n      tokenType\\r\\n      emailAddress\\r\\n      userId\\r\\n      username\\r\\n      roles {\\r\\n          role\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()

def responseStatusCode = gql.verifyStatusCode(200)

def payload = gql.verifyPayloadContainsData()

if(responseStatusCode == payload.data.loginUserByEmail.statusCode) {

		LagoLogUtils.logInfo("AccessToken : " + payload.data.loginUserByEmail.data.accessToken)
		LagoLogUtils.logInfo("Expires In : " + payload.data.loginUserByEmail.data.expiresIn.toString())
		LagoLogUtils.logInfo("Token Id : " + payload.data.loginUserByEmail.data.idToken)
		LagoLogUtils.logInfo("Refresh Token : " + payload.data.loginUserByEmail.data.refreshToken)
		LagoLogUtils.logInfo("Token Type : " + payload.data.loginUserByEmail.data.tokenType)
		LagoLogUtils.logInfo("Email Address : " + payload.data.loginUserByEmail.data.emailAddress)
		LagoLogUtils.logInfo("User Id : " + payload.data.loginUserByEmail.data.userId.toString())
		LagoLogUtils.logInfo("Username : " + payload.data.loginUserByEmail.data.username.toString())

		for (def role : payload.data.loginUserByEmail.data.roles) {
			LagoLogUtils.logInfo("Roles: " + role.role)
		}
}else {
	LagoLogUtils.markFailed("Status Code : " + payload.data.loginUserByEmail.statusCode.toString())
	LagoLogUtils.markFailed("Success : " + payload.data.loginUserByEmail.success.toString())
	LagoLogUtils.markFailed("Message : " + payload.data.loginUserByEmail.message.toString())
	LagoLogUtils.markFailed("Data : " + payload.data.loginUserByEmail.data.toString())
}


