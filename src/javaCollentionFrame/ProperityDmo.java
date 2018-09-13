package javaCollentionFrame;

import java.io.*;
import java.util.Properties;

/**
 * Properity
 */
public class ProperityDmo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Properties pro=new Properties();
       File file=new File("config.ini");
       if(!file.exists())
       {
    	   file.createNewFile();
       }
       FileInputStream fis=new FileInputStream(file);
      
       pro.load(fis);//已加载到了集合中了
       int count=0;
       String value=pro.getProperty("time");
       if(value!=null)
       {
    	  count=Integer.parseInt(value);
    	  if(count>=5)
    	  { 
    		  System.out.println("试用次数已到，请注册@");
    	       return;
    	  }
       }  
       count++;
       pro.setProperty("time",count+"");
       System.out.println("已试用"+count+"次");
       FileOutputStream fos=new FileOutputStream(file);
          pro.store(fos, "the count by user");
          fos.close();
          fis.close();
       
       
		//
	}

}
