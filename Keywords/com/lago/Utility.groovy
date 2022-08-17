package com.lago

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
import com.kms.katalon.core.configuration.RunConfiguration as RC
import internal.GlobalVariable

public class Utility {

	public static boolean isWindows(){
		String OS = System.getProperty("os.name").toLowerCase()
		return (OS.indexOf("win") >= 0)
	}

	public static boolean isMac(){
		String OS = System.getProperty("os.name").toLowerCase()
		return (OS.indexOf("mac") >= 0)
	}


	public static String getSlash(){
		if (isMac()){
			return "/"
		}
		if (isWindows()){
			return "\\\\"
		}
	}

	public static boolean isDefaultProfile(){
		def executionProfile = RC.getExecutionProfile()
		return executionProfile.equalsIgnoreCase("default")
	}

	public static boolean isStageProfile(){
		def executionProfile = RC.getExecutionProfile()
		return executionProfile.equalsIgnoreCase("stage")
	}

	public static boolean isProdProfile(){
		def executionProfile = RC.getExecutionProfile()
		return executionProfile.equalsIgnoreCase("prod")
	}
}
