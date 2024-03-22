package javacodes.Inheritance;

public class ThisDemo {
	
	int i =5;
	
	public void getData() {
		int i = 10;
		int sum = i + this.i;
		System.out.println(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThisDemo demo = new ThisDemo();
		demo.getData();
	}

}
