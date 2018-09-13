package basic;

/**
 * static 静态代码块
 *   禁止在在堆内存中建立多个实体
 * @author ShineWong
 *
 */
public class Day24_static_CodeBlock_Keywords
{
	public static void main(String [] agrs)
	{
		Phone h=Phone.getInstance();
		h.setName(30,"vfd");
		System.out.println(h.getPrise()+h.getName());
//		Phone hj=new Phone();
//		hj.setName(30);
//		System.out.println(hj.getName());
//		Phone hk=new Phone();
//		hk.setName(34);
//		System.out.println(hk.getName());
		
	   // Phone h1=Phone.getInstance();
		//System.out.println(h1.getName());
		//h1.setName(2500, "liangxiang");
		//System.out.println(h1.getName()+h1.getPrise());
		//Phone h2=Phone.getInstance();
		//h2.setName(5000,"ipad ");
		//System.out.println(h2.getName());
		//System.out.println(h2.getPrise());
		
		
	}
}

/**
 * static 静态代码块
 * 禁止多个程序建立多个实体，只能在堆内存中new 一个实体，然后由多个程序共 同分享，
 * 利用到了私有化的构造函数，这个私有化的构造函数，起到了防止其他程序再创建实体。
 * 代码实现如下：
 */

class Phone
{
     private int prise;   //将成员变量静态化。
    private String name;   //将成员变量静态化。
	private  Phone ()        //将之设置为静态的，包括各功能函数，以便于非静态对象的访问。批量地赋予它们
	  {
		  
	  }
	
   private static Phone h=new Phone();      /*饿汉式 */
   public static Phone getInstance()         /*面试经常考查懒汉式：代码形式如下：*/
      {										    //private static Phone h=new Phone();
    	  return h;							   //     pbulic static Phone getInstance
      }										  //        if(s==null)
      										//          s=new Phone();
   											//        return s
                                           //要给懒汉式加把锁，或开发一个双重锁  
    
      public void setName(int prise,String name)
    {
       this.prise=prise;
       this.name=name;
       
    }
       public int getPrise()
       {
    	   
    	   return prise;
       }
       public String getName()
       {
         return name;    	   
    	   
       }

}