package gui;

import java.awt.*;
/**
 * 验证和测试类Frame、Panel、Graphics：
 * 
 * @author ShineWong
 *使用main方法测试
 */
public class AWTdrawing {
    private Frame f = new Frame(" Frame be create!");
    private Panel p = new Panel();
	public void launchFrame() {
	    f.add(p);
	    f.setSize( 170,170);
	    f.setBackground( Color.blue);
	    f.setVisible( true); 
	    p.setForeground(Color.red);
	    Graphics g = p.getGraphics();
	    g.drawArc(30,40,50,60,70,80);
	    g.fillArc(30,40,50,60,70,80);
	}
	public static void main( String args[]) {
	    AWTdrawing guiWindow = new AWTdrawing();
	    guiWindow.launchFrame();
    }

}