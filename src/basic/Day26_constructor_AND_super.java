package basic;
 
/**
 * 变量，一般函数和构造函数的继承方法和特点
 * 子类要调用父类中的一般函数：super.函数名()
 * 子类调用父类中的构造函数：super(参数变量名) 
 * ****************************************
 * 多继承是，一个类能能继承多个类。
 * 但是在JVAV语言中，只支持单继承，因为在多继承中，当多个继承中的功能相同时，
 *    子类中可以继承，当父类中定义了功能不同时，子类不知道要继承哪一个，存在安全隐患。
 *  但是JVAV保留这种机制，并用另一种体现形式来表示，多实现
 *  多层继承指的是，爷爷——爸爸---儿子。也就是一个继承体系
 *  想要使用体系，先查阅体系中的父类的描述，因为父类中的定义的 是该体系中共性功能。
 *  通过了解共性功能知道该体系的基本功能
 *  那么这个体系已经可以基本使用了。
 
 *    
 * @author ShineWong
 *
 */
public class Day26_constructor_AND_super
{
	public static void main(String [] agrs)  //主函数----用于对以下的类进行继承的实现。
	{
                     
   Student s=new Student(); //创建 Student 类的实体 s

   Cat c=new Cat();       // 创建一个Cat的实体 c
   c.run();
   
   Horse h1=new Horse();   //创建一个Horse实体  h1
      Horse h2=new Horse(20);// 创建一个实体 h2.当在创建对象时，在括号内，可传入构造函数的参数.在形式参数内的个数与子类中的构造函数相同时，就调用哪一个构造函数的
        Horse h3=new Horse("yi",26);   //创建一个实体h3
	}
 
}							
	
/**
 * 成员变量的继承，函数的继承，构造函数的继承,其中的 this 和super关键字的额用法相同
 * 实验第一类和子类之间在       成员变量      上的继承关系   
 * @author ShineWong
 *
 */                      
class Human    
   {
     String name="zhangsan";
     int age=23;
   }

/**
 * 1：成员变量的继承，继承父类后。子类东的变量是跟父类是一样的。
 * 当子类跟父类出现发了同样的变量时，
 *   如果子类不进对变量的super.变量名的说明，则子类调用的是子类定义初始化的变量值
 * @author ShineWong
 *
 */
class Student extends Human
{
     String name="lisi";
      int age=24;
  
  {
	 System.out.println("this student name is "+this.name+" today He is "+this.age+" yeas old ");
  }
    
  {
		 System.out.println("this student name is "+super.name+" today He is "+super.age+" yeas old ");
  
  }

}

/**
 * 实验第二类和子类之间在           一般函数       上的继承关系
 * @author ShineWong
 *
 */
class Zoo
{
	
	String name;
	int age;
	void run()
	{
		for(int x=0;x<5;x++)
		{
			for(int y=0;y<x;y++)
			 System.out.print("*");
			System.out.println();
		}
		
	}
	
	
}

 /**
  * 2:对于一般函数的字继承父时，如果子类的函数名跟父类放入函数名一模一样时，
  *   这个时候叫做函数放入覆盖，对父类函数功能定义放入函数进行功能放入重写
  * @author ShineWong
  *
  */
     //静态只能覆盖静态，权限小的不能覆盖权限大的。public的权限最大。
class Cat extends  Zoo
{
   void run()
	{
		for(int x=0;x<5;x++)
		{
		    for(int y=x;y<5;y++)
		    {
			System.out.print("*");    
		     }
		System.out.println();
	    }	
	}		
   
}


/**
 * 实验第三类和子类之间在       构造函数     上的继承关系																
 * @author ShineWong
 *
 */
class Home
{
	
	private String name; //私有化 成员变量
   private int age;     //私有化成员变量
  
	 Home()   //父类中的空构造函数,功能是打印“kong can shu ”  .它隐藏 式地传给子类
    {
	    	System.out.println(" kong can shu ");	 
    }
	    
	  Home(int age)   //父类中的非空构造函数.其功能是传入一个形参为整数的数值并打印出来
	     {
	         this.age=age;
	         System.out.println(" The old is  "+age);
	     }

     Home(String name,int age)  //父类中的非空构造函数。其功能是传入两个形参 类型分别是 String 型的和 int 型的，并打印 出来
     {
        	this.name=name;
        	this.age=age;
          System.out.println("He is "+name+"  And "+age);
     }
      
} 
     
/**
 * 该子类继承了父类
 * @author ShineWong
 *
 */
class Horse extends Home 
{
	
  /**
   * //在子类中创建构造函数
   */
	Horse()      
	 {
		 //本来这里有一个super();，指向的是父类中的空参数构造函数，这里被隐了起来，所以可以写，也可以不写
		   super("Huang ",20);//super()的用法跟this()的用法一样，必须放在第一行，如果放在第二行的话就会出现错误
		 
		  System.out.println("haven two");
		  
		  
	 }	//这是先找到父类中的空参数函数，再执行子类中的构造函数中的内容
	
	Horse(int age)   //在子类中创建构造函数
	{
		super("Gaung",20);
		//本来这里有一个super();，指向的是父类中的空参数构造函数，这里被隐了起来，所以可以写，也可以不写
		System.out.println(" And I am  "+age+" too ");
	}							//这是先找到父类中的空参数函数，再执行子类中的构造函数中的内容
	
	Horse(String name,int age)  //在子类中创建构造函数
	{
		 
		super("yi",25);
		//本来这里有一个super();，指向的是父类中的空参数构造函数，这里被隐了起来，所以可以写，也可以不写
		System.out.println(  " And My name is  "+name+" too "+" ,But  "+age);
		
	}			//这是先找到父类中的空参数函数，再执行子类中的构造函数中的内容
	

	/*总结，继承中构造函数的特点
	   父类中可以定义多个构造函数，
	    子类中也可以定义多个构造函数
	      在子类中创建实体对象时，调用子类中的构造函数时(通过判断对应的形式参数的个数来决定调用子类中的哪一个构造函数)，
	    会同时调用父类中的空参数的构造函数。除非有指定要调用父类中的某一个构造函数。(即手动地访问设置)
	  */
}




