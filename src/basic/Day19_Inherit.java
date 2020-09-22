package basic;

/**
 * 继承:故名思议，就是把属于被继承的类的所有东西全部传递给继承者，
 * 被继承的类称为父类，继承者则称为子类.子类将拥有父类的成员变量和成员方法
 *  JAVA中的继承是单继承。
 * @author ShineWong
 *
 */
class Animal {
	int a = 1;
	protected int  c = 3;
	public int d = 4;

	/**
	 * 以下父类成员方法的功能是 打印：
	 *
	 **
	 ***
	 ****
	 *****
	 ******
	 *******
	 ********
	 *********
	 **********
	 */
	public void print() {
		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < a; b++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
	}
}

public class Day19_Inherit extends Animal {
	public static void main(String[] agrs) {
		Day19_Inherit dayinher = new Day19_Inherit();// 子类继承父类后，在使用子类时，要实例化，即创建对象。
		dayinher.print();
		// 此时调用的方法不是父类的print()，而是子类重写后的print()方法
		System.out.println("继承父类成员 a" + dayinher.a);
		// System.out.println("继承父类成员
		// b"+dayinher.b);无法继承父类成员b，因为被私有化，只能通过其提供的接口方法来实现，即get()和set()
		System.out.println("继承父类成员 c" + dayinher.c);
		System.out.println("继承父类成员 d" + dayinher.d);

	}

	/**
	 * 以下子类成员方法的功能是 打印： 
	 * 
	 */
	public void print() {// 这是对父类方法的复写，重载要求函数名和参数都一样
		for (int a = 0; a < 10; a++) {
			for (int b = 10; b > a; b--) {
				System.out.print("-");
			}

		}
	}
}
