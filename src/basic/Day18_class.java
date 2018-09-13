package basic;

/**
 * 类与对象的基本操作
 */

class Person{
	 int age;   //成员变量
	 String name;//成员变量
	 String sex;//成员变量
	 
 /**
  *成员方法 
  */
   void speak(){
		System.out.println("My name is "+name+","
                        + "   I am a "+sex+"\n"+'\n'+"And today I am "
				        +age+"years old");
    }
}
	
/**
 * public class
 */
public class Day18_class
 {
	/**
	 * main方法
	 * @param agrs
	 */
 public static void main(String [] agrs) //主函数入口
 {
	 
	Person c=new Person(); //创建一个实体 c;
	c.age=23;              //调用 成员变量 并赋值23
	c.name="HuangGuang yi";//调用 成员变量中的name 并赋值为 "HuangGuang yi"
	c.sex="man";        //调用成员变量中的 sex 并赋值为 "man"
	c.speak();         //调用 成员方法，实现的功能是 打印 name sex 以及 age
 }
 }
