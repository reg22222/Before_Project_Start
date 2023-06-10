package member;
import java.util.*;

public class MemberMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MemberPro pro = new MemberProImpl();
		while(true) {
			System.out.print("1.회원등록 2.회원보기 3.회원삭제 4.회원수정 5.종료 : ");
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
