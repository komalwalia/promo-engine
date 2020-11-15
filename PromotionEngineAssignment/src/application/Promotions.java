package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Promotions {
	Map<String, Product> skuIdProductMap = new HashMap<String, Product>();

	public void getInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the total number of products in an order: ");
		int noOfOrder = s.nextInt();
		s.nextLine();
		for (int index = 1; index <= noOfOrder; index++) {
			System.out.println("Enter the product SKUid: A,B,C or D ");
			String id = s.nextLine();
			System.out.println("Enter the quantity of product: ");
			int quantity = s.nextInt();
			s.nextLine();

			Product product;
			product = new Product(id);
			product.setQuantity(quantity);
			skuIdProductMap.put(product.getId(), product);
		}

		s.close();
	}

	public double getPrice() {
		double price = 0;

		for (Entry<String, Product> entry : skuIdProductMap.entrySet()) {
			price += applyPromotions(entry.getValue());
		}

		return price;
	}

	private double applyPromotions(Product product) {
		double price = 0;
		if (product.getId().equals("A")) {
			price = (product.getQuantity() / 3) * 130 + ((product.getQuantity() % 3) * product.getPrice());
		} else if (product.getId().equals("B")) {
			price = (product.getQuantity() / 2) * 45 + (product.getQuantity() % 2) * product.getPrice();
		} else if (product.getId().equals("C")) {
			int quantity;
			if (skuIdProductMap.containsKey("D")) {
				quantity = product.getQuantity() - skuIdProductMap.get("D").getQuantity();
				quantity = quantity < 0 ? 0 : quantity;
			} else
				quantity = product.getQuantity();

			price = quantity * product.getPrice();

		} else if (product.getId().equals("D")) {
			int quantity;
			int quantityOfCAndD = 0;
			if (skuIdProductMap.containsKey("C")) {
				quantity = product.getQuantity() - skuIdProductMap.get("C").getQuantity();
				quantity = quantity < 0 ? 0 : quantity;
				quantityOfCAndD = product.getQuantity() == skuIdProductMap.get("C").getQuantity()
						? product.getQuantity()
						: Math.abs(product.getQuantity() - skuIdProductMap.get("C").getQuantity());
			} else
				quantity = product.getQuantity();

			price = quantity * product.getPrice();
			price += quantityOfCAndD * 30;
		}
		return price;
	}

	public Map<String, Product> getSkuIdProductMap() {
		return skuIdProductMap;
	}

	public void setSkuIdProductMap(Map<String, Product> skuIdProductMap) {
		this.skuIdProductMap = skuIdProductMap;
	}

	public static void main(String[] args) {
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		System.out.println("Total price: " + price);
	}
}
