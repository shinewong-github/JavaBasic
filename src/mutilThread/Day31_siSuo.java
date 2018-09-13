package mutilThread;
//import java.Thread;

/**
 * 
 * @author ShineWong
 *
 */
public class Day31_siSuo{
	public static void main(String[] args) {
		Thread t1=new Thread( new Test(true));
		Thread t2=new Thread(new Test(true));
		t1.start();
		t2.start();
		
	}
	
	
	
}
class Test implements Runnable{
	
	private boolean flag;
	Test(boolean flag)
	{
		this.flag=flag;
	}
	public void run()
	{
		if(flag)
		{  
		synchronized (Mylock.locka) 
			{
				System.out.println(" if locka");
				synchronized (Mylock.lockb)
				{
					System.out.println(" if lockb");
					
				}
			}
			
			
		}
		else
		{
			synchronized (Mylock.lockb) 
			{
				System.out.println(" else lockb");
				synchronized (Mylock.lockb)
				{
					System.out.println(" else locka");
					
				}
			}
		}	
				
		}	
	}
class Mylock{//多态
	static  Object locka=new Object();
	static  Object lockb=new Object();
}