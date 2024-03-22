package Methods;

public class MyCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();
		System.out.println(c.Color);
		System.out.println(c.Name);
		System.out.println(c.Weight);
		c.carParking();
		System.out.println(c.carDriving());
		System.out.println(c.comfort());
		c.experience();
	}

}
