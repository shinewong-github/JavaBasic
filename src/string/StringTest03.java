package string;

/**
 * 需求：计算一个字符串在另一个字符串出现的次数
 * 思路：
 *    设计一个计数器，来计算字符串出现的字数
 *     获取字符串(Stirng key)中第一个字符第一次出现的下角标赋值给int index变量，
 *     然后再s=s.subString(index+key.length()),获取第一次出现的字符串完成
 * @author ShineWong
 *
 */
public class StringTest03 {
	
/**
 * 	
 * @param args
 */
	public static void main(String[] args) {
		String str="aabbccddefgkkffccaakkjfi fj";
	   sop("count="+getsubStringCount(str,"kk"));//使用方法1
	   sop("---------------------------------------------------------------");
	   sop("count="+getsubStringCount_1(str,"kk"));//使用方法2
		sop("不建议使用切割函数，会有相差    count="+str.split("kk").length);//不建议使用切割函数，会有相差
	}
	
/**
 * 
 * @param str
 */
	public static void sop(String str){
		System.out.println(str);
	}

/**
 * 
 * @param str
 * @param key
 * @return
 */
public static int  getsubStringCount(String str,String key){//这是方法1
	int index=0,count=0;
	while((index=str.indexOf(key))!=-1){
		sop("str=:"+str);
	str=str.substring(index+key.length());
	count++;
	}
    return count;
}

/**
 * 
 * @param str
 * @param key
 * @return
 */
public static int  getsubStringCount_1(String str,String key){//这是方法2
	
	int index=0,count=0;

	while((index=str.indexOf(key,index))!=-1){
		sop("index=:"+index);
		index=index+key.length();
	
	count++;
	}
    return count;
 }

}
