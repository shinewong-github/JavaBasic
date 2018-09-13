package net;

import java.io.*;

public class test 
{
 static void main(String[] args) throws Exception
 {
	BufferedReader bufr=new BufferedReader(new FileReader("00.txt"));
	 PrintStream out=new PrintStream(new FileOutputStream("11.txt"),true);
	 
	 String line=null;
	 while((line=bufr.readLine())!=null)
	 {
		 if("over".equals(line))
		    break;
		 out.println(line);
		
	 }
}
}
