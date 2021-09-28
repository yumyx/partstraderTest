package Integration.util;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

public class LoggerUtil {
	static Logger logger ;
	static FileAppender appender;
	static String fileBase = "./test-output/log/";
	//public static void getLog(Class<?> clazz) {
	public static void getLog() {
		//String name = clazz.getSimpleName();
	//	logger = Logger.getLogger(clazz);
		System.out.println("#### In get log");
	/*	logger = Logger.getRootLogger();
	
		logger.removeAllAppenders(); // 清空Appender，特別是不想使用現存實例時一定要初期化  
		logger.setLevel(Level.INFO); // 设定Logger級別。  
		logger.setAdditivity(false); 
		
		appender  = new RollingFileAppender(); 
		PatternLayout layout = new PatternLayout();  
	    layout.setConversionPattern("[%d{yyyy-MM-dd HH:mm:ss}] %p %l : %m%n");
	    
	    appender.setLayout(layout);         
	    appender.setFile(fileBase+"/"+getTime("yyyy-MM-dd") + ".log");  // log输出路径
        appender.setEncoding("UTF-8"); // log的字符编码  
        appender.setAppend(false);  //日志合并方式： true:在已存在log文件后面追加 false:新log覆盖以前的log  
        appender.activateOptions();  // 适用当前配置  
        
        logger.addAppender(appender);*/
		
		
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
