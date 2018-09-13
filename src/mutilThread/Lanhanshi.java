package mutilThread;

/**
 * 设计模式：单例模式之
 *懒汉式延迟加载，但是多线程访问时出现安全性问题，解决方法是：同步代码块或者
 *同步函数，这时候效率会比较低，此时可以通过双重判断来提高效率。
 *
 *面试面得多的是懒汉式
 * @author ShineWong
 *
 */
 class Lanhanshi {
 
	 private static Lanhanshi l = null;
	 private  Lanhanshi(){};
	 
 
    /*public static  synchronized lanhanshi getInstance1()
	 {
		 if(l==null)
			 //----->A;
	    	l=new lanhanshi();
	  return l;
	 }
  这是同步函数，每次都要判断锁，效率比较低下
}*/
	
	 
	 public static  Lanhanshi getInstance1(){
		 
	if(l==null)//判读条件，减少判断下面锁的次数
	{
		synchronized (Lanhanshi.class)
		{
			if(l==null)
			//	------>A;
		        l=new Lanhanshi();
			
		}
	}
		return l;	
 }	
		
}