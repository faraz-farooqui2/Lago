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
gql.setQuery("{\"query\":\"{  \\r\\n  curationCollections(paginationDto:{pageNo:1 pageSize:10})  \\r\\n{      \\r\\n  id    \\r\\nassets\\r\\n    {      \\r\\n        name      \\r\\n        assetUrl      \\r\\n        createdby    \\r\\n    }    \\r\\ncurator\\r\\n        {\\r\\n            id      \\r\\n            name    \\r\\n        }    \\r\\nprice    \\r\\ntitle    \\r\\ndescription \\r\\nimageURL\\r\\n}\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()


def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


if(payload.data.curationCollections != null && !payload.data.curationCollections.toString().equals("[]")) {

	for (def curationCollections : payload.data.curationCollections) {
		LagoLogUtils.logInfo("ID : " + curationCollections.id)

		for (def assets : curationCollections.assets) {

			LagoLogUtils.logInfo("Asset Name : " + assets.name)
			LagoLogUtils.logInfo("Asset Url : " +  assets.assetUrl)
			LagoLogUtils.logInfo("Created By : " + assets.createdby)
		}

		LagoLogUtils.logInfo("Curator Id : " + curationCollections.curator.id)
		LagoLogUtils.logInfo("Curator Name : " + curationCollections.curator.name)
		LagoLogUtils.logInfo("Price : " + curationCollections.price)
		LagoLogUtils.logInfo("Title : " + curationCollections.title)
		LagoLogUtils.logInfo("Description : " + curationCollections.description)
		LagoLogUtils.logInfo("Image Url : " + curationCollections.imageURL)
	}
}else {
	LagoLogUtils.markFailed("Curation Collections : " + payload.data.curationCollections)
}