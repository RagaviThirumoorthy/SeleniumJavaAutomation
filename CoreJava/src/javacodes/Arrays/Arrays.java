package javacodes.Arrays;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int array
		
		int a = 5;
		
		int[] arr1 = new int[5];
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4;
		arr1[4] = 5;
		
		int[] arr2 = {10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100};
		
		//String array
		
		String[] name = {"Ragavi","Kaviya","Monica","Rachel","Pheebe"};
		
		//For loop
		
		for(int i =0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		
		//Enhanced for loop
		
		for(String s : name) {
			System.out.println(s);
		}
		
		//Loop with conditional statements
		
		System.out.println("Below are multiple of 2");
		for(int i : arr2) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		
		System.out.println("Below are odd numbers");
		for(int i : arr2) {
			if(i%2!=0) {
				System.out.println(i);
			}
		}
		
	}

}
