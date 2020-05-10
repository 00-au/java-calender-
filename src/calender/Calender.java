package calender;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.HashMap;
import java.util.Scanner;


public class Calender {
	private final int[] maxDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	//배열로 그 달의 마지막을 지정한 final 필드이다. 한정적으로 calender라는 클래스 안에서만 사용 가능하다.
	private final int[] LeapmaxDays = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	//위의 코드와 동일하다. 윤년을 적용해 주기 위해 만든 필드이다.
	
	
	
	private HashMap <Date, planitem> planMap; //검색을 할 수 있게 데이터를 바로 찾아주는 hashmap 기능이다.
	
	
	//생성자
	public Calender() {
		planMap = new HashMap<Date,planitem>(); //날짜로 플랜을 찾는 검색기능이다.
	
	}
	

	//일정 등록
	public void registerPlan(String strDate, String plan) {
		
		planitem p = new planitem(strDate, plan); //날짜와 일정을 등록해주는 코드이다.
		planMap.put(p.getDate(), p); // planMap에 date를 넣어준다, 일정 또한 등록시켜준다 (p)
	}
	
	
	//일정 검색
	public planitem searchPlan(String strDate) { //등록된 일정을 검색해주는 코드이다.
		Date date = planitem.getDatefromString(strDate); //planitem에서 날짜를 불러온다.
		return planMap.get(date); //등록된 값을 리턴해준다.
	}
	
	//윤년 계산
	public boolean isLeapYear(int year) { //boolean으로 윤년이 맞으면 true, 아니라면 false를 해서 윤년을 맞춰준다.
		if (year % 4 ==0 && (year % 100 != 0 || year % 400 == 0 )) { //4로 나누어떨어지고, 100으로 떨어지지 않지만 400으로는 떨어질 때)
			return true ;
		}
		else {
			return false;
		}
	}
	
	//윤년인지, 아닌지
	public int maxDaysOfMonth(int year, int month) {

		if (isLeapYear(year)) {
			return LeapmaxDays[month];
		}

		else {
			return maxDays[month];
		}
	}

	
	// calender를 출력해주기 위해서 틀을 만들어준다.
	public void printCalender(int year, int month) {
		System.out.printf("    <<%d년 %d월>>\n",year, month); //지정되어있는 year과 month를 출력
		System.out.println(" 일   월   화   수   목   금   토");
		System.out.println(" -------------------- ");
	
	
	
	//현실 달력 알아보기
	int weekday = getweekDay(year,month,1);


	for(int i = 0;i<weekday;i++) //
	{ System.out.print("   ");} //칸을 맞추기 위해서 칸 만큼 띄워줌 1970-1-1 기준이므로, 목요일 기준

	int maxDay = maxDaysOfMonth(year, month); //그 달의 마지막을 맞춰준다.

	int count = 7 - weekday; // weekday만큼 띄워주어야 하므로, count함수를 이용하여 7-weekday를 해준다.
	
	int delim = (count < 7) ? count : 0; //일요일을 신경써주기 위하여 7-7=0 이므로 코드를 넣어줌
	
	for(int i = 1; i <= count; i++) {

		System.out.printf("%3d", i); 
	}

	System.out.println("");

	count++;

	for( int i = count;i<=maxDay;i++) //maxDay까지 반복시켜준다.
	{

		System.out.printf("%3d", i);

		if (i % 7 == delim) //if문을 돌려서 delim과 비교한 후 줄 맞춰준다

			System.out.println("");
	}

}

	private int getweekDay(int year, int month, int day) {

		int syear = 1970;
		final int standardweekday = 4; //1970/jan/1st/thursday
		int count = 0;
		for (int i = syear; i < year; i++) {

			int delta = isLeapYear(i) ? 366 : 365 ;
			count += delta;
		}

		for (int i = 0; i < month; i++) {
			int delta = maxDaysOfMonth(year, i);
			count += delta;
		}
		count += day-1;

		int weekday = (count + standardweekday) % 7; 
		return weekday;
	
	}
	

}
	
