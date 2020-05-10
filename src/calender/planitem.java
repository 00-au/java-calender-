package calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class planitem {
	public Date planDate;
	public String detail;
	public String peoples = "";
	
	public planitem(String date, String detail) {
		try {
			planDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			System.out.println("날짜를 잘못 입력하셨습니다.");
			e.printStackTrace();
		}
		this.detail = detail;
	}
	
 	public Date getDate() {
 		return planDate;
 	}
	
	public void addPeople(String name) {
		peoples += name + ",";
	}
}
