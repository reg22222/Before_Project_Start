package member;

import java.util.*;

public class MemberProImpl implements MemberPro{

	private List<Member> list = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	
	protected String inputStr(String title) {
		String str = null;
		System.out.print(title+"�� �Է� : ");
		str = in.next();
		return str;
	}
	
	@Override
	public void insert() {
		String name = null;
		do{
			name = inputStr("�̸�");
		}while(isName(name) != null);		
		String tel = inputStr("��ȭ��ȣ");
		String email = inputStr("�̸����ּ�");
		Member insert = new Member(name, tel, email);
		list.add(insert);		
	}

	@Override
	public void view() {
		for(Member view : list) {
			view.disp();
		}
	}
	
	protected Object isName(String name) {
		for(Member mb : list) {
			if (mb.getName().trim().equals(name)) {
				return mb;
			}
		}
		return null;
	}	

	@Override
	public void delete() {
		String name = inputStr("������ ȸ��");
		Member delete = (Member)isName(name);
		if (delete != null) {
			list.remove(delete);
			System.out.println(name+"ȸ������ �����Ͽ����ϴ�.");
		}else {
			System.out.println(name+"ȸ������ �������� �ʽ��ϴ�.");
		}
	}

	@Override
	public void edit() {
		String name = inputStr("������ ȸ���̸�");
		Member edit = (Member)isName(name);
		if (edit == null) {
			System.out.println(name+"ȸ������ �������� �ʽ��ϴ�.");
			//edit(); -- ���ȣ��
			return;	// void �޼ҵ��� ����� return �̴�
		}else {
			System.out.println(name+"���� ��ȭ��ȣ : "+ edit.getTel());
			String tel = inputStr("������ ȸ����ȭ��ȣ");
			edit.setTel(tel);
			System.out.println(name+"���� �̸��� �ּ� : "+ edit.getEmail());
			edit.setEmail(inputStr("������ ȸ���̸����ּ�"));
		}
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}

}








