package ActivityAddedVoteAndEvaluate;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DateProvider.DateProvider;
import uti.Uti;

public class VoteAndEvaluate {
	
	ChromeDriver driver = new ChromeDriver();
	
	//教师发布活动
	@Test(dataProvider = "teacher", dataProviderClass = DateProvider.class)
	public void publishActivity(String username,String password) throws Exception{
		
		Uti.ChromeBrowser_setup(driver, username, password);
		driver.findElementByPartialLinkText("活动").click();
		Thread.sleep(500);
		
		driver.findElementByLinkText("发布").click();
		Thread.sleep(1000);
		driver.findElementByClassName("zdy").click();
		Thread.sleep(1000);
		
		//名称
		driver.findElementById("activityName").sendKeys("自定义活动"+Uti.get_random());
		
		Uti.resource(driver);
		
		//开始时间、结束时间
		driver.findElementById("startTime").sendKeys("2018-01-10");
		driver.findElementById("endtime").sendKeys("2019-12-31");
		
		//输入活动简介，保存到下一步
        Uti.richText(driver, 0, "这是活动的简介。。");
//		driver.switchTo().frame(0);
//		driver.findElementByClassName("ke-content").sendKeys("这是活动的简介。。"+Uti.get_random());
//		driver.switchTo().defaultContent();
        
		driver.findElementByLinkText("保存到下一步").click();
		Thread.sleep(1000);
		
		//新增单选投票步骤
		driver.findElementByLinkText("新增环节").click();
		Thread.sleep(1000);
		driver.findElementById("name").sendKeys("步骤1投票");
		
		Uti.richText(driver, 0, "这是步骤描述");
//		driver.switchTo().frame(0);
//		driver.findElementByClassName("ke-content").sendKeys("这是步骤的描述。。"+Uti.get_random());
//		driver.switchTo().defaultContent();
		
		driver.findElementByLinkText("选择工具").click();
		driver.findElementById("a10").click();
		
		driver.findElementById("voteTitle").sendKeys("这是投票的标题。。。"+Uti.get_random());
		driver.findElementById("voteOption0").sendKeys("这是选项1");
		driver.findElementById("voteOption1").sendKeys("这是选项2");
		
		driver.findElementByClassName("add_theme").click();
		driver.findElementByClassName("add_theme").click();
		
		driver.findElementById("voteOption2").sendKeys("这是选项3");
		driver.findElementById("voteOption3").sendKeys("这是选项4");
		driver.findElementByLinkText("保存").click();
		
		//新增多选投票步骤
		driver.findElementByLinkText("新增环节").click();
		Thread.sleep(1000);
		driver.findElementById("name").sendKeys("步骤2多选投票");
		
		Uti.richText(driver, 0, "这里是步骤描述");
//		driver.switchTo().frame(0);
//		driver.findElementByClassName("ke-content").sendKeys("这是步骤的描述。。"+Uti.get_random());
//		driver.switchTo().defaultContent();
		
		driver.findElementByLinkText("选择工具").click();
		driver.findElementById("a10").click();
				
		driver.findElementById("voteTitle").sendKeys("这是投票的标题。。。"+Uti.get_random());
		Thread.sleep(1000);
		String vote_type = "//input[@class='vote_choose'][@value='1']";
		driver.findElementByXPath(vote_type).click();
		Thread.sleep(1000);
		driver.findElementById("voteOptionNum").sendKeys("3");
		driver.findElementById("voteOption0").sendKeys("这是选项1");
		driver.findElementById("voteOption1").sendKeys("这是选项2");
		
		driver.findElementByClassName("add_theme").click();
		driver.findElementByClassName("add_theme").click();
		
		driver.findElementById("voteOption2").sendKeys("这是选项3");
		driver.findElementById("voteOption3").sendKeys("这是选项4");
		driver.findElementByLinkText("保存").click();
		
		//新增活动评论步骤
		driver.findElementByLinkText("新增环节").click();
		Thread.sleep(1000);
		driver.findElementById("name").sendKeys("步骤3活动评价");
		Uti.richText(driver, 0, "这里是步骤描述"+Uti.get_random());
//		
//		driver.switchTo().frame(0);
//		driver.findElementByClassName("ke-content").sendKeys("这是步骤的描述。。"+Uti.get_random());
//		driver.switchTo().defaultContent();
		
		driver.findElementByLinkText("选择工具").click();
		driver.findElementById("a11").click();
		Thread.sleep(500);
		
		driver.findElementByLinkText("保存").click();
		Thread.sleep(1000);
		
		driver.findElementByLinkText("发布").click();
		driver.findElementByLinkText("退出").click();

		joinActivity(driver,"devstudent3","123123");
		scoreActivity(driver,"devteacher","123123");

		driver.quit();
		
		
	}
	
