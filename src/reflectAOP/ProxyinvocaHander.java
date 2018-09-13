package reflectAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//这是一个动态代理模式
//这是一个代理类，我可以动态的创建
/*
  动态代 理模式是在不知道被代理类的具体的方法和属性之下，
  通过他们两个的共同的接口里边的方法和属性，来间接地使用被代理方法和属性
 *
 *
 */
//两个步骤：
  // 1：动态创建代理类对象：
//ne
public class ProxyinvocaHander implements InvocationHandler
{
	//实例化一个动态代理的对象包含着处理方法，那么肯定到最后要知道被代理的类和接口(可由被代理类加载去父接口)
	
	//在定义实例化代理的实例时不知道要是什么接口的被动态代理类，所以统一用Object来接收
	Object isProxyObject;
	public Object bind(Object isProxyObject){
		this.isProxyObject=isProxyObject;
		// 返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
		return Proxy.newProxyInstance(isProxyObject.getClass().getClassLoader(),
				isProxyObject.getClass().getInterfaces(),this);
	}
//当通过代理类的对象发起对被代理类的方法的调用时，都会转化为如下的invoce方法的调用，
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnVal= method.invoke(isProxyObject,args);//在这里调用的是被代理对象的方法，方法返回值用Object来接收
		return returnVal;
	}

}




















