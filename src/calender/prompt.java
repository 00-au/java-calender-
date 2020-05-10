package calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class prompt {

	public void printMenu() {


		Scanner s = new Scanner(System.in);
		Calender c = new Calender();
		int month = 5;
		int year = 2020;
		System.out.println("");
		c.printCalender(year, month);
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월 dd일");
		Date time = new Date();
		String time1 = format.format(time);
		System.out.println("\n\n오늘은 " +time1+" 입니다.");

		System.out.println("\n*--*--*--*--*--*--*-"); 
		System.out.println("| 1. 일 정 등 록            |");
		System.out.println("| 2. 일 정 검 색            |");
		System.out.println("| 3. 일 정 삭 제            |");
		System.out.println("| 3. 일 정 수 정            |");
		System.out.println("| 4. h 도움말   e 종료   |");
		System.out.println("*--*--*--*--*--*--*- ");

	}





	/**
	 * 
	 * @param week 요일 명
	 * @return 0~6 (0= sunday, 6 = saterday)
	 */

	public int parseDay(String week) {
		switch(week) {
		case "일" :
			return 0;
		case "월" :
			return 1;
		case "화" :
			return 2;
		case "수" :
			return 3;
		case "목" :
			return 4;
		case "금" :
			return 5;
		case "토" :
			return 6;
		default :
			return 0;
		}


	}

	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);

		Calender cal = new Calender();
		boolean isLoop = true;
		while (isLoop) {
			String cmd = scanner.next();
			
		
			switch(cmd) {
			case "1" :
				cmd_register(scanner, cal);
				break;
			case "2" :
				cmdSearch(scanner, cal);
				break;
			case "3" :
				break;
			case "h" :
				printMenu();
				break;
			case "q" :
				isLoop = false;
				break;
			}
			if(cmd.equals("1")) { cmd_register(scanner, cal); }
			else if(cmd.equals("2")) { cmdSearch(scanner, cal); }
			else if(cmd.equals("3")) { /*cmdCal(scanner, cal);*/ }
			else if(cmd.equals("h")) { printMenu(); }
			else if(cmd.equals("q")) { break;}


		}
		System.out.println("Good Bye."); 
		scanner.close();

	}








	private void cmdSearch(Scanner s, Calender c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		String plan="";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);

	}





	private void cmd_register(Scanner s, Calender c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		System.out.println("일정을 입력해 주세요.");
		s.nextLine();
		String text = s.nextLine();
		String str = "";
		String[] sarr; 
		sarr = str.split(" ");
		c.registerPlan(date, text);

	}





	public static void main(String[] args) throws ParseException {
		//셀 실행
		prompt p = new prompt();
		p.runPrompt();

	}
}
