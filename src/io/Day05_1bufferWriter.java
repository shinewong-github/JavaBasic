package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 验证和测试BufferWriter类
 *  业务逻辑和思想： 缓冲区Writer的出现，提高了输入流和输出流的效率，不再是一个字符或者一个数组的读取
 *  定义一个缓冲区，要有关联的对象，对象要有关联的文件 其实关闭缓冲区就是关闭流对象，所以关闭资源用到buf.close() 主要用到缓冲区
 *  就要进行flush,然后再关闭资源 
 * newLine()方法是一个垮平台的方法,换行。
 *  写缓冲区，要刷新。
 * new FileWriter(filename)
 * 使用main方法测试
 */
public class Day05_1bufferWriter {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter buf = null;
		try {
			fw = new FileWriter("d:\\0001.txt");
			buf = new BufferedWriter(fw);
			buf.write("Buffered有一个方法是换行的");
			buf.newLine();
			buf.write("该方法是newLine(),无参数，直接换行");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				if (fw != null)
				    buf.flush();
				buf.close();//关流前刷新。
				System.out.println("运行成功");
			} catch (IOException e) {
				System.out.println("对象创建不成功，对象为空/");

			}
		}
	}

}
