package Integration.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    	//annotation.setRetryAnalyzer(c);
    	//Class retry = annotation.getRetryAnalyzerClass();
    	//System.out.println(" ###  RetryListener:"+annotation.getTestName()+" "+retry.toString());
    	//if (retry == null) {
    //		System.out.println(" ### RetryListener:"+annotation.getTestName());
    	//System.out.println(" ###  RetryListener:"+annotation.getTestName());
        annotation.setRetryAnalyzer(TestRetry.class);
        //}
    }
}
