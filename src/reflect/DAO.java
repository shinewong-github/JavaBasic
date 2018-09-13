package reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DAO<T> {
	private Class<T> clazz;

	/**
	 * 当泛型和this传递到子类中去时，this此时指向的是自立本身：
	 *   this.getClass()-->指向的是子类
	 *   this.getClass().getSuperclass()-->指向的是继承的父类，也就是DAO
	 *   getGenericSuperclass()该方法是获取父类的泛型参数
	 */
	public DAO() {
		System.out.println("I am DAO<T>");
		System.out.println(this);//子类
		System.out.println(this.getClass());//子类
		System.out.println(this.getClass().getSuperclass());//DAO
		
		System.out.println("获取父类的泛型参数" + this.getClass().getGenericSuperclass());
		// Type是一个接口，其子接口parameterType用来操作父类的泛型参数
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] agrs = parameterizedType.getActualTypeArguments();
			// 是否有参数的判断
			if (agrs != null && agrs.length > 0) {
				Type agr = agrs[0];
				if (agr instanceof Class) {
					clazz = (Class<T>) agr;
				}
			}
		}
		System.out.println(clazz);

	}
	/*
	 * 返回值类型是T，决定于DAO<T>的可变可决定的泛型参数
	 * T 是People
	 */
	T get(Integer id) {
		System.out.println(clazz);
		return null;
	}

	void save(T entity) {

	}
}
