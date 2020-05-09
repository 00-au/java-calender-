package calender;

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
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월dd일");
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
		printMenu();
		Scanner scanner = new Scanner(System.in);
		
		Calender cal = new Calender();

		while (true) {
			String cmd = scanner.next();
			//스위치는 문자열 불가라서 if로 해줌.
			 if(cmd.equals("1")) { cmd_register(); }
			 else if(cmd.equals("2")) { cmdSearch(); }
			 else if(cmd.equals("3")) { /*cmdCal(scanner, cal);*/ }
			 else if(cmd.equals("h")) { printMenu(); }
			 else if(cmd.equals("q")) { break;}
			 		
	
		}
		System.out.println("Good Bye."); 
		scanner.close();

	}








	private void cmdSearch() {
		// TODO Auto-generated method stub
		
	}





	private void cmd_register() {
		// TODO Auto-generated method stub
		
	}





	public static void main(String[] args) {
		//셀 실행
		prompt p = new prompt();
		p.runPrompt();
		
	}
}
