package string;

/**
 * 求一个字符串所包含的所有集合子字符串
 * @author ShineWong
 *
 */
public class StringTest04 {
public static String getMaxSubString(String s1,String s2){
	int index=0;
	for(int x=0;x<s2.length();x++){
		for(int y=0,z=s2.length()-x;z!=s2.length()+1;y++,z++){
		String temp=s2.substring(y,z);
		sop("子字符串可以是：    "+temp);//打印所有子字符串
		}
		sop("------除掉"+x+"个字符的子字符串分别是以上：----- ");
	}
	return "";
}

public static void main(String[] args) {
	String s1="abeudHellojecnf";
	String s2="efdeHellos";
	getMaxSubString(s1,s2);
	
}
public static void sop(String str){
System.out.println(str);
 }
}
