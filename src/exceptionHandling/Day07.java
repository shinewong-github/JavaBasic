package exceptionHandling;//这是该类所属的包名

class  yichang
{
	public int show(int [] arr,int a) throws Exception
	{  
		return arr[a];
	}	
}
public class Day07 //主函数入口
{
public  static void main(String[] args)
{
	int []arr=new int[4];
	yichang yc=new yichang();
	// int b=yc.show(arr,4);
try
{
   int b=yc.show(arr,4);
   System.out.println(b);
 }
catch(Exception e)//这里的异常参数类型与该异常或者其父类的类型相同，则可以进行与抛出的异常匹配，然后执行catch块
{
	for(int z=0;z<10;z++)
    {
	   for(int v=0;v<z;v++)
	   {
         System.out.print("*");
       }
	   System.out.println();
    }
	System.out.println("数组的下表越界 了");
	System.out.println(e.getMessage());
	System.out.println(e.toString());
  }
 } 
}
