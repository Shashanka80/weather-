package akashPackage;

import java.util.Scanner;

public class Palindrom {
public static void main(String[] args)
{
	Scanner sc = new Scanner (System.in);
	System.out.println("enter the string values");
	String str = sc.nextLine();
	//String s1="java";
	String s2="";
	for(int i=str.length()-1; i>=0; i--)
	{
		s2=s2+str.charAt(i);
		if(str.equals(s2))
		    System.out.println("its an palindroume");
		else
			System.out.println("not pali");
	
	}
}}