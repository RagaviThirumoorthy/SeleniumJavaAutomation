package inheritance;

public class Demo3 extends Demo4 {

	int a;
	
	public Demo3(int a) {	//Parameterised constructor
		super(a);          //To invoke parent class constructor
		this.a = a;
	}

	public int increment() {
		a = a+1;
		return a;
	}
	
	public int decrement() {
		a = a-1;
		return a;
	}
}
