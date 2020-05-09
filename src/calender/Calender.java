package calender;

import java.util.Scanner;

public class Calender {
	private final int[] maxDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LeapmaxDays = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapYear(int year) {
		if (year % 4 ==0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		else {
		return false;
	}
}
	public int maxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LeapmaxDays[month];
		}
		else {
		return maxDays[month];
	}
}
	public void printCalender(int year, int month) {
		System.out.printf("    <<%d년 %d월>>\n",year, month);
		System.out.println(" 일   월   화   수   목   금   토");
		System.out.println(" -------------------- ");
		//get week day automatiqally
		
		int weekday = getweekDay(year,month,1);
		//print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		
	
		int maxDay = maxDaysOfMonth(year,month);
		int count = 7-weekday;
		int delim = (count < 7) ? count : 0;
		/*
		if (count < 7 ) {
			delim = count;
		} else {
			delim = 0;
		}
		*/
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d",i);
		}
		System.out.println("");
		
		count++;
		for(int i = count; i <= maxDay; i++) {
			System.out.printf("%3d",i);
			if (i % 7 == delim) 			
				System.out.println(""); }
			
		}
		
private int getweekDay(int year, int month, int day) {
		int syear = 1970;

		final int standardweekday = 3; //1970/jan/1st/thursday
		
		int count = 0;
		
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365 ;
			count += delta;
		}
		
		
		for (int i = 0; i < month; i++) {
			int delta = maxDaysOfMonth(year, i);
			count += delta;
		}
		count += day;
		//System.out.println(count);
		int weekday = (count + standardweekday) % 7; 
		return weekday;
	
	}

	public static void main(String[] args) {
		Calender c = new Calender();
		System.out.println(	c.getweekDay(1970, 1, 1) == 3);
		System.out.println(	c.getweekDay(1971, 1, 1) == 4);
		System.out.println(	c.getweekDay(1972, 1, 1) == 5);
		System.out.println(	c.getweekDay(1973, 1, 1) == 0);
		System.out.println(	c.getweekDay(1974, 1, 1) == 1);
	}
//		System.out.println(" 1  2  3  4  5  6  7 ");
//		System.out.println(" 8  9  10 11 12 13 14 ");
//		System.out.println(" 15 16 17 18 19 20 21 ");
//		System.out.println(" 22 23 24 25 26 27 28 ");

	
	public static void main1(String[] args) {


		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		int month = 1;
		while (true) {
			
			System.out.println(" 달을 입력하세요");
			
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue; //루프의 처음으로 
			}

		}
		System.out.println("Bye");

		//cal.printSampleCalender();

		scanner.close();
	}
}
