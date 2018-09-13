package io;

import java.io.*;
import java.util.Properties;

public class Day08_getSystemInfo {
	public static void main(String[] args) {
		Properties pro = System.getProperties();
		//System.out.println(pro);
		try {
			pro.list(new PrintStream("kk.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
