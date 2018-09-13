package io;
/*
 * create my defined BufferedInputStream  
 * 原理：
 * 字节缓冲区封装了字节数组，把从read(buf)\数组读到的放到自己的数组缓冲区中
 * 
 * 
 **/
import java.io.*;

public class Day25_myBufferedInputStream 
{
	public static void main(String[] args)throws Exception
	{	
		  long start=System.currentTimeMillis();
		  copy();
		  long end=System.currentTimeMillis();
		  System.out.println((end-start)+"毫秒");
		
	}	
		
		public static void copy() throws Exception
		{
			MyBufferedInputStream bufin=new MyBufferedInputStream(new FileInputStream("01.mp3"));
			BufferedOutputStream bufout=new BufferedOutputStream(new FileOutputStream("01copy.mp3"));
			int ch=0;
			int x=1;
			System.out.println("第一个字节是"+bufin.myread());

			while((ch=bufin.myread())!=-1)//read()方法返回的是 int类型的，ch是int类型的该方法是一位一位的读取
			{
				

				bufout.write(ch);//Write方法只把最低8位写到指定的文件中，
			}
			bufin.myclose();
			bufout.close();
		
	     }
}

class MyBufferedInputStream 
{
	
	private InputStream in;
	private int pos = 0, count = 0;
	private byte[] buf = new byte[1024];

	MyBufferedInputStream(InputStream in)
	{
	   this.in=in;
	}
	   public int myread() throws IOException//返回值类型是int的8位，return的是byte类型的8位，自动类型提升
	   {
		   if(count==0)
		   {
			   count=in.read(buf);//从文件中，按一个字节的方式读到byte[]数组中。数组的长度是1KB
			   
		        if(count<0)//当读到文件末尾时就返回-1
		          return -1;
		        
		  //返回第一个字节，并以32的int类型返回
		        pos=0;//当要读第一个字节的时候，就就pos重新归0一下
		        byte b=buf[pos];
			    count--;          //count=1023
			    pos++;           //pos=1
			    return b&255;  	/*在数据被提升为int类型之前，先与255做与运算，使一个8位的数据的前24位不被补位1
			                     *而是被补位0，这样当执行while(ch=bufin.myread()!=-1)就不会进行了误判了。
			                     *最后由Write方法自动剔除掉最高24位，把最高8位写进文件输出流中。
			                     *这样一来即保证了原数据的不变，又可以出现误判的情况。
	                             */
		   }
			  
			  else if(count>0)//从buf数组的1下标开始取数据
			   {
				   byte b=buf[pos];
				   count--;
				   pos++;
				   return b&0xff;
				   		   
			   }
			   return -1;
		   
	   }
	   public void myclose() throws IOException
	   {
		in.close();   
	   }
	}

