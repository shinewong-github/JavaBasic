package reflectAOP;

public class StaticProxyTest {
public static void main(String[] args) {
   //创建接被代理类的对象和代理对象
	StaticIsProxy isPorxy=new StaticIsProxy();
	//StaticPorxy porxy=new StaticPorxy(inface),这里传进去的是一个接口的实现类，不能是接口
	StaticProxy porxy=new StaticProxy(isPorxy);//传参可以是接口子类的对象
	//开始调用：至少必须要知道被代理类中其父接口中的方法
	porxy.productCloth();
	porxy.productClub();//调用的是被代理类的方法
	porxy.productPen();//调用的是被代理类的方法

}
}
