package javacodes.CalendarDates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(date));
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(sdf1.format(date));
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		System.out.println(sdf2.format(date));
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
		System.out.println(sdf3.format(date));
	}

}
