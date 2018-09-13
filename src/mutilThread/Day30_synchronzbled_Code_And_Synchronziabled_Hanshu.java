package mutilThread;

/**
 * 同步函数和同步代码块
 * 不出现0的情况和出现0情况
 * @author ShineWong
 *
 */
public class Day30_synchronzbled_Code_And_Synchronziabled_Hanshu {

	public static void main(String[] args) {
		Ticket1 t=new Ticket1();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}//让主线程休息10秒，好让第一个线程执行。
		 boolean flag=false;
		t2.start();
		
		System.out.print("I an main");
	}

}




class Ticket1 implements Runnable //extends Thread
{	

	private /*static*/ int tick=40;//这个是共享数据
	Object obj=new Object();//同步代码块的对象参数
	boolean flag=true;
	public void run()//run方法里面放的是Ticket要跑的代码,定义在外面的是共享数据
	{
	if(flag)
	{
		while(true)
		synchronized(this)//这是同步代码块,对象是Ticket
		//synchronized(obj)//这是同步代码块,对象是Object

		{
			if(tick>0)
			{
			//此时到这里有一种可能四个线程判断后都会停下来，如果这时Tick=1,执行下面语句时会出现负数的情况
			try 
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e) 
			{
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"...code..:"+tick--);
			}	
		}
	}	
	else
		while(true)
			this.show();//show();
	}
	public  synchronized  void show()
	{
		if(tick>0)
		{
			//此时到这里有一种可能四个线程判断后都会停下来，如果这时Tick=1,执行下面语句时会出现负数的情况
			try 
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e) 
			{
				
				e.printStackTrace();
			}
			
			
			System.out.println(Thread.currentThread().getName()+"...show....:"+tick--);
			
		}
		
	}
}
