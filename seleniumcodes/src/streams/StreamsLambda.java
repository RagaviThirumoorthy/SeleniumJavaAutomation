package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsLambda {

	//@Test			//Usual method						
	public void streamsTest1() {
		// TODO Auto-generated method stub
		
		ArrayList<String> names = new ArrayList<>();
		names.add("Monica");
		names.add("Rachel");
		names.add("Phoebe");
		names.add("Ragavi");
		names.add("Ross");
		
		for(int i=0;i<names.size();i++) {
			if(names.get(i).startsWith("R")) {
				System.out.println(names.get(i));
			}
		}

	}
	
	//Using streams with filter
	//@Test
	public void streamsTest2() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Monica");
		names.add("Rachel");
		names.add("Phoebe");
		names.add("Ragavi");
		names.add("Ross");
		
		long c = names.stream().filter(s->s.startsWith("R")).count();
		System.out.println(c);
	}
	
	//There is no life for inter operation if there is no terminal operation
	//The terminal op will not execute if the inter op returns false
	
	//@Test
	public void streamsTest3() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Monica");
		names.add("Rachel");
		names.add("Phoebe");
		names.add("Ragavi");
		names.add("Ross");
		
		long d = names.stream().filter(s->
				{s.startsWith("R");
				return false;
				}).count();
		System.out.println(d);
	}
	
	//No need of collections, we can create streams directly
	//@Test
	public void StreamsTest4() {
		Stream.of("Monica","Rachel","Phoebe","Ragavi","Ross").filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));;
	}
	
	//@Test
	public void StreamsTest5() {
		//Printing names with last letter 'a' in Upper case
		Stream.of("Ben","Emma","Tara","Adam","Eva","Anna").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Printing sorted names with first letter 'A' in upper case
		Stream.of("Ben","Emma","Tara","Adam","Eva","Anna").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	
	//@Test
	public void StreamsTest6() {
		//Merge two lists
		ArrayList<String> girls = new ArrayList<>();
		girls.add("Monica");
		girls.add("Rachel");
		girls.add("Phoebe");
		
		ArrayList<String> boys = new ArrayList<>();
		boys.add("Chandler");
		boys.add("Joey");
		boys.add("Ross");
		
		Stream<String> merged = Stream.concat(girls.stream(), boys.stream());
		//merged.sorted().forEach(s->System.out.println(s));  -->stream has already been operated upon or closed exception coming
		
		//Checking whether 'Joey' is present in merged stream
		boolean flag = merged.anyMatch(s->s.equalsIgnoreCase("Ross"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void StreamsTest7() {
		//collecting the stream to a list
		List<String> ls = Stream.of("Ross","Rachel","Monica","Chandler").sorted().collect(Collectors.toList());
		System.out.println(ls.get(1));
		
		Stream.of(8,5,6,2,3,7,1,4,0,9).distinct().sorted().forEach(s->System.out.println(s));
		
	}
	
}
