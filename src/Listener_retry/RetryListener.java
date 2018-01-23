package Listener_retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
public class RetryListener implements IAnnotationTransformer {
//用例失败，自动重新跑一边，重写transform方法
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, 
Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestngRetry.class);//根据TestngRetry传过来的布尔值，决定是否要重跑
        }		
	}

}
