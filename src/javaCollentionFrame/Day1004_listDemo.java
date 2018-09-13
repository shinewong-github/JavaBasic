package javaCollentionFrame; 

import java.util.*;
/**
 *ArrayList
 *增：add(index,element)
 *   addAll(index,Collection);
 *删：remove(index);
 *改:set(index,element);
 *查： get(index)
 *subList(from,to)//包含头，不包含尾
 *listIterator();
 * 
 * @author ShineWong
 *
 */
public class Day1004_listDemo {
public static void main(String[] args) {
	ArrayList arraylist=new ArrayList();
	arraylist.add("java001");
	arraylist.add("java002");
	arraylist.add("java003");
     sop("原集合的元素为："+arraylist);
     
	   arraylist.add(2,"java004");
     sop("增加元素后的集合为： "+arraylist);
     
	   arraylist.remove(0);
	   sop("删除后的集合为： "+arraylist);
	   
	   arraylist.set(1,"java200");
	   sop("修改后的集合为： "+arraylist);
	  
	   
	   sop("查看集合中的所有元素： ");
	   for(int x=0;x<arraylist.size();x++)
	   {
		   sop(arraylist.get(x));
	   }
	   
	   sop("通过index获取对象的位置 ");
	   sop("index="+arraylist.indexOf("java200"));
	   //List sub=arraylist.subList(0,2);
	List sub=arraylist.subList(0,3);
    sop(sub);

    sop("演示一下ListIterator：");
    ListIterator lit=arraylist.listIterator();
    while(lit.hasNext())
    {
        Object obj=lit.next();
       if(obj.equals("java200"))
       {
          lit.set("java0000");//并发修改出错
         
        }
  
    } 
  while(lit.hasPrevious())
    {
      sop(lit.previous());
    } 
	
}
public static void sop(Object o){
	  System.out.println(o);  
}
}
