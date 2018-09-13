package mutilThread;
/**
 * 
 * 测试多线程：
 * 售票例子
 * 例子1：四个线程，每个买10张票
 * 例子2：四个线程：共享40个票资源，
 * 这时候要调用票这个变量要用关键字来修饰 static,但是调用这个是有一定的漏洞的，所以这个案例
 * 要使用Runnable接口的方法
 * 使用Runnable的原理激活线程的原理是基于 Thread(Runnable r)这个构造参数
 * 
 * 使用main方法测试
 */

public class Day29_threadForSelltickets {
	public static void main(String[] args) {
		Ticket t=new Ticket();//创建线程对象
		Thread t1=new Thread(t);//
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		Thread t4=new Thread(t);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("I an main");//主线程先运行 
	}

}




class Ticket implements Runnable //extends Thread
{	

	private /*static*/ int tick=40;
	public void run()//run方法里面放的是Ticket要跑的代码
	{
	while(true)
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
			
			
			System.out.println(Thread.currentThread().getName()+"...sale:"+tick--);
			
		}
	}	
}
}