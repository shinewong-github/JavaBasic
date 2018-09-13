package io;
/*这个类是一个测试类，给Objectin_outputStream做测试用的*/
//把这个类写序列化，再反序列化。
//说明，静态不能
import java.io.*;

 class person implements Serializable{
	//	public static final long serialVersionUID = 424L;

		char b='f';
		int age=23;
		String name="Huang guang yi!";
		//private String cn="chinese";
		person(int age,String name){
	       this.age=age;
	       this.name=name;
	     
		}
	public String ToString(){
	//String cn = null;
	return name+"："+age;
		
	}

}