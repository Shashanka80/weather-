package akashPackage;

import java.util.Scanner;

public class LargestNumber {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the size");
		
		int size=sc.nextInt();
		int ar[]=new int[size];
		for (int i = 0; i < size; i++) {
			
			ar[i]= sc.nextInt();
			
		}
		int larg=ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i]>larg) {
				larg= ar[i];
			}
		}
		System.out.println("larg number is "+larg);

		}
	}
		
	/**	int ar[]= {5,8,4,6,1,10,0};
		int larg= ar[0];
		
		for (int i = 0; i < ar.length; i++) {
			if (ar[i]>larg) {
				larg= ar[i];
			}
		}
		System.out.println("larg number is "+larg);

	}}**/
