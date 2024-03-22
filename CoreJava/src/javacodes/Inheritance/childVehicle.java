package javacodes.Inheritance;

public class childVehicle extends ParentVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		childVehicle child = new childVehicle();
		System.out.println("Vehicle color is "+child.color);
		child.brakes();
		child.gear();
		child.engine();
		child.getData(4);
		child.getData("Ragavi");
		child.audio();
	}
	
	public void getData(int a) {
		System.out.println(a);
	}
	
	public void getData(String name) {				//Function overloading - Same method name and different arguments
		System.out.println(name);
	}
	
	public void engine() {
		System.out.println("New engine code");
	}
	
	public void audio() {							//Function overriding - Same method name and same arguments				
		System.out.println("Child Audio code");
	}

}
