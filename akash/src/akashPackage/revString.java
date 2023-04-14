package akashPackage;

public class revString {

	public static void main(String[] args) {

		String str= "i am good looking";
		String str2[]= {};
		
		str2=str.split(" ");
		String str3 ="";
		for (int i = str2.length-1; i >=0 ; i--) {
			
			str3=str3+" "+str2[i];
		//	System.out.print(str2[i]+",");
			
		}
		System.out.println(str3.trim());
		
	}
		/**String str= "i am good looking";
		
		for (int i = str.length(); i >=0 ; i--) {
			
			//str3=str3+" "+str2[i];
			System.out.print(str[i]);
			
		}**/
}
