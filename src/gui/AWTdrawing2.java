package gui;
import java.awt.*;

/**
 * 范例名称：AWT 绘图举例
 * 	源文件名称：AWTDrawing2.java
 *	要  点：
 *		1. AWT组件绘图原理
 *		2. Graphics类及常用绘图方法
 *
 * @author ShineWong
 *
 */
public class AWTdrawing2 {
    private Frame f = new Frame(" Hello Out There!");
    private Panel p = new SubPanel();
	public void launchFrame() {
	    f.add(p);
	    f.setSize(170,170);
	    f.setBackground( new Color(89,145,145));
	  //  Graphics g = p.getGraphics();
	  //  g.drawArc(30,40,50,60,70,80);
	    //g.fillArc(30,40,50,60,70,80);
	     //p.paint(g);
	     
	}
	public static void main( String args[]) {
	    AWTdrawing2 guiWindow = new AWTdrawing2();
	    guiWindow.launchFrame();
    }
}

class SubPanel extends Panel{
	public void paint(Graphics g){
		g.drawString("付清价格",20,20);		
		g.drawLine(30,60,100,120);
		g.draw3DRect(60,50,70,30,false);
	}	
}