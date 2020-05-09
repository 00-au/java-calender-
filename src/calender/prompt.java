package calender;

import java.util.Scanner;

public class prompt {
	/**
	 * 
	 * @param week 요일 명
	 * @return 0~6 (0= sunday, 6 = saterday)
	 */
	
	public int parseDay(String week) {
		if (week.equals("일")) return 0;
		else if (week.equals("월"))return 1;
		else if (week.equals("화"))return 2;
		else if (week.equals("수")) return 3;
		else if (week.equals("목")) return 4;
		else if (week.equals("금")) return 5;
		else if (week.equals("토")) return 6;
		
		else return 0;
			
	}
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		int month = 1;
		int year = 2017;
		int weekday = 0;
		
		while (true) {
			System.out.println("\n년도를 입력하세요 (exit: -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("달을 입력하세요");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력 값입니다.");
				continue; //루프의 처음으로 
			}
			
			System.out.println("첫째 날의 요일을 입력하세요");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);


			
			cal.printCalender(year, month,weekday);
			
		}
		System.out.println("Bye");
		scanner.close();

	}
	public static void main(String[] args) {
		//셀 실행
		prompt p = new prompt();
		p.runPrompt();
		
	}
}
