package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 使用Class的实例對象clazz获取所在类定义的数据：
 *  1：包括属性的名字，属性的类型，属性修饰符 。
 *  2：包括方法的名字，方法修饰符，方法的返回值类型，方法的参数列表
 *  3：构造函数，构造函数的参数 ,构造函数的修饰符 .等
 *  ------------------这里列举的是方法的属性---------
 */
public class FieldDemo {
	public String id = "cc";
	private String name = "黄光义";
	int number = 6;

	public FieldDemo() {
		System.out.println("一个空的构造函数");

	}

	public void Method01() {
		System.out.println("该方法返回值类型是空");

	}

	public int Method02() {
		return 1;
	}

	public String Method03() {
		return "方法返回值是String類型的";
	}

	public static void main(String[] args)
			throws NoSuchFieldException,SecurityException {
		// 创建Class对象有三种方法
		Class clazz = FieldDemo.class;
		
		// 对单个属性进行描述：用到 Field getField(String string)
		Field singalField = clazz.getField("id");
		//对获取到的属性进行操作
		String FieldName = singalField.getName();
		
System.out.println("获取到的属性是："+singalField+"之后操作该属性获取到的属性名是"+FieldName);	
         
		//获取属性的类型
		Class type = singalField.getType();
		String typeName = type.getName();
System.out.println("该属性的类型是："+type);	

		//返回的是修饰符的整型表示
		int Modify = singalField.getModifiers();
		String stringModify = Modifier.toString(Modify);
System.out.println("该属性的类型是："+type);	

		//获取所有声明的属性
		Field[] allFied = clazz.getDeclaredFields();
		for (Field f : allFied) {
		String name = f.getName();// 获取所有的属性名
		int i = f.getModifiers();//
        String modify = Modifier.toString(i);// 获取所有的属性的修饰符
		Class fieldtype = f.getType();// 返回值类型
		String fieldtypeName = fieldtype.getName();
		System.out.println(name + "," + modify + "," + fieldtypeName + ".");
	}

	}
}
