package string;

/**
 * 自己定义一个剔除字符串前后空格的函数,mytrim
 * @author ShineWong
 *
 */
public class StringTest_Mytrim {
	
	public static  void sop(String str){//把字符串传进sop这个方法，直接调用这个方法来答应字符串，而不用每一次都使用system.out.println()
		System.out.println(str);
	}
	
	
	public static void main(String[] args)
	{
		
	String s="    Hello World    ";
	sop("剔除空格前的字符串表示为：" +s);
	sop("用系统自带的剔除函数trim(),剔除空格前的字符串表示为：" +s.trim());
	sop("用自己定义的剔除函数Mytrim(),剔除空格前的字符串表示为：" +Mytrim(s));
	}
	
	public static String Mytrim(String str){
		int start=0,end=str.length()-1;
		while(start<end && str.charAt(start)==' ')
		  start++;//这样一下来，使得start这个指针逐渐变大，直到有指向非空字符,int start 就是这个非空字符所在数组的下角标的表示
		  while(start<end && str.charAt(end)==' ')
		   end--;
		 return (str.substring(start,end+1)); 
	}	
}
