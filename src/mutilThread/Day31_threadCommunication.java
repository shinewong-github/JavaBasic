package mutilThread;

import java.lang.Thread;

/**
 * 线程之间通讯
 *
 *其实就是多个线程在操作同一个资源
 *但是操作的动作不同
 *安全机制问题
 * @author ShineWong
 *
 */
public class Day31_threadCommunication {
public static void main(String[] args) {
	
	Res r=new Res();
	input in=new input(r);
	output out=new output(r);
	Thread t1=new Thread(in);
	Thread t2=new Thread(out);
	t1.start();
	t2.start();
}
}

  /**
   * wait(),notify(),notifyall():
   *都使用在同步中，因要对持监视器的线程操作，所以要使用在同步中，因为只有同步才具有锁。
   *为什这些操作线程的方法要定义在Object类中呢？
   *因为这些方法在操作同步线程时，都必须要标识它们所操作线程只有的锁，只有同一个锁上的被等待线程，可以被同一个锁上的notify唤醒，不可以对不同锁中的线程进行唤醒，也就是说，等待和唤醒必须是同一个锁，而锁可以是任意对象，所以被任意调用的方法定义Object类中，。

   * @author ShineWong
   *
   */
class Res
	{
	     String name;
	     String sex;
	     boolean flag=false;//初始值为假
	}
	
class input   implements Runnable
{
	   private Res r;
	  // Object obj=new Object();//与线程output不是同一锁
input(Res r)
	{ 
	   this.r=r;
	}
 public void run()//如果在这里加关键字，成为同步函数，就成了单线程
	{
	int x=0;	
	while(true)
	{
		 synchronized (r) //用资源锁
		 {
	           //为了控制与（另外一个线程）打印语句一进一出的交替，即线程之间的通信。
		 if(r.flag)//只有if（）内的值为真时，才会执行下面的语句
		  try{r.wait();}//刚开始不用等,当执行到wait()时，就等着了，放弃了执行资格。线程运行时，内存会建立以线程池，等到线程被放到线程池中
		 catch(Exception e){}
//		 try{}
//		 catch(){}
		 
			 if(x==0)
		 {
		
			r.name="mike";
			r.sex="man";	
			//System.out.println(Thread.currentThread().getName()+".............");
		}
	 else
	 {
		 r.name="丽丽";
		 r.sex="女";	 
		//System.out.println(Thread.currentThread().getName()+"*****");
	 }
	 x=(x+1)%2;
	 r.flag=true;
	 r.notify();//被唤醒时，才可能抢到执行权。这句执行的唤醒output线程
	 }
	}
   }
}
class output  implements Runnable
{
	//Object obj=new Object();与线程input不是同一锁
	   private Res r;
	 output(Res r)
	   { 
	    this.r=r;
	   }
	public void run()
	{
		while(true)
		{
			synchronized (r)
			{	
			if(!r.flag)
				try{ r.wait();}catch(Exception e){}
					System.out.println(Thread.currentThread().getName()+r.name+"  "+r.sex);
				r.flag=false;
				r.notify();//在内存在唤醒wait()的线程。此时唤醒的是input
	        }
	    }
	}
	
}


/*
 *******************************************************
 对上面的代码进行优化：给资源成员私有化:
 class Res
	{
	       private String name;
	      private  String sex;
	     private boolean flag=false;//初始值为假
	 public void set(String name,String sex)
	     {
	    	 this.name=name;
	    	 ------->可能会卡在这里//所以要同步代码块
	    	 this.sex=sex;
	    	 
	     }
	 public void out(){
		 System.out.println(name+"......."+sex); 
	 }
	}
	
class input   implements Runnable
{
	   private Res r;
	  // Object obj=new Object();//与线程output不是同一锁
input(Res r)
	{ 
	   this.r=r;
	}
 public void run()//如果在这里加关键字，成为同步函数，就成了单线程
	{
	int x=0;	
	while(true)
	{
		 synchronized (r) //用资源锁
		 {
	           //为了控制与（另外一个线程）打印语句一进一出的交替，即线程之间的通信。
		 if(r.flag)//只有if（）内的值为真时，才会执行下面的语句
		  try{r.wait();}//刚开始不用等,当执行到wait()时，就等着了，放弃了执行资格。线程运行时，内存会建立以线程池，等到线程被放到线程池中
		 catch(Exception e){}
//		 try{}
//		 catch(){}
		 
			 if(x==0)
		 {
		
			r.set("mike","man")	
			//System.out.println(Thread.currentThread().getName()+".............");
		}
	 else
	 {
		r.set("丽丽","女女")	
		//System.out.println(Thread.currentThread().getName()+"*****");
	 }
	 x=(x+1)%2;
	 r.flag=true;
	 r.notify();//被唤醒时，才可能抢到执行权。这句执行的唤醒output线程
	 }
	}
   }
}
class output  implements Runnable
{
	//Object obj=new Object();与线程input不是同一锁
	   private Res r;
	 output(Res r)
	   { 
	    this.r=r;
	   }
	public void run()
	{
		while(true)
		{
			synchronized (r)
			{	
			if(!r.flag)
				try{ r.wait();}catch(Exception e){}
					r.out();
				r.flag=false;
				r.notify();//在内存在唤醒wait()的线程。此时唤醒的是input
	        }
	    }
	}
	
}
***************************************************************
//******************进一步优化以上代码**********
 class Res
	{
	       private String name;
	      private  String sex;
	     private boolean flag=false;
	     
	 public  synchronized void set(String name,String sex)
	     {
	      if(r.flag)
		  try{r.wait();}catch(Exception e){}
		     this.name=name;
	    	 this.sex=sex;
	    	 flag=true;
	    	 this.notify();
	     }
	     
	 public  synchronized void out(){
	     if(!r.flag)
	     try{ r.wait();}catch(Exception e){}
		 System.out.println(name+"......."+sex); 
		 r.flag=false;
		 r.notify();
	 }
	}
	
class input   implements Runnable
{
	   private Res r;
	 
input(Res r)
	{ 
	   this.r=r;
	}
 public void run()//如果在这里加关键字，成为同步函数，就成了单线程
	{
	int x=0;	
	while(true)
	{
	 if(x==0)
		r.set("mike","man")		
	 else
		r.set("丽丽","女女")	
	 x=(x+1)%2;
	}
   }
}
class output  implements Runnable
{
	   private Res r;
	 output(Res r)
	   { 
	    this.r=r;
	   }
	public void run()
	{
		while(true)
		  {
			r.out();
	      }
	    }
	}
	
}

public class Day0831Threadcommunication {
public static void main(String[] args) {
	
	Res r=new Res();
    Thread t1=new Thread(new input(r).start);
	Thread t2=new Thread(new output(r).start);

}
}
***********************************************************
 

 */