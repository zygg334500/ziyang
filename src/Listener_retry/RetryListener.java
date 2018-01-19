package Listener_retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
public class RetryListener implements IAnnotationTransformer {
//����ʧ�ܣ��Զ�������һ�ߣ���дtransform����
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, 
Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestngRetry.class);//����TestngRetry�������Ĳ���ֵ�������Ƿ�Ҫ����
        }		
	}

}
