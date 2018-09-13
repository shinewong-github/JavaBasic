package gui;
/*
 * 关闭窗体时，会自动产生一个新窗体
        在新窗体中会有一个名为“关闭”的按钮，点击这个按钮，会从键盘录入的一段话方法硬盘的文件路径中
       没有正确的关闭方法*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
 * 窗体和按钮都有自己的事件监听器
 * 
 * 
 * 
 **/

public class FrameDemo
{

     
	private Frame frame;//=new Frame();
	private Button button;
	private Button button2;
	FrameDemo()
	{
		init();
		
		//MyEevent();如果该方法在这里被对象一被建立就初始化，就被加载进来，但是，该方法体内并没有定义new frame变量
	}
	private void init()//初始化一个带有指定边框、布局、具有按钮的可视化窗体
	                  //增加的组件有按钮。
	{
		frame=new Frame("我是一个窗体");
		button =new Button("按钮");
		frame.setBounds(100,200,300,400);
		frame.setLayout(new FlowLayout());
		MyEevent();
		frame.setVisible(true);
		frame.add(button);
	
		//加载窗体上的事件
		
	}
	private void MyEevent()//窗体和按钮都有自己的事件监听器
	{
		
		//这只是一个方法调用，传的参是一个带的方法匿名对象类型参数
		frame.addWindowListener(new WindowAdapter() //一个监听器可以监听很多个动作，不必再使用窗体调用
		{
			@Override
			public void windowClosing(WindowEvent e)//窗口正在处于关闭过程中调用 
			{
				System.out.println("一旦程序运行没有关闭窗口的方法，只有强制结束运行才能把窗口关闭");
				NewOne();
				//调用产生新窗口的方法，该方法定义了生产出init方法  
				//System.exit(0);
				//super.windowClosed(e);
			}
			
		});
	
			
		}
	public void FalseBotton()
	{
		button2.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(e.getClickCount()==1)
					System.out.println("有个人点进来了，在键盘巧代码开始发送病毒");
				ReadInfoFromKeyOnButtonClikOne();
					
			}
			
		});

		
	}
		
		public void NewOne()
		{
		  
			frame=new Frame("我是一个窗体");
	
	        button2=new Button("关闭该页面");
			frame.setBounds(200,200,400,400);
			frame.setLayout(new FlowLayout());
			frame.setVisible(true);
			
			frame.add(button2);
			//按钮2事件
			FalseBotton();
		
		}
		
		public void ReadInfoFromKeyOnButtonClikOne()
		{
			 BufferedReader bufr=null;
			 PrintWriter out=null;
		     String line=null;
			try {
				 bufr=new BufferedReader(new InputStreamReader(System.in));
				  out=new PrintWriter(new BufferedWriter(new FileWriter("C:\\读完解决问题.bat")),true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("病毒存盘路径找不到");
			}
			
			 try {
				while((line=bufr.readLine())!=null)
				 {
					
					 if("over".equals(line))
						 break;
					 out.println(line);
						
					 
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally
			 { 
				 try
				 {
					 if(bufr!=null)
						 bufr.close();
						
					
				} 
				 catch (Exception e)
				 {
					System.out.print("创建缓冲流键盘录入对象失败");
				}
				 
			 }
			
		}
	
	public static void main(String[] args)
	{
		//主函数用来测试
	new FrameDemo();
		
		

	}

}

/*垃圾滞留场地*/
//button2.addMouseListener(new MouseAdapter()
//{
//	@Override
//	public void mouseEntered(MouseEvent e) 
//   {   
//	
//		System.out.println("你 被我骗了");
//	}
//	
//});
/*垃圾滞留场地*/
//public void windowClosed(WindowEvent e)
//{
//	System.out.println("单窗口被关闭时，我出现了");
//	//System.exit(0);
//	
//}//窗口已经被关闭时调用
//});
///*垃圾滞留场地*/
//button.addActionListener(new ActionListener() //只要这个子类没有适配器，因为其方法只有一个可以复写
//{
//	
//	@Override
//	public void actionPerformed(ActionEvent e) 
//	{
//		System.out.println("按钮干的");
//		 // System.exit(0);
//		
//	}
//	
//});

//