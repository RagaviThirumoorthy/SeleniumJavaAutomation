package javacodes.Constructors;

public class ConstructorsDemo {
	
	public ConstructorsDemo() {									//Explicit constructor,Default constructor
		System.out.println("Default Constructor");			
	}
	
	public ConstructorsDemo(int i, int j) {						//Paramerterised constructor
		System.out.println(i+j);								
	}

	public ConstructorsDemo(String string) {
		System.out.println(string);
	}

	public void getData() {
		System.out.println("Method");
	}

	public static void main(String[] args) {
		
		ConstructorsDemo con = new ConstructorsDemo();   //If no constructor is defined, Java compiler will invoke the implicit constructor
		ConstructorsDemo con1 = new ConstructorsDemo(2,3);
		ConstructorsDemo con2 = new ConstructorsDemo("Ragavi");
		
	}

}
