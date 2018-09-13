package basic;

/**
 * static(静态) 关键字的用法和思想
     修饰 成员变量和成员方法
         static(静态)可以修饰      成员变量     和      成员函数        功能函数
      如果创建的对象没有特殊的属性或者成员变量为空时，则对象所调用的函数或者局部变量可用静态修饰。
     static 修饰的内容被对象所共享，因为是静态的，对象一调用被静态修饰的东西，则自动地将该静态物传入到该对象中；	
                创建一个对象p后   调用形式是          对象.静态变量    如 ：   p.brand /或者这样子调用:Pen.brand;
             用static修饰函数时，其调用的形式是，类名.函数名  ();   Pen.print(); /或者是    对象名p.函数名()   如：p.print();
             总结以上两点： 除了能被对象调用外，还可以被类调用，调用的形式是 : 类名.静态成员 变量胡静态成员函数 名 如 Pen.brand Pen.print();
 * @author ShineWong
 *
 */
public class Day24_static_Keywords
{
 public static void main(String [] agrs)   //主函数入口
 {
	   Pen p=new Pen();     //创建Pen 的实体对象
        p.size=14;        // 调用成员变量 size并赋值为 14；  size是非静态变量
        
        System.out.println(p.size);
             System.out.println(p.b);  //对象调用了静态变量 b
        		 System.out.println(Pen.ba);   //类名调用了静态变量 ba
        				 System.out.println(Pen.br);  //类名调用了静态变量 br
        p.write();       //调用一般成员方法
        Pen.print();      //用类名调用静态一般函数print();
        p.print();       //用对象调用静态一般函数 print();
        //所以运行完后的结果有  size=14和静态修饰下的brand 不用对象要求，已经配备好了数据。 
       // Pen.print(); //用static修饰函数时，其形式为， 类名。函数名  ()的调用; Pen.print(); 
  }
}

/**
 * 以下一共共享出了，一个变量 “zhangsan”和一个一般函数为print()。因为他们被静态修饰了，
 * @author ShineWong
 * 定义了一个，类名为Pen的类；
 */
class Pen   
{	
    static String brand="zhonghua ";  //静态修饰 变量 brand
    static String b="zho ";            //静态修饰 变量 b
    static String ba="ng ";           //静态修饰 变量 ba
    static String br="san";              //静态修饰 变量 br
    int size;                            //非静态变量
        
         public void write()          //非静态一般函数
    {
        	  System.out.println(Pen.brand+size+"打印一般非静态函数");	  
    } 

 /**
  * 静态修饰了 一个一般函数 print()
  */
    public static void print()   
      {   
	     System.out.println("zhonghua"+"打印静态一般函数");
       }
}
