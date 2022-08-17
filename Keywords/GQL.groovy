import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper
import internal.GlobalVariable
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

class GQL {

	public String url, query
	Response response

	@Keyword
	def setUrl(String url){
		this.url = url
	}

	@Keyword
	def setQuery(String query){
		this.query = query
	}

	@Keyword
	def sendRequest(){

		OkHttpClient client = new OkHttpClient().newBuilder().build()
		MediaType mediaType = MediaType.parse("application/json")
		RequestBody body = RequestBody.create(mediaType, this.query)
		Request request = new Request.Builder()
				.url(this.url)
				.method("POST", body)
				.addHeader("Content-Type", "application/json")
				.build();

		response = client.newCall(request).execute()

		return response
	}

	@Keyword
	def verifyStatusCode(int statusCode){
		assert response.code == statusCode
		def reponseStatus = response.code
		return reponseStatus
	}


	@Keyword
	def verifyPayloadContainsData(){
		def responseText = response.body().string()
		JsonSlurper parser = new JsonSlurper()
		def payload = parser.parseText(responseText)
		assert payload.data != null
		return payload
	}
}
