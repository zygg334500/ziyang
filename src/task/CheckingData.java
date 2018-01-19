package task;

import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import DateProvider.DateProvider;
import Interface.TestInfo;
import uti.Uti;

public class CheckingData implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
      @Test(groups = {"task"},dataProvider = "teacherFilePath",dataProviderClass = DateProvider.class)
  public void making(String username,String password,String filePath,String vedioPath) throws Exception {
    	Uti.ChromeBrowser_setup(driver, username, password);
	    
	    driver.findElement(By.partialLinkText("作业")).click();
        String submitdate= driver.findElement(By.xpath("(//span[@class='jindu_bl'])[1]")).getText();      //作业列表第一个作业的提交率
        String Qualifiedrate= driver.findElement(By.xpath("(//span[@class='jindu_bl'])[2]")).getText();    //作业列表第一个作业的合格率
        driver.findElement(By.xpath("(//a[contains(text(),'去批阅')])[1]")).click();
        String wtjs= driver.findElement(By.xpath("(//span[@class='orange'])[1]")).getText();                  //批阅详情页的未提交数
        String wpys= driver.findElement(By.xpath("(//span[@class='orange'])[2]")).getText();                 //批阅详情页的未批阅数
        String ypys= driver.findElement(By.xpath("(//span[@class='orange'])[3]")).getText();                  //批阅详情页的已批阅数
	    String submitdate2= driver.findElement(By.xpath("(//span[@class='jindu_bl'])[1]")).getText();     //从批阅详情页直接得到的提交率
        String Qualifiedrate2= driver.findElement(By.xpath("(//span[@class='jindu_bl'])[2]")).getText();   //从批阅详情页面直接得到合格率

	    int a= Integer.valueOf(wpys).intValue()+Integer.valueOf(ypys).intValue();
	    int b = Integer.valueOf(wtjs).intValue()+Integer.valueOf(wpys).intValue()+Integer.valueOf(ypys).intValue();
	    double c = (double)a/(double)b*100;
	    DecimalFormat formater = new DecimalFormat("#0.00");  
	    String d= formater.format(c);                             
	    String tijiaolv= d+"%";                                                                                                      //根据计算得到提交率百分比，只保留提交结果的后两位小数
	    
	    driver.findElement(By.linkText("不合格")).click();                                                                     //点击不合格按钮进行筛选	    
	    Thread.sleep(2000);
	    
	    String record=driver.findElement(By.xpath("//span[contains(text(),'记录')]")).getText();               //根据不合格共有多少记录，得到不合格数量
	    String str2 = record.replaceAll(" ", "");                                                                                 //去掉字符串中间的空格
	    String unqualified= str2.substring(str2.length()-4,str2.length()-3);                                          //截取字符串的第四位到第三位，取得不合格数量
	    double buhegelv= (double)Integer.valueOf(unqualified).intValue()/(double)Integer.valueOf(ypys).intValue();//不合格率=不合格数/已批阅总数
	    String phegelv= formater.format((1-buhegelv)*100);                                                             //1-不合格率得到合格率，乘以100得到合格百分比，套用函数得到只保留两位小数的合格百分比数
	    String hegelv= phegelv+"%";                                                                                             //根据计算得到合格百分比数
	    System.out.println(hegelv);
	    Assert.assertEquals(submitdate, submitdate2);                                                                    //验证全部列表显示的提交率与批阅详情页的提交率是相同的
	    Assert.assertEquals(Qualifiedrate, Qualifiedrate2);                                                               //验证全部列表显示的提交率与批阅详情页的提交率是相同的
	    Assert.assertEquals(submitdate, tijiaolv);                                                                           //验证显示的提交率与实际计算出来的提交率是相同的
	    Assert.assertEquals(Qualifiedrate, hegelv);                                                                         //验证显示的合格率与实际计算出来的合格率是相同的

	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
