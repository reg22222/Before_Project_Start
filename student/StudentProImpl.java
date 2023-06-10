package student;

import java.util.*;

public class StudentProImpl implements StudentPro {
	private List<Student> list = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	
	protected String inputStr(String title) {
		System.out.print(title+"�� �Է� : ");
		String str = in.next();
		return str;
	}
	protected int inputSub(String title) {
		System.out.print(title+"������ �Է� : ");
		int sub = in.nextInt();
		if (sub < 0 || sub > 100) {
			System.out.println(title+"������ ������ 0~100���� �Է� ����");
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
		String name = inputStr("�л��̸�");
		if (isName(name) == null) {
			int kor = inputSub("����");
			int eng = inputSub("����");
			Student insert = new Student(name, kor, eng);
			list.add(insert);
		}else {
			System.out.println(name+"�л��� �̹� �����ϴ� �л��Դϴ�.");
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
		String name = inputStr("������ �л��̸�");
		Student delete = isName(name);
		if (delete != null) {
			list.remove(delete);
		}else {
			System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
		}

	}

	@Override
	public void edit() {
		String name = inputStr("������ �л��̸�");
		Student edit = isName(name);
		if (edit == null) {
			System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
			return;
		}
		System.out.println("���� " + edit.getName()
					+ "���� ���������� " + edit.getKor()+"�� �Դϴ�.");
		int kor = inputSub("������ ����");
		edit.setKor(kor);
		System.out.println("���� " + edit.getName()
					+ "���� ���������� " + edit.getEng()+"�� �Դϴ�.");
		int eng = inputSub("������ ����");
		edit.setEng(eng);
		edit.setTot();
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}








