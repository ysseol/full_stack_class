package health;

public class HealthDTO {
	
	private String id;
	private String name;
	private int age;
	private double height;
	private double weight;
	private double bmi;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	@Override
	public String toString() {
		return "BmiDTO [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", bmi=" + bmi + "]";
	}

	public HealthDTO() {
	}

	public HealthDTO(String id, String name, int age, double height, double weight, double bmi) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
	}
}
