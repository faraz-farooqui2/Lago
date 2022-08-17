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
gql.setQuery("{\"query\":\"mutation{\\r\\n  logout(\\r\\n    logoutInputDto:{\\r\\n      accessToken:\\\"eyJraWQiOiJ5a04wWWExKzJwNXVCNGNMM2F3TW5YXC9OQWVsQkxkdmRITmIxSyswNVN0bz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI0OTgyZjA4Ny1kZTFkLTQ1ZjYtYWQ5OS1lODQyODQ5MjViYzgiLCJjb2duaXRvOmdyb3VwcyI6WyJDb2xsZWN0b3IiXSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMi5hbWF6b25hd3MuY29tXC91cy1lYXN0LTJfTW5Qd0hDYzNpIiwiY2xpZW50X2lkIjoiMWFyOGdsajkydXA3dW1mMWszZ21yZ3NhOTMiLCJvcmlnaW5fanRpIjoiZjBmMzk5OGUtYmI5OS00YWEyLWIwZTctZTA1YWMwZjcxMzRmIiwiZXZlbnRfaWQiOiI3ZjA3NTVlYy1hYTBhLTQ0ZjgtOGRjYi1hNGM0MzZiNzdlZDciLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjUyODYxMjQ1LCJleHAiOjE2NTI4NjQ4NDUsImlhdCI6MTY1Mjg2MTI0NSwianRpIjoiYjFlZjBmZGMtYTc1YS00MjQ2LTg5YjQtNzhlZTkyMWEwNzg3IiwidXNlcm5hbWUiOiI0OTgyZjA4Ny1kZTFkLTQ1ZjYtYWQ5OS1lODQyODQ5MjViYzgifQ.xHU-sdE7JwaZdqzuzrWAvndz9LKKChKaSX46wgrxcS4sBhdokwwIplog8Qtav7kVAOGBGOMVdnpQdN13doo8y33uqCYUo8wAXdbGhujgOlIgiQzQsE54rqePAZQ41CeR0Em-zpdepfggeFr1YEffJGLrj1sMOoT-UVAUHkXMAEF1qeJjY2c9OwXdhdjxHgUVHGcop-_-zwKLf6dwH4h00c64HTgG_L4hI1ncKZUaLBOHYZo4-hnoJNveMVdesXHvtJ8SCWmHsX3VR_uzoQ_I_mRB5QGuRGTE2Iapy4jOAzzi7a_9FKdUF0-aQmfNf_Scq4Gs4n61UMtiuGP07AEPLw\\\"\\r\\n    }\\r\\n  )\\r\\n  {\\r\\n    message\\r\\n    statusCode\\r\\n    success\\r\\n    data\\r\\n  }\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()

def responseStatusCode = gql.verifyStatusCode(200)

def payload = gql.verifyPayloadContainsData()

if(responseStatusCode == payload.data.logout.statusCode) {
	
	LagoLogUtils.markPassed("Success : " + payload.data.logout.success.toString())
	LagoLogUtils.markPassed("Message : " + payload.data.logout.message.toString())
	LagoLogUtils.markPassed("Data : " + payload.data.logout.data.toString())

}else {
	LagoLogUtils.markFailed("Status Code : " + payload.data.logout.statusCode.toString())
	LagoLogUtils.markFailed("Success : " + payload.data.logout.success.toString())
	LagoLogUtils.markFailed("Message : " + payload.data.logout.message.toString())
	LagoLogUtils.markFailed("Data : " + payload.data.logout.data.toString())
}


