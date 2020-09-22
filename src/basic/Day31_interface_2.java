package basic;

/**
 * 接口与多态的综合使用
 * 接口和类之间的相互关系 以及主函数的对其中的调用
 * @author ShineWong
 *
 */
interface PCI
{
	void open();//接口中定义了抽象的方法
	
	void close();//接口中定义了抽象的方法
	
	
}

class MainBoard 
{
	public void run()
	{
      System.out.println("MainBoard run");	
	}
	public void usePCI(PCI p)
	{ 
		if(p!=null)
		{
			p.open();
		    p.close();
		 }
	}

}

class NetCard implements PCI
{
	public void open()
	{
		System.out.println("netcard open");
		
	}
	public  void close()
	{
		System.out.println("net close");
		
	}
	

}
class SoundCard implements PCI
{
	public void open()
	{
		System.out.println("soundcard open");
		
	}
	public  void close()
	{
		System.out.println("soundcard close");
		
	}


}

public class Day31_interface_2
{
public static void main(String [] args)
  {
	MainBoard zb= new MainBoard();
	zb.run();
    zb.usePCI(new NetCard());
     zb.usePCI(new SoundCard()); 
  
  }
	
}
