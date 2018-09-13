package exceptionHandling;

/**
 * 自定义类型异常类的小练习
 * 在本练习中，有：电脑对象（电脑运行，电脑重启），老师对象（讲课），
 * 现在考虑回出现的问题：
 * 1：电脑蓝屏了
 * 2：电脑冒烟了
 * 3：电脑死机了
 *   .....等等问题
 *   并将问题封装成对象
 */
class LanpingException extends Exception//封装了蓝屏的问题，并继承了Exception类。可以解决的一类问题。
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LanpingException(String message)//该构造函数的方法是获取（打印）传入的信息。
	{
		super(message);
	}
}
class MaoyanException extends Exception//封装了冒烟的问题，并继承了Exception类。可以解决的一类问题。
{
	MaoyanException(String message)//该构造函数的方法是获取（打印）传入的信息。
	{
		super(message);
	}

}
class NoPlanException extends Exception//封装问题。
{
	NoPlanException(String message)//该构造函数的方法是获取（打印）传入的信息。
	{
		super(message);
	}
}

class Computer//定义了一个电脑类，
{
  private int state=1;
  public void run()   throws LanpingException,MaoyanException//声明该方法可能存在着问题。要抛出去。给调用该方法的调用者，如果调用不进行处理额话，则程序即将停止执行下去。
  {
	  //在这里复习一下try catch的处理机制。
	  //自定义的异常处理，条件限制。在这里有两种处理方法，（1：在函数上进行声明；2：在函数内部进行try catch的处理）
	  if(state==2)
		  throw new LanpingException("电脑蓝屏了");//抛出去的是一个问题的实例对象，在构造函数这中，可以传入具体的值。
	 
	  //自定义的异常处理，条件限制。在这里有两种处理方法，（1：在函数上进行声明；2：在函数内部进行try catch的处理）
	  if(state==3)
		  throw new MaoyanException("电脑冒烟了");//抛出去的是一个问题的实例对象，在构造函数这中，可以传入具体的值。
       System.out.println("电脑运行");
       
    }
 public void restart()
  {
	 int state=2;
	  System.out.println("电脑重启");
	  
  }
}
class Teacher
{
	 private String name;//把老师的名字给私有化。
	 private Computer cmpt=new Computer();//初始化老师以来就有一个电脑，即为可以初始化并创建一个类对象
	 Teacher(String name)//对私有化的东西提供外部接口
	 {
		 this.name=name;
		 //cmpt=new Computer();
	 }
    public void prelect() throws NoPlanException//老师讲课的方法
  {
	try
	{
	cmpt.run();//这个方法可以调用电脑的运行方法
	}
	catch(LanpingException e)//抓异常并且按照自己定义的方式处理异常
	{
		cmpt.restart();//这是在处理异常的方法
	}
	catch(MaoyanException e)//冒烟处理不了，抛出去
	{
		throw new NoPlanException("课时无法继续");
	}
	System.out.println("讲课");
  }
}
public class Day15 
{
  public static void main(String [] args)
  {
	 Teacher t=new Teacher("黄光义老师");//创建一个老师类的对象
     try
     {
    	t.prelect(); 
     }
     catch(NoPlanException e)
     {
    	 System.out.println(e.toString());
    	 System.out.println("换老师或者换电脑");
    	 
     }
	 
  }
}
