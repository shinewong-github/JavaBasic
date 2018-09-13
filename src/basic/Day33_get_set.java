package basic;

/**
 * get()和set()方法原理
 * 对于私有化的成员变量，必须要利用get和set的方法来对其进行访问。
 * 先set，进行对私有化的原值的设置改变,再调用get方法,来获取改变后的值。
 * @author ShineWong
 *
 */
 class L {

	private int a=4;
	public int geta(){
		return a;
		
	}
	public void seta(int a){
		this.a=a;
		
	}
}
public class Day33_get_set
{
	
public static void main(String[] args) {
	
	int b;
	L l=new L();
	b=l.geta();//获得了a的值，Get到了
	System.out.println("a的值是 "+b);
	System.out.println("对a的值进行改变，调用seta()方法  ");
	l.seta(3);
	System.out.println("调用Seta方法后，可以对a的值进行访问并改变，改变后a的值为：  "+l.geta());
}

}
