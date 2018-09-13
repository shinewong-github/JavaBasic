package basic;

/**
 * 演示构造函数的例子
 */
public class Day26_constructor {
public static void main(String[] args) {
	ConstructorDemo constructorDemo=new ConstructorDemo();
	ConstructorDemo constructorDemo01=new ConstructorDemo(2,"有参");
 }
}

class ConstructorDemo{
	int age;
	String name;
	public ConstructorDemo() {
		System.out.println("这是一个空参数构造函数");
	}
public ConstructorDemo(int age,String name) {
	this.age=age;
	this.name=name;
		System.out.println("这是一个有参的构造函数: "+age+"-"+name);
	}
	
}