package io;
/*小插曲：改变输入输出流的控制方式*/
//System.setIn(new 输入流对象)，不再从键盘录入，而是从指定的文件录入。
//System.setOut(new 输出流对象(PritStream(文件))，不再打印到控制台中去，而是到文件中。
import java.io.*;
import java.util.*;
import java.text.*;
/*需求：把异常信息打印到文件，加上日期，方便以后查阅异常日记*/
public class Day26_systemSetin_Setout {
 public static void main(String[] args)  throws Exception{
	try
	{
		int[] arr=new int[2];
		System.out.println(arr[3]);
	}
	catch(Exception e)
	{
		try
		{
			Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String s=sdf.format(d);
		
		PrintStream ps=new PrintStream("F:\\Exception.log");
		ps.println(s);
		System.setOut(ps);
			
		}
		catch(IOException ex)
		{
			throw new RuntimeException("动态创建失败");
			
		}
		e.printStackTrace(System.out);
		
	}
}
}
