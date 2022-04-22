package 연습;

import java.util.ArrayList;
import java.util.List;

class Members{
	private String name;
	private List<String> stone = null;
	
	public List<String> getStone() {
		return stone;
	}
	public void setStone(List<String> stone) {
		this.stone = stone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class Avengers {
	public static Members printMemberName(Members member) {
		if(member == null) {
			member = new Members();
//			member.getName();
		}
		// 로직구현
		member.setName("토르");
		// 멤버 클래스에 stone을 추가하려면 어떻게?
		List<String> list = new ArrayList<String>();
		list.add("파워스톤");
		list.add("타임스톤");
		member.setStone(list);
		return member;
	}
	public static void main(String[] args) {
//		Members m = new Members();
//		m.setName("토르");
//		String name = m.getName();
//		System.out.println("m => "+name);
//		
//		Members m2 = new Members();
//		String name2 = m2.getName();
//		System.out.println("m2 => "+name2); // null
//		모든 클래스의 초기값은 null이다. 따라서 String의 초기값도 null.
//		만약 Members m2 = m; 라고 하면, 토르가 출력된다.
		
//		printMemberName(); 을 사용하기 위한 방법
//		방법 1
//		Members m = new Members();
//		printMemberName(m);
		
//		방법 2
		printMemberName(new Members());
		
//		방법 3
		Members m3 = null;
//		Members m3 = new Members();
		printMemberName(m3);
//		m3.setName("헐크");
//		m3.getName(); // 최종 이름은? 헐크
		List<String> list = new ArrayList<String>();
		list.add("파워스톤");
		list.add("타임스톤");
		printMemberName(m3).setStone(list);
		String powerStone = printMemberName(m3).getStone().get(0);
		String timeStone = printMemberName(m3).getStone().get(1);
		System.out.println(powerStone);
		System.out.println(timeStone);
	}
}