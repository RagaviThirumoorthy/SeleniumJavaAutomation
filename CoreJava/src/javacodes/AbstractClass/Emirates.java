package javacodes.AbstractClass;

public class Emirates extends AirCraft {
	
	public static void main(String[] args) {
		Emirates emi = new Emirates();
		emi.engine();
		emi.safety();
		emi.color();
	}

	@Override
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("Red on the body");
	}
	
	

}
