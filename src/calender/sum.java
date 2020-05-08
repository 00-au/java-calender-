package calender;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		
		
		int a,b;
		//입력 : 키보드로 두 수의 입력을 받는다.
		Scanner scanner = new Scanner(System.in); //입력받기 키보드는 in 문을 열고 들어가서 뭔가를 한다.
		String s1, s2; //반드시 스트링이어야함
		System.out.println("두 수를 입력해주세요");
		s1 = scanner.next();
		s2 = scanner.next();

		a = Integer.parseInt(s1); //int 형으로 바꿔줌
		b = Integer.parseInt(s2);

		
		//출력 : 두 수의 값을 출력한다.
		int c = a + b;
		System.out.println("두 수의 합은 " + c+ "입니다.");
		System.out.printf("%d와 %d의 합은 %d입니다.",a,b, a+b);
		scanner.close(); //문을 닫고끝낸다.
	}

}
