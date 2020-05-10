package calender;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Scanner;



public class prompt {
	

	//실행 프롬포트 - 실행하는 부분
	public void runPrompt()  {
		
		//메뉴부터 출력해준다.
		c1();
		
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		boolean isLoop = true;
		while (isLoop) {
			c2();
			String cmd = scanner.next();
			switch (cmd) {
			case "1":
				cmd_register(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdcal(scanner,cal);
				break;
			case "4":
				isLoop = false;
				break;
			}
		}
			System.out.println("캘린더를 이용해주셔서 감사합니다.");
			scanner.close();
	}
	



	public int parseDay(String week) {

		switch (week) {

		case "일":

			return 0;

		case "월":

			return 1;

		case "화":

			return 2;

		case "수":

			return 3;

		case "목":

			return 4;

		case "금":

			return 5;

		case "토":

			return 6;

		default:

			return 0;

		}

	}


private void cmdcal(Scanner scanner, Calender cal) {
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
		cal.printCalender(year, month);
	}
	
	}










//메뉴 메소드
	public void c1() {
		
				Calender c = new Calender();	
				
				
				//미리 달과 년을 지정해준다
				int month = 5; 
				int year = 2020;
				//오늘 날짜 부여받기
				System.out.println("");
				SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
				Date time = new Date();
				String time1 = format.format(time);
				System.out.println("TODAY: " + time1 + "\n");
				//달력 출력
				c.printCalender(year, month);
				
			
			}

			
	
	private void cmd_register(Scanner s, Calender c){

		System.out.println("[새 일정 등록]");

		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();

		System.out.println("일정을 입력해 주세요.");

		s.nextLine();

		String text = s.nextLine();

		String str = "";

		str.split(" ");

		c.registerPlan(date, text);
		

		}
		

	
			
			
			
			
		
			//일정 검색 메소드
	private void cmdSearch(Scanner s, Calender c) {

				System.out.println("[일정 검색]");
				System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
				String date = s.next();
				planitem plan;


		plan = c.searchPlan(date);

		if (plan != null) {

			System.out.println(plan.detail);  //detail -> 등록된 일정을 불러옴

		} else {

			System.out.println("일정이 없습니다"); //plan == null
		}
	}
	
	public void c2() {

		System.out.println("\n\n*--*--*--*--*--*--*-");
		System.out.println("| 1. 일 정 등 록            |");
		System.out.println("| 2. 일 정 검 색            |");
		System.out.println("| 3. 달 력 보 기            |");
		System.out.println("| 4. 종  료                  |");
		System.out.println("*--*--*--*--*--*--*- ");
		System.out.println("명령을 입력해 주세요 >");
	}

public static void main(String[] args)  {
	prompt p = new prompt();

	p.runPrompt();
}
}
