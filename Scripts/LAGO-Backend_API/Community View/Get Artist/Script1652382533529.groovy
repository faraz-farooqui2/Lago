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
gql.setQuery("{\"query\":\"{\\r\\n  artists(paginationDto: {\\r\\n      pageNo: 1,\\r\\n      pageSize: 5\\r\\n  })\\r\\n   {\\r\\n    emailAddress\\r\\n    name\\r\\n    profileImageUrl\\r\\n     collections{\\r\\n      id\\r\\n      price\\r\\n      title\\r\\n      imageURL\\r\\n    }\\r\\n      assets{\\r\\n          id\\r\\n       assetUrl\\r\\n       name\\r\\n       id\\r\\n       association\\r\\n       previewUrl\\r\\n     }\\r\\n  }\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()


def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


if(payload.data.artists != null && !payload.data.artists.toString().equals("[]")) {

	for (def member : payload.data.artists) {
		LagoLogUtils.logInfo("Email : " + member.emailAddress)
		LagoLogUtils.logInfo("Name: " + member.name)
		LagoLogUtils.logInfo("ProfileImageUrl: " + member.profileImageUrl)
		for (def collections : member.collections) {
			LagoLogUtils.logInfo("Collection Id: " + collections.id)
			LagoLogUtils.logInfo("Collection Price: " + collections.price.toString())
			LagoLogUtils.logInfo("Collection Title: " + collections.title)
			LagoLogUtils.logInfo("Collection ImageURL: " + collections.imageURL)
		}
		LagoLogUtils.logInfo("Assets : " + member.assets)
		for (def assets : member.assets) {
			LagoLogUtils.logInfo("Asset Id: " + assets.id)
			LagoLogUtils.logInfo("Asset Url: " + assets.assetUrl)
			LagoLogUtils.logInfo("Asset Name: " + assets.name)
			LagoLogUtils.logInfo("Asset Association: " + assets.association)
			LagoLogUtils.logInfo("Asset Preview Url: " + assets.previewUrl)
		}
	}


}else {
	LagoLogUtils.markFailed("Get Artist : " + payload.data.artists)
}
