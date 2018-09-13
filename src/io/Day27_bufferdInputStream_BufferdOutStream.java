package io;
/*字节缓冲区的简单使用*/
import java.io.*;
public class Day27_bufferdInputStream_BufferdOutStream {
 public static void main(String[] args) throws IOException {
	FileInputStream in=new FileInputStream("F:\\00.txt");
	OutputStream out=System.out;
	BufferedInputStream bufin=new BufferedInputStream(in);
	BufferedOutputStream bufout=new BufferedOutputStream(out);
	int ch=0;
	while((ch=bufin.read())!=-1)
	{
		bufout.write(ch);
	}
	bufin.close();
	bufout.close();

	
}
}
