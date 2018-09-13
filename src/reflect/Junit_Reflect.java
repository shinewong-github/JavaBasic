package reflect;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class Junit_Reflect {
	
	/**
	 * 获取父类的泛型，可以创建一个相关联的泛型类对象，执行更多的操作。
	 * 当父类中传递多个泛型参数时，可以根据索引index来指定执行的具体泛型类
	 * 获取实际的参数：   
	 *    Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
	 *    
	 * @param Class clazz
	 * @param int index
	 * 该方法是根据索引来获取泛型的参数类型
	 * */
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenericType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();

		//如果没有泛型参数就返回Object
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		//得到实际的泛型参数
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		//如果查找的泛型下表越位，也返回Object
		if (index >= params.length || index < 0) {
			return Object.class;
		}
       //如果不包含，也返回Object
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
      //成功返回，所需要的泛型参数
		return (Class) params[index];
	}

	/**
	 * 测试上面的getSuperClassGenericType
	 * BaseDAO<T,PK>{}
	 *   EmployeeDAO extends BaseDAO<Employee,String>
	 *   Employee= getSuperClassGenericType(clazz,0)
	 *   String=getSuperClassGenericType(clazz,1)
	 */
	@Test
	public void testgetSuperClassGenericType() {
        Class clazz=EmployeeDAO.class;
        Class clazz2=getSuperClassGenericType(clazz,0);
        System.out.println(clazz2);
        
        Class clazz3=getSuperClassGenericType(clazz,1);
        System.out.println(clazz3);
	}

	/**
	 * 开发的时候用的比较多，通过放射可以知道父类传递过来的实际的泛型参数
	 */
	@Test
	public void testGenericAndReflection() {
		PeopleDAO peopleDAO = new PeopleDAO();
		 People entity=new People();
//		 peopleDAO.save(entity);
		// People result=peopleDAO.get(1);
		//

	}

	/**
	 * 获取完属性后，可以获取属性的值和设置属性的值
	 */
	@Test
	public void testField() throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		//获取属性
		Class clazz = Class.forName("reflect.People");
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
System.out.println(field);
		}
		
		//访问field
		People people = new People("黄光义", 20);
		for (Field field : fields) {
			field.setAccessible(true);
			Object val = field.get(people);
System.out.println(val);
		}

		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(people, "黄氏家族");
		System.out.println(people.getName());

	}

	/**写一个方法，如果在该类中没有，则就去父类中访问该方法，直到Object.包括私有方法在内的所有方法,如果没有就抛出异常。
	 * 执行方法的问题前，设置方法可访问：method.setAccessible(true);
	 * @param obj
	 * @param methodName
	 * @param agrs
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public Object getMethodInvoke(Class clazz, String methodName, Object... agrs) throws Exception {
		Class[] parameterTypes = new Class[agrs.length];
		for (int i = 0; i < agrs.length; i++) {
			parameterTypes[i] = agrs[i].getClass();
		}
		Method method = null;
		for (Class clazz2 = clazz; clazz2 != Object.class; clazz2 = clazz2.getSuperclass())
			try {
				method = clazz2.getDeclaredMethod(methodName, parameterTypes);
			} catch (Exception e) {

			}

		// 由上面已经得到了方法，接下来就是要执行方法的问题了.
		method.setAccessible(true);
		Object obj = clazz.newInstance();
System.out.println("创建" + obj + "实例");
     	return method.invoke(obj, agrs);

	}
	/**
	 * 测试上面的getMethodInvoke的方法
	 * @throws Exception
	 */
	@Test
	public void testgetMethodInvoke() throws Exception {
		Object result = getMethodInvoke(Class.forName("reflect.Student"), "method2", 20);
		System.out.println(result);
	}

	/**
	 * 获取方法(只是获取方法而已并没有执行) 如果该类有该方法，则在本类中获取 如果该类没有该方法，则去父类中获取 
	 * 注意：获取方法不用把当作参数传入，执行方法时才需要。
	 */
	public Method getMethod(Class clazz, String methodName, Class... parameterTypes) {

		for (; clazz != Object.class; clazz = clazz.getSuperclass())
			try {
				Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				System.out.println(clazz + "没有这个方法，他向父类找去了！");
			}
		return null;

	}

	/**
	 * 对上面的getMet
	 * hod的测试
	 */
	@Test
	public void testgetMethod() throws ClassNotFoundException {
		Method method = null;
//		method = getMethod(Class.forName("java.lang.Object"), "toString", String.class);
		method = getMethod(Class.forName("reflect.Student"), "method2", Integer.class);
System.out.println(method);
	}
	
	/**
	 * 测试获取父类的Class对象
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testgetSuperClass() throws ClassNotFoundException {
		Class clazz = Class.forName("reflect.Student");
		Class superClazz = clazz.getSuperclass();
System.out.println(superClazz);

	}

	/**
	 * 若要通过反射的方式执行私有的方法，则要在method.invoke()执行前添加一行代码为method.setAccessible(true) ：
	 */
	@Test

	public void testInvokePrivateMethod() throws Exception {
		// Object obj=new Student();
		// Class clazz=obj.getClass();
		// Method method=clazz.getDeclaredMethod("method1", Integer.class);
		// method.setAccessible(true);
		// method.invoke(obj,20);

		Method method = Class.forName("reflect.Student").getDeclaredMethod("method1", Integer.class);
System.out.println(method);
		method.setAccessible(true);

		method.invoke(Class.forName("reflect.Student").newInstance(), 20);
	}

