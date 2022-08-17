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
import com.kms.katalon.core.util.KeywordUtil
import controllers.FlutterLoginController
import com.lago.LagoLogUtils
import com.lago.Utility


//Start the application
Mobile.startApplication(GlobalVariable.APK_Path, false)


FlutterLoginController.getInstance().Login_flutter(emailAddress, password)


////Verify user can see the login landing page
//if (Mobile.verifyElementExist(login, 30)) {
//	LagoLogUtils.markPassed('Login landing page opened successfully')
//
//	//verify login button is displayed
//	if(Mobile.verifyElementExist(login, 30)) {
//		LagoLogUtils.markPassed('Login button is dispalyed on Login landing page')
//		Mobile.tap(login, 30)
//
//		//Verify that email field is displayed and enter email
//		if(Mobile.verifyElementExist(email_field, 30)) {
//			LagoLogUtils.markPassed('Email filed is displayed')
//			Mobile.tap(email_field, 30)
//			Mobile.setText(email_field, 'lagocreator@gmail.com', 30)
//
//			//verify next button is displayed and tap
//			if(Mobile.verifyElementVisible(next_btn, 30)) {
//				LagoLogUtils.markPassed('Next button is present')
//				Mobile.tap(next_btn, 30)
//
//				//Verify password filed is displayed and enter password
//				if(Mobile.verifyElementExist(pwd_field, 30)) {
//					LagoLogUtils.markPassed('Password filed dispalyed successfully')
//					Mobile.setText(pwd_field, 'P@ss1234', 30)
//
//					//Verify login button is dispalyed and tap
//					if(Mobile.verifyElementExist(login_btn, 30)) {
//						LagoLogUtils.markPassed('Login button is displayed successfully')
//						Mobile.tap(login_btn, 30)

						//Verify profile tab is displayed and tap
						if(Mobile.verifyElementExist(profile_tab, 30)) {
							LagoLogUtils.markPassed('Profile button is displayed successfully')
							Mobile.tap(profile_tab, 30)

							
								//Verify logout link button is displayed and tap
								if(Mobile.verifyElementExist(del_acc_link, 30)) {
									LagoLogUtils.markPassed('Delete account link button is displayed successfully')
									Mobile.tap(del_acc_link, 30)

									//verify logout button is displayed and tap
									if(Mobile.verifyElementExist(del_acc_btn, 30)) {
										LagoLogUtils.markPassed('Delete account popup button is displayed successfully')
										Mobile.tap(del_acc_btn, 30)
										
										String delconfirmation = Mobile.getAttribute(confirm_msg_del, 'content-desc', 30)
										System.out.println(delconfirmation)
										Mobile.verifyEqual(delconfirmation, '')



									}else {LagoLogUtils.markFailed('Delete account popup button is not dispalyed')}

								}else {LagoLogUtils.markFailed('Delete account link button is not dispalyed')}


						}else {LagoLogUtils.markFailed('profile button is not dispalyed')}

//					}else {LagoLogUtils.markFailed('Login button is not dispalyed')}
//
//				}else {LagoLogUtils.markFailed('Password field is not dispalyed')}
//
//			}else {LagoLogUtils.markFailed('Next button is not present')}
//
//		}else {LagoLogUtils.markFailed('Email field is not dispalyed')}
//
//	}else {LagoLogUtils.markFailed('Login button is not dispalyed on Login landing page')}
//
//}else {LagoLogUtils.markFailed('Login landing page is not dispalyed')}