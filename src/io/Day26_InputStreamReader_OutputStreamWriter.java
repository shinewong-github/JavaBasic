package io;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//将字节输入流对象转换成字符输入流对象，将字节输出流对象转换成字符输出流对象
//InputStreamReader OutputStreamWriter
/*先创建字节输入输出流对象，再通过InputStreamReader,OutputWriter关联起来，如果要用到缓冲区，
 *      则前面的又进一步可以缓冲区关联起来
   --使用方法：
     1：
     FileInputStream in=new FileInputStream("F:\\要读取的文件.txt") 或者直接与键盘输入关联起来
      InputStream in=System.in;
     然后通过InputStreamReader isr=new InputStreamReader(in); 此时，FileInputStream已经变成了
              FileReader了，对象名是，isr,如果要提高传输的效率，可以 通过，BufferedReader来运作 
           	则可以这样子做：BufferedReader buf=new BufferedReader(isr);
           	--此后的操作就是直接以缓冲区的思想来对字符输入流进行操作了。可以用到readLine的方法
     2：
             与此同理，把字符输出流对象转换成自己输出流对象，输出到文件中去。
        
     FileOutputStream out=new FileOutputStream("F:\\目的文件.txt") 或者直接与控制台输出关联起来
      OutputStream out=System.out;
     然后通过OutputStreamWriter isw=new OutputStreamWriter(out); 此时，FileOutputStream已经变成了
              FileWriter了，对象名是，isw,如果要提高传输的效率，可以 通过，BufferedWriter来运作 
           	则可以这样子做：BufferedWriter buf=new BufferedWriter(isw);
    
    -------将上面的 语句结合成一句话是：
              BufferedReader bufr=new BufferedReader(new InputStreamReader(new FileInputStream("要读取的文件.txt")))
              BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("目的文件.txt")))


 */

import java.io.*;

public class Day26_InputStreamReader_OutputStreamWriter {
public static void main(String[] args)  throws Exception{
	//FileReader r=(FileReader) new InputStreamReader(new FileInputStream("F:\\002.txt"));
	
	  //BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
              BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(System.out));
               BufferedReader bufr=new BufferedReader(new InputStreamReader(new FileInputStream("F:\\要读取的文件.txt")));
                      //BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F:\\目的文件.txt")));
              String line=null;
              while((line=bufr.readLine())!=null)
              { 
                     if("over".equals(line))
            	     break;
                     else
                     {
            		  bufw.write(line.toUpperCase());
            		  bufw.newLine();  
            		  bufw.close();
                     }
              }
             
              
	
}
}
