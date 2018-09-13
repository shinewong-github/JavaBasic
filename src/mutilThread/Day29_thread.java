package mutilThread;
/**
 * 测试run
 * @author ShineWong
 *
 */
public class Day29_thread {
 public static void main(String[] args) {
	for(int x=0;x<60;x++)
		System.out.println("Hello World!-----"+x);
	    Demo d1=new Demo("one");//实例化一个线程类
	    Demo d2=new Demo("two");
	    d1.start();//调用start 启动线程，虚拟机去执行该线程的RUN方法
	    d2.start();//调用start 启动线程，虚拟机去执行该线程的RUN方法
	
         Thread t=new Thread();t.start();//这是一个没有意义的线程创建。
 
 }
}
class Demo extends Thread
{
	Demo(String name){
		super();
	}
public void run(){
	for(int x=0;x<60;x++)
	
		System.out.println(currentThread().getName()+":demo run-----"+x);
	//	System.out.println(this.getName()+":demo run-----"+x);
 }	
}
