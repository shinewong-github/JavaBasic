package basic;

/**
 * 设计模式-模板方法介绍和需求分析
 * 就好比如，要制作蛋糕，只要往模具里面填入东西，就会出现按模具的方式出来的样子。这就叫模板方法模式
 * 在定义功能时，功能的一部分是确定的，但是有一部分是不确定，而确定的部分在使用不确定的部分(类内部的使用)
 * 那么这时就将不确定的部分暴露出去，由该类的子类去完成
 * 
 * 需求：     制作一个运行不同代码所要时间模板
 * @author ShineWong
 *
 */
public class Day28_pattern_moBan
{ 
	public static void main(String [] args)
 {
   SubTime gt= new SubTime();
    gt.getTime();
	
  }

}

/**
 * 把这份代码进行封装。因为函数具有封装 的属
 * @author ShineWong
 *
 */
abstract  class GetTime
{
	 public final void getTime()  //这只是一个成员中的方法.final的修饰只要是为了不让子类复写该函数
	{
     long start =System.currentTimeMillis();
 		  runcode();
         long end=System.currentTimeMillis();
     System.out.println("运行这段代码的用时为  ："+(end-start)+"  毫秒 ");
     }
	public  abstract void runcode(); //由于这个方法是不确定的所以应该把它定义为抽象的。 那么该类也是抽象类
     
}
class SubTime extends GetTime
{
	
/**
 * 对父类中的第二个函数进行复写，带到模板那边过去，进行加工
 */
   public void runcode()  //这也是一个类中的成员放方法  
	 {
	   for(int x=0;x<5;x++)
	     	{
		  	for(int y=0;y<x;y++)
			   System.out.print("*");
				System.out.println();
			}
	     }
		 
}
