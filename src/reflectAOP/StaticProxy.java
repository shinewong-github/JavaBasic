package reflectAOP;
//我是一个在静态代理模式下的代理类
//使用静态代理类的弊端是占用内存多，要编译，不利于动态执行
public class StaticProxy implements Interface {
	//需要创建一个接口实例

	Interface inface;//为了调用其实现子类里面的方法
	public  StaticProxy(Interface inface){
		this.inface=inface;
		
	}

@Override
public void productCloth() {
	System.out.println("我是代理商，有买工厂的衣服");
	inface.productCloth();
}

@Override
public void productClub() {
	
	inface.productClub();
}

@Override
public void productPen() {

	inface.productPen();
}
}
