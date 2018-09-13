package basic;

/**
 * 类类函数，   成员变量和成员方法的， setName函数和getName函数    
 * 一般函数和构造函数            
 *  以及This 关键字的简单运用
 * @author ShineWong
 *类由成员变量和成员行为构成，而成员变量中的变量作用于整一个类
 *被存在了堆内存中，而相比之下，定义在函数制中的局部变量在栈内存中的存起来，是临时存卡起来的
 */
class Car
{
	// 以下画出了汽车这类事物的抽象，其性质的共同描述。
	private String brand = "benchi";// 汽车的品牌，被私有化
	
	 int mull = 8; // 汽车的轮胎，轮胎数为8的图纸，使生产出来的轮胎数都是为8的汽车 被私有化
	 
	private int prise = 10000000; // 汽车的价格 被私有化
	
	String color = "yellow"; // 汽车的颜色 被私有化

/**
 * 这是定义成员方法，也是建造一个可以打印的函数。
 *    类类型变量（指的是一个对象的引用如：Car c）来调用此函数时，要用 变量名.方法名的
 *      （如：c.runl）形式来实现调用。
 * 该函数的功能是打印各成员属性的初始值     
 */
	void run() { 
		System.out.println(
				"这是一张" + brand + "牌子，" + " 其价格是" + prise +
				" 元 ，" + " 颜色是" + color + " ，有 " + mull + 
				" 轮胎数的汽车生产图纸");
	}
/**
 * 该函数的功能是打印brand和arise成员属性的初始值
 */
	public void run_1() {
		System.out.println("实例化出的这辆车：" + "这是一俩" +
	              brand + "牌子，" + " 其价格是" + prise + " 元 ，" + 
				 " 颜色是" + color + " ，有 "
				+ mull + " 轮胎数的汽车");
	}
	
/**
 * 该函数的功能是改变color成员属性的初始值，并通过形式参数的传递赋予新的值
 * @param color
 */
	public void show(String color) {
		this.color = color;// this指出是对象的东西
		System.out.println(color);

	}

/**
 * 通过get和set函数来为私有化得成员提供一个访问的接口，这里的访问不仅仅指读，还可以指写（修改）
 */
	public void setName(String brand, int prise) {
		this.brand = brand;
		this.prise = prise;

	}

	public String getName() {
		return brand;
	}

	public int getName_1() {

		return prise;
	}

/**
 * 构造函数
 * 注意this关键字的运用。用于区分局部变量和成员变量的同名。
 * this.name表示的是成员变量，而定义在构造函数中的局变量赋给成员变量.
 */
	Car()// 函数参数为空
	{
		// System.out.println("走你");

	}

/**
 *  函数参数为 String 类型的
 * @param brand
 */
	Car(String brand)
	{
		this.brand = brand;
		// System.out.println("the brand is "+brand);
	}

	Car(String brand, int prise)// 函数参数为 String 和 int 类型的。并使用关键字
	{
		this.brand = brand;
		this.prise = prise;

		// System.out.println("And another is "+brand+" that cost me "+prise );

	}

	// 调用一般函数，一般函数相比较于构造函数是，构造函数是对象一建立就有某些属性。

}

/**
 * 1：定义类 就是描述事物的共性，生产，类似事物的共性---图纸的产生。 2：开始在类里面定义共同对象的属性，为了保密起见，私有化，加上private；
 * 3：怎么样调用private里面的东西呢？: setName函数和getName函数
 *
 * 5：构造函数的出现形式是：函数 名与类名一样，不用写返回值类型，也不用写return语句
 * 用于给对象的初始化，定义某些对象的特性.来了一个关键字，使之更有阅读性，
 *    含义是，哪个对象调用this里面的函数，this就指向谁的对象。
 * Person(形式类型和形式参数) { System.out.println()
 * @author ShineWong
 *
 */
class Day18_class2 {
	public static void main(String[] agrs) {

		Car c = new Car();
		c.run(); // 访问run方法
		c.mull = 4;	// 修改成员变量的值	、
		
		
		c.color = "blue";// 改变成员变量的值
		// c.brand="baoma";无法访问brand 因为被private修饰
		// c.price="10000";无法访问price因为被private修饰
		c.run_1();
		c.show("red");
		c.setName("本田汽车", 200000);// 通过get 和set方法修改被private修饰的price 和 brand的指
		c.run_1();

		/* 一般放法与构造方法使用的区别 */
		// 以下是构造函数的简单使用
		System.out.println("下面是创建三个指向不同实体内存的对象引用");
		Car c1 = new Car();
		c1.run();
		Car c2 = new Car("laosilaisi");
		c2.run();
		Car c3 = new Car("falali", 500000000);
		c3.run();

		// 一般函数的运用，调用setName 和 getName函数
		c3.setName("xuebao", 800000000);
		// System.out.println("It is " + c3.getName() + '\t' + "that costs me "
		// + c3.getName_1());

	}

}
