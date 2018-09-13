package basicDataType;
/**
 * 测试和验证Integer类，一些常见方法的使用：
 * toBinaryString、
 * toHexString、
 * parseInt、
 * toString等
 * 
 * 业务逻辑：查看方法参数传递
 *使用main测试
 */
public class In {
public static void main(String[] args){
	  System.out.println(Integer.toBinaryString(1000));//计算8转换成二进制。
	  System.out.println(Integer.toHexString(12));//计算12十六进制
	  System.out.println(Integer.parseInt("31",16));//转换十六进制字符串表示的"31"成int
	  System.out.println(Integer.toString(34));//int转成string类型
	  
	  
 }
}
