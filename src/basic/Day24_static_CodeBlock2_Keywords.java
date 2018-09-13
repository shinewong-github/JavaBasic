package  basic;

/**
 * 在类文件一被加载，就先去找静态的
 * 先找静态成员，再找静态代码块，再找实例化的
 * @author ShineWong
 *
 */
class Tool{
	Tool(int i){
		System.out.println("Tool("+i+")");
		}
	void f(int i){
		System.out.println("f("+i+")");
	}
	
	
}

class Tools{
	Tool t1=new Tool(1);//在Tools类中创建Tool类的对象，并一初始化就把打印Tool(1)
	static Tool t3=new Tool(3);
	//在Tools类中创建Tool类的静态对象，并一初始化就把打印Tool(3)，其米目的是对象
     	//Tools一建立就有共享的t3
	static {
		System.out.println("进入静态初始化块");
        t3=new Tool(33);
         t4=new Tool(44);
    	System.out.println("退出静态初始化块");
	}
	{
		System.out.println("进入实例化初始化块");
        t1=new Tool(11);
        t2=new Tool(22);
    	System.out.println("退出实例化初始化块");
	}
	Tools(){
		System.out.println("Tools()");
		t2=new Tool(222);
	}
	static Tool t4=new Tool(4);
	Tool t2=new Tool(2);
}

public class Day24_static_CodeBlock2_Keywords{
	Tools ts=new Tools();
	{
		System.out.println("Hello !");
		
	}
	Day24_static_CodeBlock2_Keywords(){
		System.out.println("Day20()");
		
	}
	public static void main(String[] args) {
		System.out.println("call Tools.t4.f(4) in main()");
		Tools.t4.f(4);
		System.out.println("Creating new Tools()in main()");
		new Tools();
		System.out.println("Creating new Day20() in main()");
		new Day24_static_CodeBlock2_Keywords();
	}
	static Tools ts2=new Tools();

}