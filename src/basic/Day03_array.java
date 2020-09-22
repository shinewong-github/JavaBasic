package basic;

/**
 * 数组的用法
 * 
 */
public class Day03_array
{
	
     public static void main(String [] agrs){   //主函数
     
     int [] arr={1,3,5,8,0,5,9,5,8,9,9};

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