package javaCollentionFrame;

import java.util.*;

/**
 * 验证和测试接口编程：Collection c=new ArrayList():
 * add(对象)，向集合中添加对象
 * arrayList2.retainAll(arrayList1),取集合中的交集。
 * arraylist.iterator。取元素
 * @author ShineWong
 *
 */
public class Day1003_collectionDemo 
{
	public static void main(String[] args) 
	{

		ArrayList arraylist = new ArrayList();// 集合1
		arraylist.add("java01");//字符串对象
		arraylist.add("java02");//字符串对象
		sop(arraylist);

		ArrayList arraylist1 = new ArrayList();// 集合2
		arraylist1.add(new person1());//添加一个person对象
		arraylist1.add(new car());//添加一个cat对象
		arraylist1.add("java02");////添加一个字符串对象
		arraylist1.retainAll(arraylist);// 把两个集合的交集放在前面那个集合中：这个方法是取交集用的

		sop(arraylist1);
		sop(arraylist1.size());
		
		// 迭代器的基本使用
		// Iterator it=new Iterator();不用亲自new一个迭代器出来
		sop("Iterator遍历集合中的元素");
		Iterator it = arraylist.iterator();
		while (it.hasNext())
		{
			sop(it.next());//it.next()是取出集合里面的元素
		}
	}

			public static void sop(Object o) 
			{
				System.out.println(o);
			}
}

class person1 
{
	int age = 14;
	String name = "huang guang yI";

	public void eat() 
	{
		System.out.println("I am" + name + ",and this year I am just" + age);
	}
}

class car 
{
	private int number;
	private String paizi;

	public int get(int number) 
	{
		return number;

	}

	public void set(int number)
	{
		this.number = number;

	}

}