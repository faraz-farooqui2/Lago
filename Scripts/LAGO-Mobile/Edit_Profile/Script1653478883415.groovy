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
import com.lago.LagoLogUtils
import com.lago.Utility

Mobile.startApplication(GlobalVariable.Lago_Staging_apk , false)


//if (Mobile.verifyElementExist(login_email, 30)) {
//	LagoLogUtils.markPassed('Login button present')
//	Mobile.tap(login_email, 30)
//
//	if (Mobile.verifyElementExist(email_field, 30)) {
//		LagoLogUtils.markPassed('Email field present')
//		Mobile.tap(email_field, 30)
//		Mobile.hideKeyboard()
//		Mobile.setText(email_field, 'lagocreator@gmail.com', 30)
//
//		if (Mobile.verifyElementExist(next_btn, 30)) {
//			LagoLogUtils.markPassed('Next button present')
//			Mobile.tap(next_btn, 30)
//
//			if (Mobile.verifyElementExist(pwd_field, 30)) {
//				LagoLogUtils.markPassed('Password filed present')
//				Mobile.setText(pwd_field, 'P@ss1234', 30)
//
//				if (Mobile.verifyElementExist(login_btn, 30)) {
//					LagoLogUtils.markPassed('Login button present')
//					Mobile.tap(login_btn, 30)

					if (Mobile.verifyElementExist(profile_tab, 30)) {
						LagoLogUtils.markPassed('Profile tab present')
						Mobile.tap(profile_tab, 30)
						Thread.sleep(4000)

						if (Mobile.verifyElementExist(edit_btn, 30)) {
							LagoLogUtils.markPassed('Edit button present')
							Mobile.tap(edit_btn, 30)
							Thread.sleep(4000)

							if (Mobile.verifyElementExist(edit_profile_image, 30)) {
								LagoLogUtils.markPassed('Edit porfile image button present')
								Mobile.tap(edit_profile_image, 30)

								if (Mobile.verifyElementExist(take_photo, 30)) {
									LagoLogUtils.markPassed('Take photo button present')
									Mobile.tap(take_photo, 30)

									if (Mobile.verifyElementExist(camera_tap, 30)) {
										LagoLogUtils.markPassed('Camera button present')
										Mobile.tap(camera_tap, 30)

										if (Mobile.verifyElementExist(camera_select, 30)) {
											LagoLogUtils.markPassed('Camera check button present')
											Mobile.tap(camera_select, 30)

											if (Mobile.verifyElementExist(save_profile_btn, 30)) {
												LagoLogUtils.markPassed('Save profile button present')
												Mobile.tap(save_profile_btn, 30)
												Thread.sleep(5000)

												if (Mobile.verifyElementExist(edit_btn, 30)) {
													LagoLogUtils.markPassed('Edit button present')
													Mobile.tap(edit_btn, 30)
													Thread.sleep(2000)

													if (Mobile.verifyElementExist(name_off, 30)) {
														LagoLogUtils.markPassed('Name field present')
														Mobile.tap(name_off, 30)
														Thread.sleep(2000)
														Mobile.clearText(name_clear, 30)
														Thread.sleep(2000)
														Mobile.setText(name_clear, 'Asad Musharaf', 30)
														Thread.sleep(2000)

														if (Mobile.verifyElementExist(about_off, 30)) {
															LagoLogUtils.markPassed('About field present')
															Mobile.tap(about_off, 30)
															Thread.sleep(2000)
															Mobile.clearText(about_clear, 30)
															Thread.sleep(2000)
															Mobile.setText(about_clear, 'This is a sample text input from automation script', 30)

															if (Mobile.verifyElementExist(save_profile_btn, 30)) {
																LagoLogUtils.markPassed('Save profile button present')
																Mobile.tap(save_profile_btn, 30)

																if (Mobile.verifyElementExist(toggle_off, 30)) {
																	LagoLogUtils.markPassed('Toggle button present')
																	Mobile.tap(toggle_off, 30)

																	if (Mobile.verifyElementExist(toggle_on, 30)) {
																		LagoLogUtils.markPassed('Toggle button present')
																		Mobile.tap(toggle_on, 30)

																		Mobile.closeApplication()


																	}else {LagoLogUtils.markFailed('Toggle button no present')}

																}else {LagoLogUtils.markFailed('Toggle button not present')}

															}else {LagoLogUtils.markFailed('Save profile button not present')}

														}else {LagoLogUtils.markFailed('About field not present')}

													}else {KeywordUtil.markFailed('Name field not present')}

												}else {LagoLogUtils.markFailed('Edit button not present')}

											}else {LagoLogUtils.markFailed('Save profile button not present')}

										}else {KeywordUtil.markFailed('Camera check button not present')}

									}else {KeywordUtil.markFailed('Camera button not present')}

								}else {KeywordUtil.markFailed('Take photo button not present')}

							}else {KeywordUtil.markFailed('Edit profile image button not present')}

						}else {KeywordUtil.markFailed('Edit button not present')}

					}else {KeywordUtil.markFailed('Profile tab not present')}
//
//				}else {LagoLogUtils.markFailed('Login button not present')}
//
//			}else {LagoLogUtils.markFailed('Password filed not present')}
//
//		}else {LagoLogUtils.markFailed('Next button not present')}
//
//	}else {LagoLogUtils.markFailed('Email field not present')}
//
//}else {LagoLogUtils.markFailed('Login button not present')}