package com.bxh.easyvrml.tools;

import java.util.Calendar;
import java.util.Locale;

public class Log {

	private static StringBuffer log = new StringBuffer();
	
	private static final int INFO    = 0;
	private static final int DEBUG   = 1;
	private static final int ERROR   = 2;
	private static final int WARNING = 3;
	
	private static int	INFO_COUNT	 = 0;
	private static int  DEBUG_COUNT  = 0;
	private static int  ERROR_COUNT  = 0;
	private static int WARNING_COUNT = 0;
	
	public static void logInfo(String info){
		logMessage(INFO , info);
	} 
	
	public static void logDebug(String info){
		logMessage(DEBUG , info);
	}
	
	public static void logError(String info){
		logMessage(ERROR , info);
	}
	
	public static void logWarning(String info){
		logMessage(WARNING , info);
	}
	
	public static void logMessage(int level,String mesg){
		String degree = "INFO";
		switch(level){
		case INFO:
			degree = "INFO";
			setINFO_COUNT(getINFO_COUNT() + 1);
			break;
		case DEBUG:
			degree = "DEBUG";
			setDEBUG_COUNT(getDEBUG_COUNT() + 1);
			break;
		case ERROR:
			degree = "ERROR";
			setERROR_COUNT(getERROR_COUNT() + 1);
			break;
		case WARNING:
			degree = "WARNING";
			setWARNING_COUNT(getWARNING_COUNT() + 1);
			break;
		}
		String format = String.format(Locale.getDefault(), "[%-7s] %-80s %-20s\n", degree, mesg , Calendar.getInstance().getTime().toLocaleString());
		setLog(getLog().append(format));
		System.out.print(format);
	}
	
	public static String showReport(){
		String s1 = "-------------------------------------------------------------------------------------------------------------------";
		System.out.println(s1);
		setLog(getLog().append(s1+"\n"));
		
		String s2 = String.format(Locale.getDefault(), "Error:%-7d Warning:%-7d Info:%-7d Debug:%-7d\n", getERROR_COUNT(), getWARNING_COUNT() ,getINFO_COUNT(),getDEBUG_COUNT());
		System.out.println(s2);
		setLog(getLog().append(s2));
		
		return getLog().toString();
	}

	public static int getINFO_COUNT() {
		return INFO_COUNT;
	}

	public static void setINFO_COUNT(int iNFO_COUNT) {
		INFO_COUNT = iNFO_COUNT;
	}

	public static int getDEBUG_COUNT() {
		return DEBUG_COUNT;
	}

	public static void setDEBUG_COUNT(int dEBUG_COUNT) {
		DEBUG_COUNT = dEBUG_COUNT;
	}

	public static int getERROR_COUNT() {
		return ERROR_COUNT;
	}

	public static void setERROR_COUNT(int eRROR_COUNT) {
		ERROR_COUNT = eRROR_COUNT;
	}

	public static int getWARNING_COUNT() {
		return WARNING_COUNT;
	}

	public static void setWARNING_COUNT(int wARNING_COUNT) {
		WARNING_COUNT = wARNING_COUNT;
	}

	public static int getInfo() {
		return INFO;
	}

	public static int getDebug() {
		return DEBUG;
	}

	public static int getError() {
		return ERROR;
	}

	public static int getWarning() {
		return WARNING;
	}

	public static StringBuffer getLog() {
		return log;
	}

	public static void setLog(StringBuffer log) {
		Log.log = log;
	}
	
}
