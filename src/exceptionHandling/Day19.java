package exceptionHandling;
/**异常处理练习
 *计算正方形的面积并判断输入的边长是否为非法值
 *这是一个自定义类的问题处理；同时是一个可以通过修改非法值的，所以可以继承RunTimeException.
 *自定义类条件限制为
 *      if(len<=0)
 *          throw new      ();
 *               
 *通过定义一个接口来收集要求的各种形状的面积（当然这里只求的正方形的面积）

 *构造函数跟一般函数的区别
 */
class NoValueException extends Exception
{
    	NoValueException(String message)//这是一个构造函数，形式参数是字符类型的，变量名
    	{
    		super(message);
    	}
}
interface Shape 
{
	 void getArea();
}
class Square implements Shape 
{
	private int len;//通过私有化变量，只对外提供接口，提供接口的方法如下
	Square(int len)throws NoValueException//不要在类上进行抛出，应该在构造函数或者在一般函数上进行抛出
	{
		if(len<=0)
			throw new NoValueException("您输入的非法数值是非正数的");//这里是字定义的条件限制的抛出异常，在这里抛出的时候，下一步是要么在函数上进行声明，要么在内部进行try ，catch处理
		
			this.len=len;
	}
     public void getArea()  //这个一般函数与上面的这个提供接口的构造函数紧密相关。同时这个方法也是覆盖了接口Shape中的方法，叫做方法的覆盖。
    {
       System.out.println(len*len);
    }

}
public class Day19
{
public static void main(String [] args)
{
	
	try//将可能出问题的代码块放进来，进行问题代码块的检测
	{
		Square sq=new Square(5);
		sq.getArea();
	}
	catch(NoValueException e)//catch 的功能是对一异常的处理方式，就是怎么处理的问题，比如有的 是直接打印出（这里是指打印出NoValueException对象的）里面的东西，相当于调用里面的东西
	//自己理解为：catch（）这是一个构造函数，里面的形式参数为一个类的实例对象，然后，可以通过引用类来调用NoValueException类的里面的方法，即为e.的形式
	{
		System.out.println(e.toString()+"还有"+'\n'+e.getCause()+e.getStackTrace()+'\n'+e.getMessage());
	}
	
  }
}
