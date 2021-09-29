package automation.util;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
	static Logger logger ;
	static FileAppender appender;
	static String fileBase = "./test-output/log/";
	//public static void getLog(Class<?> clazz) {
	public static void getLog() {

		String log4JPropertyFile = "resources\\log4j.properties";
	    PropertyConfigurator.configure(log4JPropertyFile);
		logger=Logger.getRootLogger();
		
	}
	public static void logInfo(String s) {
	    if(logger == null) {
	    	getLog();
	    }
		logger.info(s);
	    	
	}
	public static void errorInfo(String s) {
	    if(logger == null) {
	    	getLog();
	    }
		logger.error(s);
	    	
	}
	public static void debugInfo(String s) {
	    if(logger == null) {
	    	getLog();
	    }
		logger.debug(s);
	    	
	}
	private static String getTime(String format) {  
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(new Date());  
    }  
	public static void close() {
		appender.close();
	}
}
