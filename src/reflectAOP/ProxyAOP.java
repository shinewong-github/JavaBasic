package reflectAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Aspect orient Programming
//这是动态代理的运用，面向切面的编程，把通用的方法卡到动态代理的方法中，也是实现代码复用的功能。
//也就是说可以动地在代理方法中插入模板方法。

interface Human {
	public void run();

	public void fly();

}

class SuperMan implements Human {
	@Override
	public void run() {
		System.out.println("我是超人跑得快");

	}

	@Override
	public void fly() {
		System.out.println("我是超人，我会飞");

	}
}

// 将这两个类的共四个方法插入到动态的代理方法中
class HaveName {
	public void getName() {
		System.out.println("我是有名字的");
		System.out.println("对，有名字的会被人记住");
	}
}

class HaveDream {
	public void getDream() {
		System.out.println("我是有梦想的");
		System.out.println("对，有梦想的的都了不起");
	}

}

class MyinvocaHander implements InvocationHandler {
	Object obj;

	public void setObject(Object obj) {
		this.obj = obj;

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {// 统一绑定将要执行的方法
		HaveName HN = new HaveName();
		HN.getName();
		Object returnVal = method.invoke(obj, args);// 在这里调用的是被代理对象的方法，方法返回值用Object来接收
		HaveDream HD = new HaveDream();
		HD.getDream();
		return returnVal;
	}
}

class MyProxy {// 获取代理类实例
	public static Object getProxyIntance(Object obj) {
		MyinvocaHander proxyInvokeHander = new MyinvocaHander();
		proxyInvokeHander.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				proxyInvokeHander);// 已经调用处理程程序的函数
	}

}

public class ProxyAOP {

	public static void main(String[] args) {
		SuperMan s = new SuperMan();
		Human human = (Human) MyProxy.getProxyIntance(s);
		human.run();
		System.out.println();
		human.fly();

	}

}
