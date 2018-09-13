package string;

 /**
  * 需求：将一个字符串进行反转
  *    例如：比如"Hello World!"---->"dlroW olle!
  *  思路：
  *  1：先将字符串转换成字符数组 char [] arr=str.toCharArray()
  *  2：再将字符数组进行反转
  *  3：再将反转后的字符数组转成字符串  String(char[] value)
  *    
  * 扩展：将z字符串指定的部分进行反转
  *       public static String reverseString(String str ,int start,int end){
			    char [] arr=str.toCharArray();
				reversecharArray(arr, start, end);
				return new String (arr);
			}
			public static void reversecharArray(char[] arr,int x,int y){//将指定字符数组中的字符反转
				for(int start=x,end=y-1;start<end;start++,end--)
				swap(arr,start,end);
			}
  * 
  */
public class StringTest_Reversal {

public static void main(String[] args) {
	
     String str="Hello World!";
     System.out.println( reverseString(str));
			
}      
           public static String reverseString(String str){
        	     char [] arr=str.toCharArray();//将字符串变成字符数组
        	 	reversecharArray(arr);//将字符数组进行反转
        	 	return new String (arr);//用String(char[] value)构造函数，将字符数组变成字符串
	
           }
			public static void reversecharArray(char[] arr){//这函数用来反转字符数组的字符
				for(int start=0,end=arr.length-1;start<end;start++,end--)
				swap(arr,start,end);
			}
			
						public static void swap(char[] arr,int x,int y){//这个函数用来交换数组中的元素
				
				char temp=arr[x];
				arr[x]=arr[y];
				arr[y]=temp;
				
				/*
				   下面这个交换是错的
				 int temp=0//这样的定义会使得第一角标的字符跟x角标的字符一样
				 arr[temp]=arr[x];
				 arr[x]=arr[y];
				 arr[y]=arr[temp];
				 
				 */
			}
			
			
				
}

