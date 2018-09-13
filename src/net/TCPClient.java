package net;

import java.io.*;
import java.net.*;

 class TCPClient 
{
	 
	 static  CommanService commanService=null;
 public static void main(String[] args) throws Exception
 {
	 String url="192.168.0.111";
	 int port=10005;
	 String who="陈先生";
    	Socket s=new Socket(url,port);
	//读取键盘字符流
	BufferedReader bufr=
			new BufferedReader(new InputStreamReader(System.in));
	//打到socket输出中，并且自动刷新。
	PrintWriter out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);//输出流到socket去，自动刷新
	System.out.println("黑客聊天室，链接地址： "+url+"端口号： "+port);
	//开始读取键盘字符流
	String line=null;
	while((line=bufr.readLine())!=null)
	{
	out.println(who+line);//读一行，打一行		
	}
	
	commanService.clientServergetSteam();
	
	//读取socket流
//     InputStream  ins=s.getInputStream();
//	BufferedReader b=
//			new BufferedReader(new InputStreamReader(s.getInputStream()));
//	  StringBuilder sb= new StringBuilder();
//		while(true)//可以用readLine方法来代替，使功能更简单
//		{
//			int ch=ins.read();//返回的是一个字节的十进制表达形式
//			if(ch=='\r')
//				continue;
//			if(ch=='\n')
//			{
//				String string=sb.toString();
//				if("over".equals(s))
//				break;//遇到over跳出循环，结束程序
//				{
//					System.out.println("对方终止聊天");
				 bufr.close();
//				 ins.close();
				 s.close();
//				}
//				System.out.println(string);
//				sb.delete(0,sb.length());//清空StringBuilder的内容
//			}	
//			else
//					 sb.append((char)ch);
//		}
	}	

}

