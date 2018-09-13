package reflect;

/**
 * Student的父类是People
 * @author ShineWong
 *
 */
public class Student extends People {
	private void method1(Integer age) {

		System.out.println("我是一个私有方法，必须要使用method.setAccessible(true)，"
				          + "  才可以访问我; ：" + age);
		System.out.println("Student extends People，"
				          + " And this Student`s age is ：" + age);

	}
}
