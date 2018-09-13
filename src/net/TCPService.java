package net;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

 
public class TCPService {
	
	static CommanService commanService=null;
	 public static void main(String[] args)throws Exception
	 {
	 		ServerSocket ss=new ServerSocket(10005);
	 		Socket s=ss.accept();//接受一个客户端连接
	 		//读取socket输入流
	 		BufferedReader bufr=
	 		new BufferedReader (new InputStreamReader(s.getInputStream()));
	 		
	 		PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out),true);
	 		String line=null;
	 		
	 		while((line=bufr.readLine())!=null)
	 		{
//	 			if("over".equals(null))
//	 			break;
	 			out.println(line);
	 			
	 		}
	 		//写一个反馈信息给客户端说上传成功了，步骤 是要将该提示字符通过socket对象输出流给客户端的输入流对象接收
	 		
	 		//发消息给客户端
//	 		BufferedReader bufr1=
//	 				new BufferedReader(new InputStreamReader(System.in));
//	 		PrintWriter out2=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
//	 		String line1=null;
//	 		while((line1=bufr1.readLine())!=null)
//	 		{
//	 		out2.println(line);//读一行，打一行		
//	 		}
	 		//打到socket输出中，并且自动刷新。
	 		commanService.servicetSocketgetSteam();
	 	
	 		out.close();
//	 		out2.close();
	 		s.close();
	 		ss.close();
	 		
	 		
	 }
	 }