package CoreJavaTopics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class A011_DateFormat {

	public static void main(String[] args) {

		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
		SimpleDateFormat sd = new SimpleDateFormat("M/dd/yyyy hh:mm:ss");

		System.out.println(sdf.format(d));

		System.out.println(d.toString());

		System.out.println(sd.format(d));
		
	}

}
