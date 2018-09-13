package stringbuffer;

/**
 * StringBuffer是一个字符串缓冲区
 * @author ShineWong
 *
 */
public class StringBufferTest {
public static void main(String[] args) {
	StringBuffer sbuf=new StringBuffer("Hello World!");
	sop(sbuf.append(true));
	sop(sbuf.append(123));
	sop(sbuf.append("abc"));
	sop(sbuf.append('a'));
	sop(sbuf.append(123.32));
//Hello World!true123abca123.32
//-----------------删除--------------------------
	sop(sbuf.deleteCharAt(0));//清除0角标元素
	sop(sbuf.delete(0,sbuf.length()));//清空缓冲区
	
}
		public static void sop(StringBuffer stringBuffer){
			System.out.println(stringBuffer);
      }
}
