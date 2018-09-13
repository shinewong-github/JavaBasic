package io;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream; 

/**
 * 测试System.in 和System.out
 *System.in和System.out 前者是获取键盘输入流对象并阻塞，创建一个输入流对象与键盘相关联起来，此时键盘被看成是一个相关的文件
 *System.out 则是像屏幕打印出，也就是说创建一个输出流对象与控制台相关联起来，此时的控制被看成是一个目标文件
 * @author ShineWong
 *
 */
public class Day07_1system_In_Out {
	 
	 
	    public static void main(String[] args) {  
	  
	        InputStream is = System.in;// 标准的输入流对象 --读取操作  
	        OutputStream os = System.out;// 标准的输出流对象---写的操作  
	        try {  
	            byte[] buffer = new byte[10]; // 建立一个数组缓冲区，用来缓冲字节，长度为10 // 0 1 2 3 4 5 6 7 8 9  
	            int len = 0;// 读取之后的实际长度 //在UTF8编码下，回车\r 换行\n 也各占1个字节  
	            /* 
	             * read方法参数： b - 读入数据的缓冲区。 off - 数组 b 中将写入数据的初始偏移量。 len - 要读取的最大字节数。 
	             */  
	            while ((len = is.read(buffer, 0, 4)) != -1) { //读取操作                                                  
	                System.out.println("读取的实际长度--------" + len);  
	                os.write(buffer, 0, 4); //写出的操作  
	                System.out.println("----------");  
	            }  
	        } catch (IOException e) {  
	             
	            e.printStackTrace();  
	        }  
	    }  
	  
	
}
