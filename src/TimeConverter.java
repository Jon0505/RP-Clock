public class TimeConverter
{
//	private int day;
	private int hour;
	private int minute;
	private String ampm;

	public TimeConverter()
	{

	}

//	public void setDay(int d)
//	{
//		day = d;
//	}

	public void setHour(int h)
	{
		hour = h;
	}

	public void setMinute(int m)
	{
		minute = m;
	}

	public void setAmpm(String a)
	{
		ampm = a;
	}

	public String irlToRoleplay()
	{
		String finalTime = "";
//		String finalMonth;

//		System.out.println("AM/PM: " + ampm);
//		System.out.println("Hour before: " + hour);

		// Checks if it is in PM or AM
		if (hour == 12)
			hour = 0;
		if (ampm.equalsIgnoreCase("pm"))
			hour += 12;

//		System.out.println("Hour after: " + hour);

		// Actual calculation
		finalTime += ((hour * 60) + minute) / 48.0 + 1;

		// Finding time of day
		double roleplayHour;
		String roleplayMinute;
		String roleplayampm = "am";

		double rawTimeOfDay = Double.parseDouble(finalTime.substring(
				finalTime.indexOf(".")));

		roleplayHour = (rawTimeOfDay * 24);

		roleplayMinute = (int) Math.round(roleplayHour % 1 * 60) + "";
		if (roleplayMinute.length() == 1)
			roleplayMinute += 0;

		if (roleplayHour > 12)
		{
			roleplayampm = "pm";
			roleplayHour -= 12;
		}

		if(roleplayHour > -1 && roleplayHour < 1)
		{
			roleplayHour = 12;
		}


		finalTime = finalTime.substring(0, finalTime.indexOf("."));

		// Adding the "st", "nd", "rd", and "th" at the end
		if(finalTime.charAt(finalTime.length()-1) == 49)
			finalTime += "st";
		else if(finalTime.charAt(finalTime.length()-1) == 50)
			finalTime += "nd";
		else if(finalTime.charAt(finalTime.length()-1) == 51)
			finalTime += "rd";
		else
			finalTime += "th";

		// Calculates what month it is
//		switch (day) {
//			case 1:  finalMonth = "January";
//				break;
//			case 2:  finalMonth = "February";
//				break;
//			case 3:  finalMonth = "March";
//				break;
//			case 4:  finalMonth = "April";
//				break;
//			case 5:  finalMonth = "May";
//				break;
//			case 6:  finalMonth = "June";
//				break;
//			case 7:  finalMonth = "July";
//				break;
//			case 8:  finalMonth = "August";
//				break;
//			case 9:  finalMonth = "September";
//				break;
//			case 10: finalMonth = "October";
//				break;
//			case 11: finalMonth = "November";
//				break;
//			case 12: finalMonth = "December";
//				break;
//			default: finalMonth = "Invalid month";
//				break;
//		}

		// Adds month
//		finalTime = finalMonth + " " + finalTime;

		// Adds time of day
		finalTime += " at " + (int)roleplayHour + ":" + roleplayMinute + " " + roleplayampm;

		// Returns the time
		return finalTime;
	}
}
