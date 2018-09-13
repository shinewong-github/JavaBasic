package io;

import java.io.*;

/**
 * 验证和测试BufferReader:字符流，用来处理文本文件的，而非字节流
 * readLine()
 * 业务逻辑：
 *  BufferReader缓冲的是输入流对象的关联文件
 *  这个缓冲区有一个很重要的方法是读一行的方法，readLine(),返回的是String类型的,且返回的时候不带回车符(win下是\r\n,共两字节)
 *  只返回回车符之前的东西，所以要使用newLine进行换行。
 *  这个方法当读到没有字符了，则返回NULL,这时候可以定义一个循环。
 */
public  class Day05_bufferReader{
 public static void main(String[] args) throws IOException{
	 String filePath="C:\\Users\\ShineWong\\workspace\\javaBasic\\src\\io\\1.txt";
	 FileReader fr=new FileReader(filePath);//关联文件
	
	 BufferedReader buf=new BufferedReader(fr);//建立字符输入流缓冲区对象
	/*基本使用
	int a=buf.read(); //读一个字符,返回字符的十进制表示形式。
	System.out.println(a);
	String b=buf.readLine();//读字符串
	System.out.println(b);
    buf.close();记得要关闭资源，实际关的是输入流的资源。
	*/
	String line=null;
	while((line=buf.readLine())!=null)//定义一个循环，通过读一行的方法将文件读完，提高了读取的效率。
		System.out.println(line);
	buf.close();
}
 
}
