package io;

import java.io.*;

/**
 *需求；当录入一数据后，就将该数据进行打印，如果遇到录入的数据是over,则停止。
 * @author ShineWong
 *
 */
public class Day07_system_In_Out {
	
	public static void main(String[] args) throws Exception {
			InputStream in=System.in;
			StringBuilder sb= new StringBuilder();
			System.out.println("over chat with 'over'");
			while(true)//可以用readLine方法来代替，使功能更简单
			{
				int ch=in.read();//返回的是一个字节的十进制表达形式
				if(ch=='\r')
					continue;
				if(ch=='\n')
				{
					String s=sb.toString();
					if("over".equals(s))
					break;//遇到over跳出循环，结束程序
					
					System.out.println(s.toUpperCase());
					sb.delete(0,sb.length());//清空StringBuilder的内容
				}	
				else
						 sb.append((char)ch);
			}
			System.out.println("结束聊天");
	}

}
