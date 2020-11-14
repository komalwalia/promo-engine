package application;

public class Product {

	private String id;
	private int price;

	public Product(String id) {
		this.id = id;
		switch (id) {
		case "A":
			this.price = 50;
		case "B":
			this.price = 30;
		case "C":
			this.price = 20;
		case "D":
			this.price = 15;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
