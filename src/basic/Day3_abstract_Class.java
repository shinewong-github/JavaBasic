package basic;

/**
 * 抽象的出现，更能让子类选择父类
 * 
 *  抽象类中，可以有抽象方法和非抽象方法
 * @author ShineWong
 *
 */
 abstract class flao  
{
	
/**
 * 类中有抽象的方法的时候就必须要把其所属的类进行抽象类
 * 而且抽象类中不能进行建立对象
 */
  abstract void show();
	 					   
   void sheep()
   {
	 System.out.println("fdfv");
   }
}

/**
 * songshu  extends flao
 * @author ShineWong
 *
 */
class songshu extends flao
{

/**
 * 这是对抽象方法的复写
 */
	void show()
	{
		for(int x=0;x<5;x++)
		{
			for(int y=x;y<5;y++)
			{
				System.out.print("*"+" +这是 ");
			}
				System.out.println();
		}
		
	}
}
public class Day3_abstract_Class 
{

	public static void main(String [] args)
	{
		songshu so=new songshu();
		so.show();
		so.sheep();
		
	}	

}