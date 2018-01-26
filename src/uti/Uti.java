package uti;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Uti {
 

	private static String current_time;
	//程序启动并进项目代码
	public static void ChromeBrowser_setup(WebDriver driver,String username,String password){
		
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    
	    //driver.get("http://cas.dev.teacheredu.cn/auth/login?service=http%3A%2F%2Fcas.dev.teacheredu.cn%2Fuc%2Findex.htm&renew=true&share=share&isGate=false");
	    driver.get("http://cas.dev.teacheredu.cn/auth/login?service=http%3A%2F%2Fcas.dev.teacheredu.cn%2Fuc%2Findex&renew=true&share=share&isGate=false");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.cssSelector("h3.login_kxdl")).click();
	    String pro_title = "//h1[@class='Wrap' and contains(text(),'测试项目')]/following-sibling::a";
	    driver.findElement(By.xpath(pro_title)).click();//点击第一个项目的去学习，xpath可以查找以某字符串开头的、结尾的或者是包含的元素
    	
	    java.util.Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄  
	    List<String> it = new ArrayList<String>(handles);
	    driver.switchTo().window(it.get(1));	
    }
	//切换窗口的方法
	public static void ChangeWindows(WebDriver driver, int index){
	    java.util.Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄  
	    List<String> it = new ArrayList<String>(handles);
	    driver.switchTo().window(it.get(index));	
	}
	
	//上传文件方法(去掉线程锁)
	public synchronized static void UploadFile(WebDriver driver, String path,String idname) throws Exception{
	    driver.findElement(By.id(idname)).click();
	    driver.findElement(By.id(idname)).click();
	    driver.findElement(By.id(idname)).click();
	    Runtime.getRuntime().exec(path);
	    Thread.sleep(6000);
	}
	
	//WebDriver的富文本输入方法
	public static void richText(WebDriver driver,int frame_index,String content){
		
		driver.switchTo().frame(frame_index);
		driver.findElement(By.tagName("body")).sendKeys(content);
		driver.switchTo().defaultContent();
		
	}
	//上传视频方法(去掉线程锁)
	public synchronized static void UploadVedio(WebDriver driver, String path) throws Exception{
	    driver.findElement(By.cssSelector("#uploadVideo")).click();    
	    Thread.sleep(1000);
	    
	    try {
		    while (true){
		    	driver.findElement(By.id("uploadList_li")).click();
			    driver.findElement(By.id("uploadswf")).click();
		        Thread.sleep(1000);
			    Runtime.getRuntime().exec(path); 
			    Thread.sleep(6000);
			    break;
		    }
			
		} catch (Exception e) {
		}
	    driver.findElement(By.id("uploadswf")).click();
        Thread.sleep(1000);
	    Runtime.getRuntime().exec(path); 
	    Thread.sleep(6000); 
	}
	//获取当前系统时间，带双引号的时间戳
	public static String  get_currenttime() throws Exception{
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Currentday =sdf.format(date);		
		current_time= "\""+Currentday+"\"";		
		return current_time;//带双引号的时间字符串
		
	}
	//获取当前系统时间,时间戳
	public static String  get_currenttime1() throws Exception{
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Currentday =sdf.format(date);				
		return Currentday;//不带双引号的时间字符串
	}
	
    //获取页面要查找元素的个数并点击处理所有页面下的该元素
	public static void getFindElementCount(WebDriver driver,String a) throws Exception{

	    int number = driver.findElements(By.linkText(a)).size();
		  //System.out.println(number);
          //查找当前页面所有要查找的元素的个数
        for(int i=0;i<number;i++){
      	     driver.findElement(By.linkText(a)).click();
			  driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.linkText("确定")).click();
			  driver.navigate().refresh();
			  Thread.sleep(1000);
        }
	}
	
	
    //获取页面要查找元素的个数并点击点击所有页面下的该元素并返回浏览器上一页
	public static void getFindElementCount1(WebDriver driver,String a) throws Exception{

	    int number = driver.findElements(By.linkText(a)).size();
		  //System.out.println(number);
          //查找当前页面所有要查找的元素的个数
        for(int i=0;i<number;i++){
      	     //driver.findElement(By.linkText(a)).click();
        	driver.findElement(By.xpath("(//a[contains(text(),a)])[i+1]")).click();
        	 Thread.sleep(2000);
			 driver.navigate().back();
			 Thread.sleep(2000);
			 Thread.sleep(1000);
        }
	}
	//实现拖拽效果
	public static void dragHuodongStep(WebElement element1,WebElement element2,WebDriver driver) throws Exception{
		   Actions actions = new Actions(driver);  
		   Action dragaction=actions.clickAndHold(element1).moveToElement(element2).release(element2).build();
		   //dragaction.perform();
	}
	
	//去掉右下角的消息弹窗
	public static void  removeFlag(WebDriver driver) throws Exception   
	{
		  try {
		    	driver.findElement(By.id("msg_close")).click();

			} catch (Exception e) {
				System.out.println("没有弹出框");
				// TODO: handle exception
		  }
	}
	
	public static List<String> getTime() throws Exception {
	// 获取直播的开始小时和分钟
	  String time = Uti.get_currenttime2();
	  String str=time.substring(time.length()-2);//截取最后两位
	  String str2=str.substring(0,1);//获取分钟数的前一位
	  String hour = null;
	  String fenzhongshu=null;

	  try {
		  
	      int b = Integer.valueOf(str2).intValue();
	      int a = b*10+10; //获取到的分钟数去掉末尾一位，然后增加10分钟
	         
	      String str6=time.substring(time.length()-5);
	      String str3=str6.substring(0,2);//获取当前小时数
	      if(a==60){
	    	  //假如计算出的分钟数a为60分钟，那么累计小时数增加一，分钟数清零
	          int time1= Integer.valueOf(str3).intValue()+1;//小时数
	          hour = String.valueOf(time1);
	          fenzhongshu= "00";

	      
	      }else{
	    	  //假如计算出的分钟数a不为60分钟，那么累计小时数不变，分钟数不变
	    	  fenzhongshu=String.valueOf(a); 
	    	  hour=str3;
	      }
	  } catch (NumberFormatException e) {
	      e.printStackTrace();
	  }
	  List<String> list = new ArrayList<String>();
	  list.add(hour);
	  list.add(fenzhongshu);
	  return list;		
	}

	public static List<String> getENdTime() throws Exception {
	// 获取直播结束的小时和分钟
    String time = Uti.get_currenttime2();
	String str=time.substring(time.length()-2);//截取最后两位
	String str2=str.substring(0,1);//获取分钟数的前一位
	String hour = null;
	String fenzhongshu=null;

	try {
		  
	    int b = Integer.valueOf(str2).intValue();
	    int a = b*10+30; //获取到的分钟数去掉末尾一位，然后增加10分钟
	       
	      String str6=time.substring(time.length()-5);
	      String str3=str6.substring(0,2);//获取当前小时数
	    if(a==60 | a==70 | a==80){
	  	  if(a==60){
	  		  
		    	  //假如计算出的分钟数a为60分钟，那么累计小时数增加一，分钟数清零
		          int time1= Integer.valueOf(str3).intValue()+1;//小时数
		          hour = String.valueOf(time1);
		          fenzhongshu= "00";
	  	  }else{
		          int time1= Integer.valueOf(str3).intValue()+1;//小时数
		          hour = String.valueOf(time1);
		          fenzhongshu= "20";	  
	  	  }
	    
	    }else{
	  	  //假如计算出的分钟数a不为60分钟，那么累计小时数不变，分钟数不变
	  	  fenzhongshu=String.valueOf(a); 
	  	  hour=str3;
	    }
	} catch (NumberFormatException e) {
	    e.printStackTrace();
	}
	List<String> list1 = new ArrayList<String>();
	list1.add(hour);
	list1.add(fenzhongshu);
	return list1;		
	}

	
	//获取当前系统时间,时间戳
	public static String  get_currenttime2() throws Exception{
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		String Currentday =sdf.format(date);				
		return Currentday;//不带双引号的时间字符串		
	}
	//alert 处理方法，
	//二十秒内强制等待alert框出现，每秒检查一次，第几秒检查不到，就抛出异常
	public static void  waitForAlertAndCloseAlert(WebDriver driver) throws Exception   
	{  
	   int i=0;  
	   while(i++<30)  
	   {  
	        try  
	        {  
	            Alert alert = driver.switchTo().alert();  
	            alert.accept();  
	            break;  
	        }  
	        catch(NoAlertPresentException e)  
	        { 
	          Thread.sleep(1000);  
	          continue;  
	        }  
	   }  
	   if(i==29){  
	       throw new NoAlertPresentException();  
	   }  
	}
	//举报
	public static void  report(WebDriver driver) throws Exception   {
		String xpath_report = "//span[@id='btn'][@onclick='report()']";
		driver.findElement(By.xpath(xpath_report)).click();
		Thread.sleep(500);
		
		String xpath_selector = "//input[@type='radio'][@value='5']";
		driver.findElement(By.xpath(xpath_selector)).click();
		
		driver.switchTo().frame(0);
		driver.findElement(By.className("ke-content")).sendKeys("举报内容"+Uti.get_random());
		driver.switchTo().defaultContent();		
		driver.findElement(By.linkText("提交")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
	}
	//资源分类体系
	public static void  resource(WebDriver driver) throws Exception   
	{
		//学段、学科
		try{
			new Select(driver.findElement(By.id("sel_sysDictId1"))).selectByValue("8875");  //高中
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId2"))).selectByValue("8975");  //语文
			Thread.sleep(500);
	
		
		//教材版本
	
			
			new Select(driver.findElement(By.id("sel_sysDictId3"))).selectByValue("102469"); //人教版
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId4"))).selectByValue("102471");  //必修1
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId5"))).selectByValue("102473");  //第一单元
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId6"))).selectByValue("102477");  //诗两首
			Thread.sleep(500);
	
		
		//知识点
		
			new Select(driver.findElement(By.id("sel_sysDictId8"))).selectByValue("125657");  //六、作文
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId9"))).selectByValue("125659");  //1、命题作文
			Thread.sleep(500);
	
		
		//资源
	
			new Select(driver.findElement(By.id("sel_sysDictId11"))).selectByValue("129099");  //学科教学资源
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId7"))).selectByValue("124059");   //导学案
			Thread.sleep(500);
		}catch(Exception e){
			System.out.println("无需维护资源");
		}
	}
	
	//生成一个随机数
	public static int get_randomContainsThreeMath() throws Exception{
		int random=0;
        //产生0-1000的双精度随机数  
        //System.out.println(random);
        while(random<100){
    		 random=(int) (Math.random()*1000);
        	}
		return random;
	}
	
	public static int get_random() throws Exception{
		int random=(int) (Math.random()*1000);
        //产生0-1000的双精度随机数  
        //System.out.println(random);
		return random;
	}
	
	//查看想要的本文标题，并返回布尔值
	public static  boolean isTextPresent(WebDriver driver,String what) {
		  try{
		  return driver.findElement(By.tagName("body")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含文本 what,返回的是ture或者false
		  }
		  catch (Exception e){
		  return false;// 没有该文本 则 返回 false
		  }
		 
	  }	  
	  public static  boolean isTagPresent(WebDriver driver,String value) {
		  try{
		  return   driver.findElement(By.name(value)).isEnabled();// 遍历查找到的标签下的所有属性值 并判断是否包含文本 what
		  }
		  catch (Exception e){
		  return false;// 没有该文本 则 返回 false
		  }
	  }
	
	  public static boolean isTitlePresent(WebDriver driver,String what){
		  try {
			  driver.findElement(By.linkText(what));
			  return true;
		} catch (Exception e) {		
			return false;
			// TODO: handle exception
		}  
	  }
	  
	  public static  boolean stringCompare(WebDriver driver,String big,String small) {
	
			  String big1=big.replaceAll(" ", "");
			  String small1 = small.replaceAll(" ", "");
			  boolean result = big1.contains(small1);
		      return result;
	  }	  
	  
	//获取同伴协作标题
	public static String  get_cooperationName() throws Exception{
		String cooperationName = "同伴协作"+Uti.get_random();			
		return cooperationName;
	}
	//获取活动名字
	public static String  get_activityName() throws Exception{
		String activityName = "活动"+Uti.get_random();					
		return activityName;
	}
	//获取磨课名字
	public static String  get_mokeName() throws Exception{
		String mokeName = "磨课"+Uti.get_random();
		return mokeName;
	}
	//获取备课名称
	public static String  get_beikeName() throws Exception{
		String beikeName = "备课"+Uti.get_random();
		return beikeName;
	}
	//获取作业名字
	public static String  get_zuoyeName() throws Exception{
		String zuoyeName = "作业"+Uti.get_random();
		return zuoyeName;
	}
	//获取文章名称
		public static String  get_docName() throws Exception{
			String docName = "文章"+Uti.get_random();
			return docName;
		}
	//获取交流名称
	public static String  get_exchangeName() throws Exception{
			String exchangeName ="交流"+Uti.get_random();
			return exchangeName;
		}
}