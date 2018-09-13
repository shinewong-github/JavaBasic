package basic;

/**
 * 数组的用法
 * 
 */
public class Day03_array
{
	
     public static void main(String [] agrs){   //主函数
     
   int [] arr={1,3,5,8,0,5,9,5,8,9,9};  
   //
   /*定义数组的方法有：      
    * 1：int [] arr=new int [5]   
	   这表示在对内存中开创了了一个长度为5的数组的空间，不过里面的5个元素默认为0。
    2：int [] arr={1,5,8} 
	  这表示在堆内存中开创了一个分别含有1，5，8三个元素的的数组内存空间
    3:int [] arr=int [];{1,5,.8,9}。
	这表示了在对内存中开创了一个长度4，分别含有个1，5，8，9这元素的内存空间
  */ 
   
  text(arr);     //调用text函数  	 
     getSize(arr);
     
     }

/**
 * 创建一个函数,该函数跟数组有关
 * @param arr
 */
public static void text(int [] arr)
{
	System.out.print("this is my phone: "); 
	for(int x=0;x<arr.length;x++)     //数组常常用到for循环
	{
		System.out.print(arr[x]);
	}
}

public static void getSize(int [] arr)
{
	System.out.println("    this phone.length is: "+arr.length+"个数字"); 

}
}