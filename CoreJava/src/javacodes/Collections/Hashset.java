package javacodes.Collections;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("Stefan");
		hashSet.add("Katerina");
		hashSet.add("Damon");
		hashSet.add("Elena");
		hashSet.add("Elijah");
		
		System.out.println(hashSet);                          //Does not guarantee sequential order
		hashSet.add("Elena");									//Does not accept duplicate values
		
		hashSet.remove("Elijah");
		
		Iterator<String> it = hashSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(hashSet.isEmpty());
		System.out.println(hashSet.size());
		System.out.println(hashSet.contains("Stefan"));
		
	}

}
