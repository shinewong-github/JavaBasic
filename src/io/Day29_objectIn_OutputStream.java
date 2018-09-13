package io;
/*所谓的对象序列化就是把对象当作数据，序列化是把在内存中的对象写入到硬盘文件中，以便于保存，下次方便使用，*/
/*反序列化是把存在硬盘文件中的对象，读到在内存中以便于直接调用。*/
import java.io.*;
//简单实用，使用前要明确对象名
public class Day29_objectIn_OutputStream {
	public static void main(String[] args) throws Exception
	{
      // writeObj();
		readObj();
	}
	
	public static void readObj() throws Exception
	{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("F:\\obj.txt")) ;
		person p=(person)ois.readObject();//读存放对象的文件，把对象反序列化到内存中，这时候要传入一个对象名，但是但ID改变时，则不通过
		System.out.println(p);	
			ois.close();
		
		
	}
	public static void writeObj() throws Exception
	{
		 ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("F:\\obj.txt"));
		oos.writeObject(new person(39,"lisi"));//初始化一个类对象，这时只是存在内存中，而将这初始化的对象
		  		oos.close();									//序列化到文件中，跟文件中保存的ID号相对应的，
		
	}
}
