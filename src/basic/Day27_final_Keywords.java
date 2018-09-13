package basic;

/**
 * final 关键字
 *  final是跟extends相反的功能
 *  即可以修饰变量，方法，类
 *  被final修饰的类不可以被继承，表示最终类，不能有子类继承
 *  被final修饰的方法，不可以被复写
 *  被final修饰的变量，是一个常量。即可以修饰成员变量，
 *      也可以修饰局部变量。常量的书写要用大写的字母组成 如果有两个单词，则必须用_来链接。
 *  @author ShineWong
 *
 */
public class Day27_final_Keywords
{
    public static void main(String [] args)  //主函数 入口
   {
	Start s=new Start();  //创建一个实体对象为s
      s.run_2();    //调用了子类中的erun方法
	
      s.b=5004;
	s.run_3();

 }
} 

  class Final
{
	  
	  final int a=50;
	  int b=10;
	 final void run()   //被final 修饰的成员方法，不能再被子类所复写，这有利与提高安全性
	{
		int x=2;
		System.out.println(x);
	}
	void run_2()     //没有被final修饰的run_2可以被子类所复写。
	{
		System.out.println("HUANG");
	}
	
	void run_3()     //没有被final修饰的run_2可以被子类所复写。
	{
		
		//final int a=52;  //被final修饰的变量，从始至终都不会改变原来定好的值，也就是说，即使被子类 所修改 ，但最后好还是原来的那一个值。
		// int b=50;
		System.out.println(" a="+this.a+",b="+this.b);
	}

}

  
class Start extends Final
{
	void run_2()
	{
		System.out.println("Guang yi");
	}
}
