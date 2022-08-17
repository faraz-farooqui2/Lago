package com.lago
import com.kms.katalon.core.util.KeywordUtil
public class LagoLogUtils {
	private static String loggerPrefix = "[LAGO]:"
	public static void markError(String message){
		KeywordUtil.markError(loggerPrefix+message)
	}
	public static void markErrorAndStop(String message){
		KeywordUtil.markErrorAndStop(loggerPrefix+message)
	}
	public static void markPassed(String message){
		KeywordUtil.markPassed(loggerPrefix+message)
	}
	public static void markFailed(String message){
		KeywordUtil.markFailed(loggerPrefix+message)
	}
	public static void markFailedAndStop(String message){
		KeywordUtil.markErrorAndStop(loggerPrefix+message)
	}
	public static void markWarning(String message){
		KeywordUtil.markWarning(loggerPrefix+message)
	}
	public static void logInfo(String message){
		KeywordUtil.logInfo(loggerPrefix+message)
	}
}