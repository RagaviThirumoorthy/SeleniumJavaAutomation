package javacodes.Interface;

public class IndianTrafficRules implements TrafficRules,AsianTrafficRules {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficRules rules = new IndianTrafficRules();
		rules.red();
		rules.green();
		rules.yellow();
		IndianTrafficRules indianRules = new IndianTrafficRules();
		indianRules.noParking();
		AsianTrafficRules asianRules = new IndianTrafficRules();
		asianRules.pedestrianCrossing();
	}

	@Override
	public void red() {
		// TODO Auto-generated method stub
		System.out.println("Stop");
	}

	@Override
	public void green() {
		// TODO Auto-generated method stub
		System.out.println("Go");
	}

	@Override
	public void yellow() {
		// TODO Auto-generated method stub
		System.out.println("Wait");
	}
	
	public void noParking() {
		System.out.println("Parking prohibited");
	}

	@Override
	public void pedestrianCrossing() {
		// TODO Auto-generated method stub
		System.out.println("Drivers yielding for pedestrians to cross the road");
	}

}
