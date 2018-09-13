
package io;

import java.io.FileReader;
import java.io.IOException;

/**
 * 明白了ReadLine()方法的原理后，自己定义一个类,其中包含一个功能和readLine
 * 一致的方法来模拟一下BufferedReader
 */
class MyBufferedRead//定义一个读缓冲区,里面定义一个读一行的方法和关闭缓冲区的资源方法
{
	private FileReader r;
	MyBufferedRead(FileReader r)//里面的构造函数参数是一个被私有化的关联输入流对象
	{
		this.r=r;
		
	}
public String myReadLine() throws IOException //这个自己定义的MyBufferedRead缓冲区的读一行方法
  {
	StringBuilder sb=new StringBuilder();//定义一个字符缓冲区，将从输入流读出来的字符放进去
	 
	int ch=0;
	while((ch=r.read())!=-1) 
	{
		if(ch=='\r')
			continue;
		if(ch=='\n')
			return sb.toString();
		else
		sb.append((char)ch);
	}
	if(sb.length()!=0)//当文件末尾没有回车键时，最后一行将没被返回。这两句是决解这个问题的方法
		return sb.toString();
  return null;//当一行一行地读，读到文件末尾的时候，就返回空
  
  }

public void myclose()throws IOException 
{
r.close();	
}
}

public class Day0_6myBufferedRead_MyreadLine 
{
public static void main(String[] args) throws IOException {
	FileReader fr =new FileReader("f:\\00.txt");
	MyBufferedRead myBuf=new MyBufferedRead(fr);
	String line=null;
	while((line=myBuf.myReadLine())!=null)
	{
		System.out.println(line);
	}
	myBuf.myclose();
	
}
	
	
}
