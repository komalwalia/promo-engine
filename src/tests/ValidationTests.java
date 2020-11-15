package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import application.Promotions;

class ValidationTests {

	@Test
	void totalPriceOfProductsShouldBeCorrect() {
		String input = "3\nA\n5\nB\n5\nC\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		assertEquals(370, price);
	}
}
