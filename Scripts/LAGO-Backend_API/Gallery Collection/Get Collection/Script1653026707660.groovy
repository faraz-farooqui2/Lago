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
gql.setQuery("{\"query\":\" { collection(collectionInputDto: { \\t\\r\\n       userId:\\\"620fb8187803c565a9441737\\\"\\r\\n      id:\\\"627bc59a3201c9bcd1f923db\\\" \\r\\n     }, paginationDto: {\\r\\n         pageNo: 1,\\r\\n         pageSize: 20,\\r\\n     })\\r\\n {   \\r\\n     id\\r\\n     title\\r\\n     userId\\r\\n     assets{\\r\\n         id\\r\\n         name\\r\\n        size\\r\\n        artCardEnable\\r\\n        artCardPrice\\r\\n        ownerName\\r\\n        ownerImageUrl\\r\\n        creatorName\\r\\n }\\r\\n  }\\r\\n}\\r\\n\",\"variables\":{}}")

def response = gql.sendRequest()


def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


if(payload.data.collection != null && !payload.data.collection.toString().equals("[]")) {

	for (def collection : payload.data.collection) {
		LagoLogUtils.logInfo("ID : " + collection.id)
		LagoLogUtils.logInfo("Title : " + collection.title)
		LagoLogUtils.logInfo("User Id : " + collection.userId)

		for (def assets : collection.assets) {

			LagoLogUtils.logInfo("Asset Id : " + assets.id.toString())
			LagoLogUtils.logInfo("Asset Name : " + assets.name)
			LagoLogUtils.logInfo("Size : " + assets.size)
			LagoLogUtils.logInfo("Art Card Enable : " + assets.artCardEnable)
			LagoLogUtils.logInfo("Art Card Price : " + assets.artCardPrice.toString())
			LagoLogUtils.logInfo("Owner Name : " + assets.ownerName)
			LagoLogUtils.logInfo("Owner Image Url : " + assets.ownerImageUrl)
			LagoLogUtils.logInfo("Creator Name : " + assets.creatorName)
		}
	}
}else {
	LagoLogUtils.markFailed("Get Collection : " + payload.data.collection)
}