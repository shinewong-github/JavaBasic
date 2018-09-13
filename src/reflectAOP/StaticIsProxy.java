package reflectAOP;

public class StaticIsProxy implements Interface {
@Override
public void productCloth() {
	System.out.println("我是工廠，有衣服生產");
	
}

@Override
public void productClub() {
	// TODO Auto-generated method stub
	System.out.println("我是工廠，有梳子生產");
}

@Override
public void productPen() {
	System.out.println("我是工廠，有笔生產");
	
}
}
