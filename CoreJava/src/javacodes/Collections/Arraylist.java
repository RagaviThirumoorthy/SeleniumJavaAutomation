package javacodes.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("Ross");
		arrList.add("Chandler");
		arrList.add("Joey");
		arrList.add("Gunther");
		
		arrList.add("Ross");							//Accepts Duplicate values
		System.out.println(arrList);					//Guarantee sequential order
		
		for(int i=0;i<arrList.size();i++) {
			System.out.println(arrList.get(i));
		}
		
		System.out.println("******************");
		arrList.remove(3);
		
		for(String arr : arrList) {
			System.out.println(arr);
		}
		
		System.out.println(arrList.contains("Joey"));
		System.out.println(arrList.contains("Gunther"));
		
		//Converting Array to ArrayList
		String[] name = {"Pheobe","Monica","Rachel"};
		List<String> nameList = Arrays.asList(name);
		System.out.println(nameList.contains("Monica"));
		System.out.println(nameList.isEmpty());
		System.out.println(nameList.get(0));
		System.out.println(nameList.indexOf("Rachel"));
		System.out.println(nameList.size());
	}

}
