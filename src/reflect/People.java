package reflect;

public class People {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
		System.out.println("年龄:" + age);
	}

	public void setAgeName(String name, Integer age) {
		this.age = age;
		this.name = name;
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}

	private void test() {
		System.out.println("我是一个测试方法");
	}

	private void method1(Integer age) {

		System.out.println("I am A People，My age is ：" + age);

	}
	private void method2(Integer age) {

		System.out.println("I am A People，Mymethod2 can make My name To be ：" + age);

	}


	private void method2(String name) {

		System.out.println("I am A People，My name is ：" + name);

	}
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("有参的构造函数");
	}
 
	/**
	 * 定义一个无参数的构造函数，用来被反射用。
	 */
	public People() {
		System.out.println("我是一个无参的构造函数，主要是被反射用的 ！");

	}
}
