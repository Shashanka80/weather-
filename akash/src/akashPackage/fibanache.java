package akashPackage;

import java.util.Scanner;

public class fibanache {
	public static void main(String[] args) {
	/**	Scanner sc = new Scanner(System.in);
		System.out.println("enter size of fibanoche");
		int num= sc.nextInt();
		int a=0,a1=1,sum=0;
		for (int i = 0; i <= num; i++) {
			
			sum=a+a1;
			a=a1;
			a1=sum;
			System.out.println(sum);

		}
	}**/
		int n=15;
		int a=2,a1=4,sum=0;	

		for (int i = 0; i <n; i++) {
			
			sum=a+a1;
			a=a1;
			a1=sum;
			System.err.print("\t"+sum);
			
		}
			
		}
}
