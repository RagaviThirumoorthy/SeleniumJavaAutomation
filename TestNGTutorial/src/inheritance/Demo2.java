package inheritance;

import org.testng.annotations.Test;

public class Demo2 extends InheritanceDemo1 {
	
	@Test
	public void childDemo() {
		
		int a=3;
		Demo3 d3 = new Demo3(a);
		System.out.println(d3.increment());
		System.out.println(d3.decrement());
		
		System.out.println(d3.multiplyTwo());
		System.out.println(d3.divideTwo());
	}

}
