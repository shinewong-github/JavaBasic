package io;
/* PrintStream是一个字节输出流对象，调用其print方法,可以将数据打印出来*/
//PrintWriter是一个字符输出流对象，调用其print方法,可以将数据打印出来



import java.io.*;
public class Day26_printStream {
public static void main(String[] args) throws Exception {
	String s="dddd";
	char n='f';
	//PrintStream ps=new PrintStream("F:\\FF.txt");
	PrintStream ps=new PrintStream(System.out);
	ps.print(s);
	ps.print(n);
	
}


}