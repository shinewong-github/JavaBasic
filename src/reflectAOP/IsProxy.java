package reflectAOP;
//动态代理式，使用动态代理不可不用知道被代理对象的具体方法，通过其父类接口就可以调用它的方法。在程序运行时执行
//这是模一个被代理类
public class IsProxy implements Interface
{
@Override
public void productCloth() {
	System.out.println("我是被代理类，一个生产衣服的工厂，记得要执行哦~~");
	
}@Override
	public void productClub() {
	System.out.println("我是被代理类，一个生产梳子的工厂，记得要执行哦~~");
		
	}@Override
		public void productPen() {
		System.out.println("我是被代理类，一个生产笔的工厂，记得要执行哦~~");
			
		}
}
