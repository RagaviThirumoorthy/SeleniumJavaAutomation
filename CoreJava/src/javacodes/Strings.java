package javacodes;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String is the Object that represents the sequence of characters
		//String Definition
		//1 - String Literal
		String s1 = "Ragavi";
		String s2 = "Engineer"; //If both string values are same then it will refers to old s2(only one object will get created.)
		String s3 = "Engineer";  
		
		//2 - using 'new' memory allocate operator
		String s4 = new String("Karur");
		String s5 = new String("Karur"); //every time it creates object explicitly in memory space
		
		//Split
		String s = "Ragavi is Kind Hearted";
		String[] splitted = s.split(" ");
		System.out.println(splitted[0]);
		System.out.println(splitted[1]);
		System.out.println(splitted[2]);
		System.out.println(splitted[3]);
		
		String[] splitted1 = s.split("Kind");
		System.out.println(splitted1[0]);
		System.out.println(splitted1[1]);
		System.out.println(splitted1[1].trim());
		
		//print the chars in the String
		for(int i=0;i<s.length();i++) {
			System.out.println(s.charAt(i));
		}
		
		//In reverse order
		for(int i=s.length()-1;i>=0;i--) {
			System.out.println(s.charAt(i));
		}
		
	}

}
