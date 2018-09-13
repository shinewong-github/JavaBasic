package javaCollentionFrame;
import java.util.*;
/**
 * 测试和验证ArrayList：
 * 取出ArrayListDemo集合中的重复元素
 */
public class Day1004_arrayListDemo 
{
public static void main(String[] args) 
{
	ArrayList a=new ArrayList();
	    a.add("java01");
	    a.add("java02");
	    a.add("java03");
	    
	    a.add("java02");//去除掉java02
	    a.add("java02");
	    sop(a);
	   a=singleElement(a);
	   sop("去除重复后的集合是：");
	   sop(a);
	    
}    
public static ArrayList singleElement(ArrayList a)
	    {
	    //定义一个临时容器	
          ArrayList newa=new ArrayList();
          
          Iterator it=a.iterator();
	      while(it.hasNext())
	      {
	         Object obj=it.next();
	         if(!newa.contains(obj))
	        	 newa.add(obj);
	      } 
	      return newa;
	    }

	public static void sop(Object o)
	{
		  System.out.println(o);  
	}
	
}
