package DateProvider;

import org.testng.annotations.DataProvider;

import uti.Uti;

/**
 * @author Anthony
 *
 */
public class DateProvider {
	public static String guanliyuanUsername="devguanliyuan";
	public static String guanliyuanPassword="3edc$RFV";
	public static String zhuanjiaUsername="devzhuanjia";
	public static String zhuanjiaPassword="3edc$RFV";
	public static String teacherUsername="devteacher";
	public static String teacherPassword="3edc$RFV";
	public static String student1Username="devstudent1";
	public static String student1Password="123123790a";
	public static String student2Username="devstudent2";
	public static String student2Password="123123790a";
	public static String filePath="E:/Downloads/uploadFile.exe";
	public static String vedioPath="E:/Downloads/uploadvideo.exe";
	public static String coursePlan="高中语文教学计划2";
	public static String couresName="T2教学与信息化技术手段";

@DataProvider(name = "publishAccount_account")

public static Object[][] accountInfo() {
return new Object[][] { 
		
new Object[] { "xmgly", "123123" },
new Object[] { "wowo", "w123123"}

};
}

@DataProvider(name = "guanliyuan")

public static Object[][] filepath22() {
	
return new Object[][] { 
new Object[]{guanliyuanUsername,guanliyuanPassword}		
};
}

@DataProvider(name = "zhuanjia")

public static Object[][] filepath23() {
	
return new Object[][] { 
new Object[]{zhuanjiaUsername,zhuanjiaPassword}		
};
}

@DataProvider(name = "teacher")

public static Object[][] filepath24() {
	
return new Object[][] { 
new Object[]{teacherUsername,teacherPassword}		
};
}
@DataProvider(name = "xueyuan")

public static Object[][] filepath144() {
	
return new Object[][] { 
new Object[]{student1Username,student1Password}		
};
}
@DataProvider(name = "xueyuan2")

public static Object[][] filepath144e() {
	
return new Object[][] { 
new Object[]{student2Username,student2Password}		
};
}

@DataProvider(name = "guanliyuanFilePath")

public static Object[][] filepath() {
	
return new Object[][] { 
new Object[]{guanliyuanUsername,guanliyuanPassword,filePath,vedioPath}		
};
}

@DataProvider(name = "guanliyuanCotainPlist")

public static Object[][] filepath332() {
	
return new Object[][] { 
new Object[]{guanliyuanUsername,guanliyuanPassword,filePath,vedioPath,coursePlan}		
};
}

@DataProvider(name = "guanliyuanKill")
//包含plist和clist教学计划参数
public static Object[][] filepath33() {
	
return new Object[][] { 
new Object[]{guanliyuanUsername,guanliyuanPassword,filePath,vedioPath,coursePlan,couresName}		
};
}
@DataProvider(name = "zhuanjiaKill")
//包含plist和clist教学计划参数
public static Object[][] filepath353() {
	
return new Object[][] { 
new Object[]{zhuanjiaUsername,zhuanjiaPassword,filePath,vedioPath,coursePlan,couresName}		
};
}
@DataProvider(name = "teacherKill")
//包含plist和clist教学计划参数
public static Object[][] filepath656() {
	
return new Object[][] { 
new Object[]{teacherUsername,teacherPassword,filePath,vedioPath,coursePlan,couresName}		
};
}


@DataProvider(name = "xueyuanFilePath")

public static Object[][] filepath1() {
	
return new Object[][] { 
new Object[]{student2Username,student2Password,filePath,vedioPath}		
};
}
@DataProvider(name = "xueyuanContainsClist")

public static Object[][] filepath55() {
	
return new Object[][] { 
new Object[]{student2Username,student2Password,filePath,vedioPath,couresName}		
};
}
@DataProvider(name = "zhuanjiaFilePath")

public static Object[][] filepath2() {
	
return new Object[][] { 
new Object[]{zhuanjiaUsername,zhuanjiaPassword,filePath,vedioPath}		
};
}
@DataProvider(name = "teacherFilePath")

public static Object[][] filepath56() {
	
return new Object[][] { 
new Object[]{teacherUsername,teacherPassword,filePath,vedioPath}		
};
}

@DataProvider(name = "zhuanjiaCotainsPlist")

public static Object[][] filepath66() {
	
return new Object[][] { 
new Object[]{zhuanjiaUsername,zhuanjiaPassword,filePath,vedioPath,coursePlan}		
};
}


@DataProvider(name = "teacherCotainsPlist")

public static Object[][] filepath77() {
	
return new Object[][] { 
new Object[]{teacherUsername,teacherPassword,filePath,vedioPath,coursePlan}		
};
}


@DataProvider(name = "cooperation_name")

		public static Object[][] put_cooperation_name() throws Exception {	
		
	    String NameOfcooperation ="同伴协作标题"+Uti.get_currenttime1();
		System.out.println(NameOfcooperation);
		return new Object[][] { 
				new Object[]{NameOfcooperation}		
				};
}
}
