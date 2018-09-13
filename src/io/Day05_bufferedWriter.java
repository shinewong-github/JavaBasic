package io;

import java.io.*;

/**
 * 用户缓冲区复制一个文件，并用异常处理
 */
public class Day05_bufferedWriter
{
public static void main(String[] args) {
	
	String read_filePath="C:\\Users\\ShineWong\\workspace\\javaBasic\\src\\io\\1.txt";
	String out_filePath="C:\\Users\\ShineWong\\workspace\\javaBasic\\src\\io\\out.txt";
	BufferedWriter bufw=null;
	 BufferedReader bufr=null;
	 try
	 {
	 bufw=new BufferedWriter(new FileWriter(out_filePath));
	 bufr=new BufferedReader(new FileReader(read_filePath));
		 String line=null;
		 while((line=bufr.readLine())!=null)
		 {
			 bufw.write(line);//读一行
			 bufw.newLine();//写一行
			 bufw.flush();//关闭流前刷新
			 
		 }
	 }
	 catch  (IOException e)
	 {
		 System.out.println(e.toString());
		 //throw new RuntimeException("读写失败");
	 }
	 //下面的代码只是进行正常地关闭缓冲区而已。
	 finally
	 {
		 try
		 {
		 if(bufr!=null)
		 bufr.close();
		 }
		 catch (IOException e)
		 {
			 throw new RuntimeException("读失败");
			 
		 }

		 try
		 {
		 if(bufw!=null)
		 bufw.close();
		 }
		 catch (IOException e)
		 {
			 throw new RuntimeException("写失败");
			 
		 }
		 System.out.println("程序运行成功");
	 }

}
}
	
	
	
