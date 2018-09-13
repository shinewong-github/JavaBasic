package basic;

/**
 * 接口使用介绍
 * 接口与接口之间可以实现多继承
 * 而一个类只能继承一个类
 * 一个类可以先继承另一个类，紧接其后可以实现(implements)多个接口:这体现了多继承的特性
 * 基本功能定义在类中，扩展功能定义在接口中。如果需要扩展功能的话就实现某种接口
 * 这也相当于，接口是额外的。比如人一般所天生下来的就是会走路，
 *   如果要使这个人拥有跑的非常快的特性，就可以实现一个额外的接口来拓展其功能
 * @author ShineWong
 *
 */
interface Inter   //相当于一个类
{
	public static int x=10;
	public abstract void show();//可以定义抽象的方法
}
class plant implements Inter
{
	 public void show()
	{
		System.out.println("nn");
	}
} 
public class Day31_interface
{
 public static void main(String [] args)
   {
	 plant p=new plant();
	 p.show();
	 System.out.println(p.x); 
   }
}
