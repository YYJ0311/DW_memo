package test;
import java.util.ArrayList;
import java.util.List;

class Singer{
	public String SingerName; //가수 이름
	public Singer(String singerName) {
		this.SingerName = singerName;
	}
}

public class 긴급점검3 {
	public static List<Singer> getListSinger(ArrayList<Singer> list){
//		List<Singer> list = new ArrayList<Singer>();
////		Singer s = new Singer("김종국");
//		list.add(new Singer("김종국"));
//		list.add(new Singer("서인국"));
//		list.add(new Singer("방용국"));
//		// 타입이 Singer라서 list.add(); 괄호 안에도 타입에 맞게 new Singer()로 불러줌
//		for(Singer s : list) {
//			System.out.println(s.SingerName);			
//		}
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).SingerName);
		}
		return list;
	}
	public static Singer getSinger(){
//		List<Singer> list = new ArrayList<Singer>();
//		list.add(new Singer("김종국"));
//		for(Singer s : list) {
//			System.out.println(s.SingerName);			
//		}
		return null;
	}
	public static void main(String[] args) {
		ArrayList<Singer> list = new ArrayList<Singer>();
		list.add(new Singer("김종국"));
		list.add(new Singer("서인국"));
		list.add(new Singer("방용국"));
		//1. getListSinger()이용해서 김종국, 서인국, 방용국 list 출력!
		getListSinger(list);
		System.out.println("---");
		//2. getSinger()이용해서 김종국만 출력!
		getSinger();
	}
}