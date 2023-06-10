package student;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentPro pro = new StudentProImpl();
		while(true) {
			System.out.print("1.학생등록 2.학생보기 3.학생삭제 4.학생수정 5.종료 : ");
			int select = in.nextInt();
			switch(select) {
			case 1 : pro.insert(); break;
			case 2 : pro.view(); break;
			case 3 : pro.delete(); break;
			case 4 : pro.edit(); break;
			case 5 : pro.exit(); break;
			default: System.out.println("잘못입력하셨습니다. 다시 입력해 주세요!!");
			}
		}
	}
}
