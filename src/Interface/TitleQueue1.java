package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class TitleQueue1 {
	private TitleQueue1(){};
    private static Map<String,String> map=new HashMap<String,String>();
    private static Map<String,Vector<String>> queue=new HashMap<String,Vector<String>>();

    public static String pop(String className){
          String key =map.get(className);
          //System.out.println("key is"+key);
          
          if(null==key || "".equals(key))
        	  return null;
          Vector<String> aloneQueue =queue.get(key);
          //System.out.println("aloneQueualoneQueuee is"+aloneQueue);
          if(aloneQueue.isEmpty())
        	  return null;
          return aloneQueue.remove(0);
    }
    
    public static void push(String title,String className,String executeClassNames){
        //把想要拿title的c类注册进入map中
    	    //System.out.println(executeClassNames);
        	String oleExec= map.get(executeClassNames);
        	if(null==oleExec){
        		map.put(executeClassNames, className);
        		String oleExec1= map.get(executeClassNames);
        		//System.out.println(oleExec1);
        	}
        
    	//入队列
    	Vector<String> aloneQueue =queue.get(className);
    	if(null== aloneQueue){
    		aloneQueue =new Vector<String>();
    	}
    	//System.out.println("titleQueue；is"+title);
    	aloneQueue.add(title);
    	queue.put(className, aloneQueue);
    }
}