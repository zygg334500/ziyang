package com.example.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test02 {
	
	public static void main(String[] args){
		
		ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    //driver.get("http://cas.dev.teacheredu.cn/auth/login?service=http%3A%2F%2Fcas.dev.teacheredu.cn%2Fuc%2Findex.htm&renew=true&share=share&isGate=false");
	    driver.get("http://cas.dev.teacheredu.cn/auth/login?service=http%3A%2F%2Fcas.dev.teacheredu.cn%2Fuc%2Findex&renew=true&share=share&isGate=false");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("devstudent1");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123123");
	    driver.findElement(By.cssSelector("h3.login_kxdl")).click();
	    String pro_title = "//h1[@class='Wrap' and contains(text(),'测试项目')]/following-sibling::a";
	    driver.findElement(By.xpath(pro_title)).click();//点击第一个项目的去学习，xpath可以查找以某字符串开头的、结尾的或者是包含的元素
    	
	    java.util.Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄  
	    List<String> it = new ArrayList<String>(handles);
	    driver.switchTo().window(it.get(1));
		
	}
	
}
