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
gql.setQuery("{\"query\":\"{\\r\\n  collectors(paginationDto: {\\r\\n      pageNo: 1,\\r\\n      pageSize: 5\\r\\n  })\\r\\n  {\\r\\n      id\\r\\n    emailAddress\\r\\n    name\\r\\n    profileImageUrl\\r\\n    roles{\\r\\n        role\\r\\n    }\\r\\n    collections{\\r\\n      id\\r\\n      price\\r\\n      title\\r\\n      imageURL\\r\\n    }\\r\\n      assets{\\r\\n       assetUrl\\r\\n       name\\r\\n       id\\r\\n       association\\r\\n     }\\r\\n  }\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()


def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


if(payload.data.collectors != null && !payload.data.collectors.toString().equals("[]")) {

	for (def collectors : payload.data.collectors) {

		LagoLogUtils.logInfo("ID : " + collectors.id)
		LagoLogUtils.logInfo("Email Address : " + collectors.emailAddress)
		LagoLogUtils.logInfo("Name : " + collectors.name)
		LagoLogUtils.logInfo("Profile ImageURL : " + collectors.profileImageUrl)

		for (def roles : collectors.roles) {
			LagoLogUtils.logInfo("Role : " + roles.role)
		}
		
	//	LagoLogUtils.logInfo("Collections : " + collectors.collections)
		
		for (def collections : collectors.collections) {
			LagoLogUtils.logInfo("Collection Id : " + collections.id)
			LagoLogUtils.logInfo("Collection Price : " + collections.price)
			LagoLogUtils.logInfo("Collection Title : " + collections.title)
			LagoLogUtils.logInfo("Collection Image Url : " + collections.imageURL)
		}
		
		for (def assets : collectors.assets) {
			LagoLogUtils.logInfo("Asset URL : " + assets.assetUrl)
			LagoLogUtils.logInfo("Asset Name : " + assets.name)
			LagoLogUtils.logInfo("Asset Id : " + assets.id)
			LagoLogUtils.logInfo("Asset Association : " + assets.association)
		}

	}

}else {
	LagoLogUtils.markFailed("Get Collectors : " + payload.data.collectors.toString())
}
