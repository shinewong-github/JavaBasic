package string;

/**
 * 在Test的基础上，求两个字符串共同的最大字符串
 * @author ShineWong
 *
 */
public class StringTest05 {

	public static String getMaxSubString(String s1,String s2){
		
		for(int x=0;x<s2.length();x++){
			for(int y=0,z=s2.length()-x;z!=s2.length()+1;y++,z++){
			String temp=s2.substring(y,z);
			//sop("子字符串可以是：    "+temp);//打印所有子字符串
			if(s1.contains(temp))
				 return temp;
			
			}
		
		}
		
		return "";
	}
	public static void main(String[] args) {
		String s1="abeudHellojecnf";
		String s2="efdeHellos";
		sop(getMaxSubString(s1,s2));
		
	}
	public static void sop(String str){
	System.out.println(str);
	}
	//上面方法要把短字符串放在s2的位置，把长字符串放在s1的位置，这样子有点局限性
	/*
	 * 
	public static String getMaxSubString(String s1,String s2){
		
		for(int x=0;x<s2.length();x++){
			for(int y=0,z=min.length()-x;z!=s2.length()+1;y++,z++){
			String temp=min.substring(y,z);
			//sop("子字符串可以是：    "+temp);//打印所有子字符串
			if(max.contains(temp))
				 return temp;
			
			}
		
		}
		
		return "";
	}
	public static void main(String[] args) {
		String s1="abeudHellojecnf";
		String s2="efdeHellos";
		 String max=(s1.length()>s2.length())?s1:s2
		 String min=(max==s1)?s2:s1
		sop(getMaxSubString(s1,s2));
		
	}
	 * 
	 * 
	 * 
	 * 
	 */
}
