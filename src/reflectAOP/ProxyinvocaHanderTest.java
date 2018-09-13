package reflectAOP;

import static org.junit.Assert.*;

import org.junit.Test;
//这是一个测试类
public class ProxyinvocaHanderTest {

public static void main(String[] args) {
	//创建被代理类的对象
	IsProxy isProxy=new IsProxy();
	
	//创建代理处理类
	ProxyinvocaHander proxyHander=new ProxyinvocaHander();
	
	//调用代理处理类的bind方法动态返回一个实现了被代理类的父接口的代理类
	      //次过程需要把该代理类进行接口类型强转。因为我们需要调接口的方法，进而间接来处理被代理
	Object Proxy=proxyHander.bind(isProxy);
 Interface inface=(Interface)Proxy;
	//然后再调用接口的方法
 inface.productCloth();
 inface.productClub();
 inface.productPen();
 System.out.println("再举一个例子【【【【】】】】");
 //先来一个被动态代理的类,作为参数，传给bind
 StaticIsProxy StaticisProxy=new StaticIsProxy();
 //创建动态代理实例,需要接收一个被代理类对象给代理处理类的bind方法
     //再把这个代理类对象强制转换成接口类型
 Interface inface2=(Interface)proxyHander.bind(StaticisProxy);
 //调用接口的方法
 inface2.productCloth();
 inface2.productClub();
 inface2.productPen();
 
 
}
}
