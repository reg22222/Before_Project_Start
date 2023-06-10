package member;
import java.util.*;
public class MemberMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Member mb = new Member(null, null, null);
		MemberVO vo = new MemberVO();
		System.out.println("1.회원등록 2.회원보기 3.회원삭제 4.회원수정 5.종료 :");
		int a = in.nextInt();
		
		switch(a) {
		case 1: vo.insert(); break;
		case 2: vo.lookup(); break;
		case 3: vo.delete(); break;
		case 4: vo.fix(); break;
		default: vo.end(); break;
		}
		
	}
}
