package basic;

/**
 * this 关键字的另外一种用法   this(变量名)
 * 注意this(变量名)的位置，，，要放在第一条语句中
 * @author ShineWong
 *
 */
public class Day24_this_Keywords 
{

	public static void main(String[] agrs) 
	{
		Computer pc= new Computer("liangxiang",4200);
		   //在堆内存中创建一个对象，调用构造函数computer(String brand,int prise)
             pc.run();  //调用run函数，实现打印结果。                       
                   
	}
}

/**
 * 创建一个类名为computer的类
 * @author ShineWong
 *
 */
class Computer
{
  private int prise;    //成员变量
  private String brand; //成员变量
	
  /**
   *构造函数  ，默认值为空
   */
  Computer(){}
   
   /**
    *构造函数    函数参数为int prise
    * @param prise
    */
  Computer(int prise)    
	{ 
		  this.prise=55555;		
	}
	
  /**
   * 
   * @param brand
   * @param prise
   */
  Computer(String brand,int prise)
	{     
	       this(prise); // 局部变量的复用 。this(prise)必须要放在第一条语句中
	       this.brand=brand;
	}
	
  /**
   * 这是成员方法 或叫成员属性。
   */
	void run()     
	{
		System.out.println(" the computer's brand is "+brand+ " "
				    + " that costs me "+ prise);
	}
}