/*-----------------------------------------------------------------------------------------*/
	/**自己写一个工具类方法，通过传入全类名，该类的方法名，该方法的参数，来执行该方法 这是是对下面invoke方法的增强
	 * @param String
	 * @param name
	 * @param methodName
	 * @param agrs
	 * @return 
	 */
	public Object invoke(String className, String methodName, Object... agrs) {
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
			return invoke(obj, methodName, agrs);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		return null;

	}
/*-----------------------------------------------------------------------------------------*/
	
/**自己写一个工具类方法，通过传入实例化的对象，该类的方法名，该方法的参数(参数不确定，所以就用可变的参数列表Object...agrs来代替)，来执行该方法。
 * 传统的做法是先获取到方法名再执行方法体，通过以下这个方法可以一步到位。
 * 难点：需要将传入的可变参数(实际传参)转变成获取方法名这一步骤所需要的参数类型，型如：	Class[] parameterTypes
 * 
 * Object... agrs：可变参数，具有不确定性。
 * @param obj
 * @param methodName
 * @param agrs
 * @return 
 */
	public Object invoke(Object obj, String methodName, Object... agrs) {
		// 如何将可变参数变成参数列表
		Class[] parameterTypes = new Class[agrs.length];
		for (int i = 0; i < agrs.length; i++) {
			parameterTypes[i] = agrs[i].getClass();
		}
		try {
			Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
			
			// 现在已经获取到了某个类下的具体的方法(确认的参数类型)，下一步就是执行就行了(通过传对象和方法的参数).
			return method.invoke(obj, agrs);// 执行方法之前，已经确认是有具体的方法名了，所以执行时只需要传入的参数是对象和实际参数
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 测试上面执行方法
	 */
	@Test
	public void testinvoke() {
		Object obj = new People();
		//通传入对象和方法名，以及实际参数的形式来执行指向的对象的方法
		invoke(obj, "setAgeName", "黄光义", 26);
		invoke("reflect.People", "setAge", 26);

	}
/*-----------------------------------------------------------------------------------------*/
	
	/**
	 * 实验的对象是Person，测试Person的方法。
	 * 	获取方法的名字：method.getName
	 * 
	 * 获取clazz的非私有方法：getMethods
	 * 获取clazz的自己声明的全部方法：getDeclaredMethods
	 * 
	 * 通过制定的方法名和指定的参数列表，获取指定的的方法：
	 *   clazz.getDeclaredMethod("setName", String.class)
	 * 获取无参数列表的方法时：
	 *   clazz.getDeclaredMethod("test")
	 *   
	 * 运用：得到方法之后，需要参数相关的参数来调用方法：
	 *     Object obj = clazz.newInstance();// 用多态创建对象，父类引用执行子类对象。指向Person
		   method.invoke(obj, "黄光义", 25);//
	 *    
	 * @throws Exception
	 */
	@Test
	public void testMethod() throws Exception {
		Class clazz = Class.forName("reflect.People");
		
		// 获取clazz的非私有方法
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
System.out.println("People类的非私有方法:" + method.getName());
		}
		
		// 获取clazz的自己声明的全部方法
		Method[] methods2 = clazz.getDeclaredMethods();
		for (Method method : methods2) {
System.out.println("People类的所有方法:" + method.getName());
		}

		// 通过制定的方法名和指定的参数列表，获取指定的的方法。
		Method method = clazz.getDeclaredMethod("setName", String.class);
System.out.println("获取指定的的方法-----------------------------" + method);

		//无参数列表
		method = clazz.getDeclaredMethod("test");
System.out.println("获取指定的的方法-----------------------------" + method);
		try {
			//两个参数列表
			method = clazz.getDeclaredMethod("setAgeName", String.class, Integer.class);
System.out.println("获取指定的的方法-----------------------------" + method);
		} catch (Exception e) {
			System.out.println("获取不到");
		}

		// 在获取到了方法名之后，需要传入对象和相关的参数：这才是运用。
		Object obj = clazz.newInstance();// 用多态创建对象，父类引用执行子类对象。指向Person
		method.invoke(obj, "黄光义", 25);// 折种方式是已经获取到了具体的方法名了。

	}
	
	/**
	 * 
	 * 测试各种ClassLoader：
	 * 获取系统类加载器：ClassLoader.getSystemClassLoader()
	 * 获取系统类加载器的父类加载器:拓展类加载器：loader.getParent()
	 * 测试当前类由哪个类加载器来加载：获取拓展类的父类加载器：引导类加载 ：loader.getParent()
	 * 
	 * 运用在：获取类路径下的文件：
	 *     InputStream in = this.getClass().getClassLoader().
	 *                     getResourceAsStream("test.properties");// 文件要放在包的SRV目录下
	 *    
	 * 
	 * Class.forName("reflect.People").getClassLoader()
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testClassLoader() throws ClassNotFoundException, FileNotFoundException {
		// 获取系统类加载器
		ClassLoader loader = ClassLoader.getSystemClassLoader();
System.out.println(loader);
		// 获取系统类加载器的父类加载器:拓展类加载器
		loader = loader.getParent();
System.out.println(loader);
		// 获取拓展类的父类加载器：引导类加载
		loader = loader.getParent();
System.out.println(loader);

		// 测试当前类由哪个类加载器来加载
		loader = Class.forName("reflect.People").getClassLoader();
System.out.println(loader);

		loader = Class.forName("java.lang.Object").getClassLoader();
System.out.println(loader);

		// 关于加载类个的一个主要运用
System.out.println("关于加载类个的一个主要运用");
		// 调用getResourceAsStream获取类路径下的我文件对应的输入流。
		InputStream in = null;
		in = this.getClass().getClassLoader().getResourceAsStream("test.properties");// 文件要放在包的SRV目录下
System.out.println(in);

	}
	
	/**
	 * 测试由new Class().newInstance
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test
	public void testInstance() 
			throws ClassNotFoundException, InstantiationException,
			    IllegalAccessException {
		String className = "reflect.People";
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		System.out.println(obj);

	}
	
/**
 * 实例化一个Class对象获取的三种方法，测试People类
 *   1：clazz = Class.forName(className);
 *   2：clazz = People.class;
 *   3:People people=new People()
 *       people.getClass()
 * note:反射的是一个无参数的构造函数
 * @throws ClassNotFoundException
 */
	@Test
	public void testClass() throws ClassNotFoundException {
		Class clazz = null;
		
//		clazz = People.class;

		Object obj = new People();// People people=new People();
		clazz = obj.getClass();

//		String className = "reflect.People";
//		clazz = Class.forName(className);
		System.out.print(clazz);
	}
}
