package collect;

import java.util.ArrayList;
import java.util.List;

public class ListStore {

	private String code;
	private String name;
	private String product;
	private int price;
	private int amount;
	private int money;
	private int fee;

	public ListStore(String code, String name, String product, int price, int amount)
	{
		this.code = code;
		this.name = name;
		this.product = product;
		this.price = price;
		this.amount = amount;
		money = price * amount;
		fee = (int) (money * 0.001);
		
	}
	
	@Override
	public String toString() {
		return code + "\t" + name + "\t" + product + "\t"
				+ price + "\t" + amount + "\t" + money + "\t" + fee;
	}

	public static void main(String[] args) {
		List<ListStore> list = new ArrayList<>();
		
		ListStore s1 = new ListStore("001", "삼성전자", "냉장고", 450000, 2);
		ListStore s2 = new ListStore("003", "현대자동차", "승용차", 900000, 5);
		ListStore s3 = new ListStore("004", "삼보컴퓨터", "프린터", 450000, 15);
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		System.out.println("코드\t상점명\t주요상품\t단가\t수량\t금액\t판매수수료");
		System.out.println("========================================================");
		for(int i = 0; i < list.size(); i++) {
			ListStore s = list.get(i);
			System.out.println(s);
		}
	}
}
