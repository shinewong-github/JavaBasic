package exceptionHandling;

class FushuException extends Exception//用户自定义异常，派生与Exception
{

	private static final long serialVersionUID = 1L;
	//该类是继承Exception类的，所以有Exception类的方法，可查JAVA API文档

}

class Ziding
{
 int run(int a,int b) throws Exception//在方法 头中声明异常，方法里面并没有定义try catch 块
{ 
	 if(b<0) 
		 throw new FushuException();
	 
     return a/b;
 }
}

public class Day07_1
{
public static void main(String [] args)
{
	Ziding zi=new Ziding();
	
	try
	{
	   int b=zi.run(4,-2);
		System.out.println(b);
	}
	catch(Exception e)
	{
		System.out.println("捕获到了一个非法的负数，请加以重视"+e.toString());
		System.out.println(e.getMessage());
		
	}

 }
}
