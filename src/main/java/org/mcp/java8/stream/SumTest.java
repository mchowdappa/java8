package org.mcp.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SumTest {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			numbers.add(i * ThreadLocalRandom.current().nextInt(5, 10));
		}

		// Sum of all 2 digit integers in the list.
		int sum = 0;

		for (Integer integer : numbers) {

			if (integer > 10 && integer < 100) {
				sum = sum + integer;
			}
		}
		
		System.out.println("Sum: "+ sum);
		/**
		 * Drawbacks :
		 * 1. We just want to know the sum of integers but we would also have to provide how the iteration will take place, 
		      this is also called external iteration because client program is handling the algorithm to iterate over the list.
		 * 2. The program is sequential in nature, there is no way we can do this in parallel easily.
		 * 3. There is a lot of code to do even a simple task.
		 */
	
		sum = numbers.stream().filter(i -> (i> 10 && i< 100)).mapToInt(i->i).sum();
		System.out.println("Sum (with Stream): "+ sum);
		
	}

}
