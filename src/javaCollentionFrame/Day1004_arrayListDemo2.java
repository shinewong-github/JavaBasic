package javaCollentionFrame;
import java.util.*;
/**
 * 
 *操作具体person对象
 *去除重复元素。
 */
public class Day1004_arrayListDemo2 {
	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		a1.add(new Person("李四",30));//a1.add(Object obj);//Object obj=new Person("李四",30))
		a1.add(new Person("张三",40));
		a1.add(new Person("王五",50));
		a1.add(new Person("李四",30));
		//a1.add(new Object());
		sop("打印原集合");
		Iterator it=a1.iterator();
	while(it.hasNext())
	{
		Person p=(Person)it.next();
		sop(p.getName()+":"+p.getAge());
	}
	
	sop("打印去除重复元素后的集合");
	  a1=singleElement(a1);
	  Iterator it1=a1.iterator();
		while(it1.hasNext())
		{
			Person p=(Person)it1.next();
			sop(p.getName()+":"+p.getAge());
		}
}
	
	//去除重复元素操作
	public static ArrayList singleElement(ArrayList a1)
    {
    //定义一个临时容器	
      ArrayList newa=new ArrayList();
      
      Iterator it=a1.iterator();
      while(it.hasNext())
      {
         Object obj=it.next();
         if(!newa.contains(obj))//contains调用equals方法
        	 newa.add(obj);
      } 
      return newa;
    }
	
	public static void sop(Object o){
		  System.out.println(o);  
	  }
}
class Person
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public boolean equals(Object obj)//自定义按照自己条件的判断对象是否相等的方法来复写上帝的方法
	{
		if(!(obj instanceof Person))//将obj强转成Person，然后才可在Person 中比较
			return false;//如果不能强转则返回假
		Person p=(Person)obj;//如果可以强转，则强转成Person
System.out.println(this.name+".比较于.."+p.name);
		//System.out.println("d");
		return this.name.equals(p.name)&&this.age==p.age;//如果名字和年龄都相等则判断该对象相等
	}
	
	
	public String getName()
	{
		return name;
		
	}
	public int getAge()
	{
		return age;
	}
	
}