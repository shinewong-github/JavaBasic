package basic;

/**
 *多态的使用
 *多态的前提
 *多态的好处
 *多态的应用
 *多态的使用：代码的体现形式为：
 */
/*
class Anmial

 {
 
 }
 
 class Cat extends to Anmial
 {
     // 成员方法
     //还有一个特例的方法
 }
 
 主函数
 {
   Anmial c=new Cat();
    c.成员方法
    c.特例的方法调用时不成立的
           这个时候要向下转换 即为：
      =(Cat) c
 }
 */
public class Polymorphic 
{
	public void main(String[] args) {
	Salary s=new Salary("员工A","北京",3,2500.00);
	Employee e=new Salary("员工 B","上海",4,5000.00);
	System.out.println("使用Salary的引用调用 mailCheck");
		s.mailCheck();
	System.out.println("使用Employee的引用调用 mailCheck");
     e.mailCheck();
	}

	
	
/*实例化中，实例化了两个Salary对象：一个使用Salary引用s,另一个使用Employee引用e
 * 当调用s.mailCheck()时，编译器在编译时发现mailCheck()在Salary类中，执行过程JVM就调用Salary类的mailCheck()
 *在调用s.mailCheck()时，java虚拟机（JVM）调用Salary类的mailCheck()方法
 *
 *因为 e 是 Employee 的引用，所以调用 e 的 mailCheck() 方法时，编译器会去 Employee 类查找 mailCheck() 方法 。
在编译的时候，编译器使用 Employee 类中的 mailCheck() 方法验证该语句， 但是在运行的时候，Java虚拟机(JVM)调用的是 Salary 类中的mailCheck()方法。
 *
 *
 **/
	
	
	
	
}


/*员工类，属性：年龄，地址，电话号码。
 * 初始化函数，赋值上面三个属性
 * 行为，阅读邮箱。
 * 可以对私有化的属性，进行赋值和获取属性
 * 
 * 
 */
 class Employee {
	private String name;
	private String address;
	private int number;
	public Employee(String name,String address,int number){
	System.out.println("Employee 构造函数");
	this.name=name;
	this.address=address;
	this.number=number;
	}
	public void mailCheck(){
		System.out.println("邮寄支票给： "+this.name+""+this.address);
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public int  getNumber(){
		return number;
	}
	public void setAddress(String newaddress){
		this.address=newaddress;
		
	}
 }
 
 //工资类 
 class Salary extends Employee{//一旦继承了Employee，则将拥有Employee的非私有有的属性和方法
	 private double salary;
	 public Salary(String name,String address,int number,double salary){
		 super(name,address,number);
		 setSalary(salary);
	 }
	 public void mailCheck(){
		 System.out.println("Salary类的mailCheck方法 ");
		 System.out.println("邮寄支票给："+getName()+",工资为："+salary);
		 
	 }
	 public double getSalary(){
		 return salary; 
	 }
	 public void setSalary(double newSalary){
		 if( newSalary>=0.0)
	 {
		 salary=newSalary; 
	 }
 }
 
 public double computerPay(){
	 System.out.println("计算机工资，付给： "+getName());
	 return salary/52;
	 
 }
 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

