package collect;

import java.util.ArrayList;
import java.util.List;

public class Sales {
	private String code;
	private String company;
	private String product;
	private int price;
	private int amount;
	private int money;
	private int fee;
	
	public Sales() {
	}
	
	public Sales(String code, String company, String product, int price, int amount) {
		this.code = code;
		this.company = company;
		this.product = product;
		this.price = price;
		this.amount = amount;
		
		money = price * amount;
		fee = (int) (money * 0.001);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		String str = code + "\t" + company + "\t" + product + "\t" + price + "\t"
					+ amount + "\t" + money + "\t" + fee;
		return str;
	}
	
	public void print(Sales[] arr, List<Sales> list) {
		int sumMoney = 0;
		int sumFee = 0;
		for (Sales s : arr) {
			sumMoney += s.getMoney();
			sumFee += s.getFee();
			list.add(s);
		}
		System.out.println("코드\t상점\t상품\t단가\t수량\t금액\t판매수수료");
		for(Sales s : arr) {
			System.out.println(s);
		}
		System.out.println("금액합계:" + sumMoney);
		System.out.println("판매수수료합계:" + sumFee);
	}
	
	public static void main(String[] args) {
		Sales[] arr = { new Sales("001", "삼성", "냉장고", 500000, 10),
						new Sales("002", "LG", "TV", 800000, 20),
						new Sales("003", "대우", "세탁기", 700000, 25),
						new Sales("004", "삼보", "노트북", 1000000, 30),
						new Sales("005", "애플", "아이패드", 1000000, 40),
		};
		List<Sales> list = new ArrayList<>();
		Sales s = new Sales();
		s.print(arr, list);
	}
}
