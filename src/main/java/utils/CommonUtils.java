package utils;

import java.util.Date;

public class CommonUtils {
	public static final int PAGE_LOAD_TIMEOUT=15;
	public static final int IMPLICITE_WAIT_TIME=10;
	public static final int EXPLICITE_WAIT_TIME=20;
	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "manoharkantjoshi" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}
}
