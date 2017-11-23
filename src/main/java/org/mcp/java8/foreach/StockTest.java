package org.mcp.java8.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class StockTest {

	public static void main(String[] args) {

		List<Trader> traders = new ArrayList<>();

		Random random = new Random();

		// Initializing trading a/c's.
		for (int i = 0; i < 10; i++) {
			Trader trader = new Trader((random.nextInt(100) + 1) * 3);
			traders.add(trader);
		}
		// Display Trade accounts.
		System.out.println("Before Bonus, Units are:");
		for (Trader trader : traders) {
			System.out.print(trader.getUnits() + "\t");
		}

		// Add bonus to each trader.
		traders.forEach(new Consumer<Trader>() {

			@Override
			public void accept(Trader trader) {
				trader.updateBonus(2);
			}

		});

		// Display Trade accounts after bonus applied..
		System.out.println("\nAfter bonus:");
		for (Trader trader : traders) {
			System.out.print(trader.getUnits() + "\t");
		}

	}

}

class Trader {
	private int units;

	public Trader(int initialUnits) {
		this.units = initialUnits;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public void updateBonus(int bonusUnits) {
		this.units = this.units * bonusUnits;
	}
}