	//学员参与活动的方法
	public static void joinActivity(ChromeDriver driver,String username,String password) throws Exception{
		
		driver.findElementByLinkText("登录").click();
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
	    driver.findElement(By.cssSelector("h3.login_kxdl")).click();
		Thread.sleep(1000);
		driver.findElementByPartialLinkText("活动").click();
		Thread.sleep(1000);
		
		//关闭信息通知
		try{
			driver.findElementById("msg_close").click();
		}catch(Exception e){
			System.out.println("无信息通知");
		}
		Thread.sleep(1000);
		driver.findElementByLinkText("参与活动").click();
				
		Uti.ChangeWindows(driver,2);
		
		//步骤1
		String vote_1 = "(//input[@type='radio'][contains(@name,'options')])[1]";
		driver.findElementByXPath(vote_1).click();
		driver.findElementByLinkText("投票").click();
		Thread.sleep(1000);
		
		//步骤2
		driver.findElementById("jiadd2").click();
		String vote_2 = "(//input[@type='checkbox'][contains(@name,'options')])[2]";
		String vote_3 = "(//input[@type='checkbox'][contains(@name,'options')])[3]";
		driver.findElementByXPath(vote_2).click();
		driver.findElementByXPath(vote_3).click();
		driver.findElementByLinkText("投票").click();
		Thread.sleep(1000);
		
		//步骤3
		driver.findElementById("jiadd3").click();
		String evaluation = "//input[@type='radio'][@value='2']";
		driver.findElementByXPath(evaluation).click();
		String harvest = "(//textarea[@class='fl'][contains(@id,'harvest')])[1]";
		driver.findElementByXPath(harvest).sendKeys("这是收获。。。。。");
		String advice = "(//textarea[@class='fl'][contains(@id,'advice')])[1]";
		driver.findElementByXPath(advice).sendKeys("这是建议。。。。。");
		driver.findElementByLinkText("提交评价").click();
		Thread.sleep(1000);
		
		driver.findElementByLinkText("退出").click();
		
	}
	
	//活动发布者批阅活动的方法
	public static void scoreActivity(ChromeDriver driver,String username,String password) throws Exception{
		
		driver.findElementByLinkText("登录").click();
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
	    driver.findElement(By.cssSelector("h3.login_kxdl")).click();
		Thread.sleep(1000);
		driver.findElementByPartialLinkText("活动").click();
		Thread.sleep(1000);
		
		//关闭信息通知
		try{
			driver.findElementById("msg_close").click();
		}catch(Exception e){
			System.out.println("无信息通知");
		}
		Thread.sleep(1000);
		
		driver.findElementByPartialLinkText("提交详情").click();
		Thread.sleep(1000);
		Uti.ChangeWindows(driver,2);
		driver.findElementByPartialLinkText("查看并批阅").click();
		Thread.sleep(1000);
		
		Uti.ChangeWindows(driver,3);
		driver.findElementById("RadioGroup1_1").click();
		driver.findElementById("TextArea2").sendKeys("这是活动的评价。。。");
		String recommend = "//input[@type='checkbox'][@value='1']";
		driver.findElementByXPath(recommend).click();
		
		String up = "//input[@type='button'][@value='提交']";
		driver.findElementByXPath(up).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		
		driver.findElementByLinkText("退出").click();
	
	}

}
