package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import application.Promotions;

class ValidationTests {

	@Test
	void totalPriceOfProductsShouldBe370() {
		String input = "3\nA\n5\nB\n5\nC\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		assertEquals(370, price);
	}

	@Test
	void totalPriceOfProductsShouldBe100() {
		String input = "3\nA\n1\nB\n1\nC\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		assertEquals(100, price);
	}

	@Test
	void totalPriceOfProductsShouldBe280() {
		String input = "4\nA\n3\nB\n5\nC\n1\nD\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		assertEquals(280, price);
	}

	@Test
	void totalPriceOfProductsShouldBe300() {
		String input = "4\nA\n3\nB\n5\nC\n2\nD\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		assertEquals(300, price);
	}

	@Test
	void totalPriceOfProductsShouldBe310() {
		String input = "4\nA\n3\nB\n5\nC\n2\nD\n2\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		assertEquals(310, price);
	}

	@Test
	void totalPriceOfProductsShouldBe295() {
		String input = "4\nA\n3\nB\n5\nC\n1\nD\n2\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Promotions promotions = new Promotions();
		promotions.getInput();
		double price = promotions.getPrice();
		assertEquals(295, price);
	}
}
