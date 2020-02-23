package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

public static String getCurrentDate() {
		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss");
		String date=sdf.format(d);
		return date;
	}
}
