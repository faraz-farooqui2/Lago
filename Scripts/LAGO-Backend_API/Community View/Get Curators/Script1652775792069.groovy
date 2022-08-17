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
gql.setQuery("{\"query\":\"{\\r\\n  curators(paginationDto: {\\r\\n      pageNo: 1,\\r\\n      pageSize: 5\\r\\n  })\\r\\n   {\\r\\n     collections\\r\\n     {\\r\\n       id\\r\\n       description\\r\\n       collectionType\\r\\n       description\\r\\n       imageURL\\r\\n     }\\r\\n    emailAddress\\r\\n    name\\r\\n    roles {\\r\\n        role\\r\\n    }\\r\\n  }\\r\\n}\",\"variables\":{}}")

def response = gql.sendRequest()


def responseText = response.body().string()
JsonSlurper parser = new JsonSlurper()
def payload = parser.parseText(responseText)


if(payload.data.curators != null && !payload.data.curators.toString().equals("[]")) {

	for (def member : payload.data.curators) {

		for (def collections : member.collections) {
			LagoLogUtils.logInfo("ID : " + collections.id)
			LagoLogUtils.logInfo("Description : " + collections.description)
			LagoLogUtils.logInfo("Collection Type : " + collections.collectionType)
			LagoLogUtils.logInfo("ImageURL : " + collections.imageURL)

		}
		LagoLogUtils.logInfo("Email Address : " + member.emailAddress)
		LagoLogUtils.logInfo("Name: " + member.name)
		for (def roles : member.roles) {
			LagoLogUtils.logInfo("Role : " + roles.role)
		}

	}


}else {
	LagoLogUtils.markFailed("Curators : " + payload.data.curators.toString())
}
