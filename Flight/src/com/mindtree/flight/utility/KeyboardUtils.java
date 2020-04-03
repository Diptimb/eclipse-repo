package com.mindtree.flight.utility;
import java.util.Scanner;
public class KeyboardUtils {
private static Scanner in=new Scanner(System.in);
public static int readInteger()
{
	String s=in.nextLine();
	try{
		int i=Integer.parseInt(s);
		return i;}
	catch(Exception e) {
		System.out.println("Invalid input");
		return -999;
	}
}
public static String readString() {
	String s=in.nextLine();
	if(s==null ||s=="") {
		System.out.println("Invalid Input");
		return "";
	}
	else {
		return s;
	}
	}
public static double readDouble() {
	String d=in.nextLine();
	try {
		double n=Double.parseDouble(d);
		return n;
	}
	catch(Exception e) {
		System.out.println("Invalid input");
		return -999;
	}
}
}
