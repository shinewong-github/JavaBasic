package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CommanService {
	
	 
	static  ServerSocket ss=null;//new ServerSocket(10005);
	static Socket s=null;//ss.accept()
	static BufferedReader bufr=null;
	static String line=null;
		
/**
 * Client as a Service socket open the port accpet Service Socket connect
 * @param writeStram
 * @param readSteam
 * @throws IOException
 */
   public  static void clientServergetSteam()
		             throws IOException{
	  
	   ss=new ServerSocket(10005);
	   s=ss.accept();
	   //接收
	   bufr=new BufferedReader (new InputStreamReader(s.getInputStream()));
	
	   while((line=bufr.readLine())!=null)
		{
		 System.out.print(line);//读一行，打一行到屏幕中。		
		}
	   closeBufR(bufr);
   }
   /**
    * 从键盘读取 发到socket流中给客户端。
    * @param writeStram
    * @param readSteam
 * @throws IOException 
    */
 public  static void servicetSocketgetSteam() 
		 throws IOException{
	 
	  s=new Socket();
	 
	 bufr=
		new BufferedReader(new InputStreamReader(System.in));
	 
	 PrintWriter out=new PrintWriter
			 (new OutputStreamWriter(s.getOutputStream()),true);
	 
	 String line=null;
	 while((line=bufr.readLine())!=null)
	 {
	 out.println(line);//读一行，打一行		
	 }
	 closeBufW(out);
	
//打到socket输出中，并且自动刷新。
//System.out.println("黑客聊天室，链接地址： "+url+"端口号： "+port);
//开始读取键盘字符流

//读取socket流
   }
 
 public static void closeBufW(PrintWriter printWriter) throws IOException{
	 printWriter.close();
 }
 public static void closeBufR(BufferedReader bufferedReader) throws IOException{
	 bufferedReader.close();
 }
}
