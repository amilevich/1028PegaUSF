package com.User;

import org.apache.log4j.*;

public interface LoggingUtil {
	
public static Logger logs = Logger.getRootLogger();
	
	public static void logFatal(String s)
	{
		logFatal(s);
	}
	
	public static void logError(String s)
	{
		logError(s);
	}
	public static void logInfo(String s)
	{
		logInfo(s);
	}
	public static void logWarn(String s)
	{
		logWarn(s);
	}
	public static void logDebug(String s)
	{
		logDebug(s);
	}
	
	public static void logTrace(String s)
	{
		logTrace(s);
	}
}


