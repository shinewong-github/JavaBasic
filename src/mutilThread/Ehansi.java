package mutilThread;

/**
 * 单例模式之饿汉式
 * 初始化为定值的类
 * @author ShineWong
 *
 */
class Ehanshi{
	   private static final Ehanshi s=new Ehanshi();
		 private Ehanshi(){}
		public static Ehanshi getInstance()
		{
			return s;
		}
	}