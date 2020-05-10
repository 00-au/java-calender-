package calender;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

public class planitem {
	//필드 생성
	public Date planDate;

	public String detail;


	public static Date getDatefromString(String strDate) {

	Date date = null;
	try {
		date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
	}
	catch (ParseException e) {
		e.printStackTrace();
	}
		return date;
	}
	
	public planitem(String date, String detail) {
		this.planDate = getDatefromString(date);
		this.detail = detail;
	}

	public Date getDate() {
		return planDate;

	}

}
