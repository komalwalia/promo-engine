package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Promotions {
	Map<String, Product> skuIdProductMap = new HashMap<String, Product>();

	public static void main(String[] args) {
		Map<String, Product> skuIdProductMap = new HashMap<String, Product>();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the total number of products in an order: ");
		int noOfOrder = s.nextInt();
		s = new Scanner(System.in);
		for (int index = 1; index <= noOfOrder; index++) {
			System.out.println("Enter the product SKUid: A,B,C or D ");
			String id = s.nextLine();
			Product product;
			if (!skuIdProductMap.containsKey(id)) {
				product = new Product(id);
			} else {
				product = skuIdProductMap.get(id);
			}

			product.setQuantity(product.getQuantity() + 1);
			skuIdProductMap.put(product.getId(), product);
		}
	}
}
