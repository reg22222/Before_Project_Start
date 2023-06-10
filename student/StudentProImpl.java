package student;

import java.util.*;

public class StudentProImpl implements StudentPro {
	private List<Student> list = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	
	protected String inputStr(String title) {
		System.out.print(title+"을 입력 : ");
		String str = in.next();
		return str;
	}
	protected int inputSub(String title) {
		System.out.print(title+"점수를 입력 : ");
		int sub = in.nextInt();
		if (sub < 0 || sub > 100) {
			System.out.println(title+"과목의 점수는 0~100점만 입력 가능");
			return inputSub(title);
		}else {
			return sub;
		}
	}
	protected Student isName(String name) {
		for(Student st : list) {
			if (st.getName().equals(name.trim())){
				return st;
			}
		}
		return null;
	}
	protected void rank() {
		for(Student i : list) {
			i.clearRank();
			for(Student j : list) {
				if (i.getTot() < j.getTot()) {
					i.plusRank();
				}
			}
		}
	}
	
	@Override
	public void insert() {
		String name = inputStr("학생이름");
		if (isName(name) == null) {
			int kor = inputSub("국어");
			int eng = inputSub("영어");
			Student insert = new Student(name, kor, eng);
			list.add(insert);
		}else {
			System.out.println(name+"학생은 이미 존재하는 학생입니다.");
			insert();
			//return;
		}
	}

	@Override
	public void view() {
		rank();
		for(Student view : list) {
			view.disp();
		}
	}

	@Override
	public void delete() {
		String name = inputStr("삭제할 학생이름");
		Student delete = isName(name);
		if (delete != null) {
			list.remove(delete);
		}else {
			System.out.println(name+"님은 저희 학생이 아닙니다.");
		}

	}

	@Override
	public void edit() {
		String name = inputStr("수정할 학생이름");
		Student edit = isName(name);
		if (edit == null) {
			System.out.println(name+"님은 저희 학생이 아닙니다.");
			return;
		}
		System.out.println("현재 " + edit.getName()
					+ "님의 국어점수는 " + edit.getKor()+"점 입니다.");
		int kor = inputSub("수정할 국어");
		edit.setKor(kor);
		System.out.println("현재 " + edit.getName()
					+ "님의 영어점수는 " + edit.getEng()+"점 입니다.");
		int eng = inputSub("수정할 영어");
		edit.setEng(eng);
		edit.setTot();
	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}








