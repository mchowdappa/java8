/**
 * 
 */
package org.mcp.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cm1
 *
 */
public class PerformanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Long> ints = new ArrayList<>();
		List<Long> ints2 = new ArrayList<>();
		for (long i = 0; i < 700000; i++) {
			ints.add(i);
		}
		long start = System.currentTimeMillis();
		ints.stream().forEach(num -> ints2.add(num));
		long end = System.currentTimeMillis();
		ints2.clear();
		System.out.println((end - start));

		start = System.currentTimeMillis();
		ints.parallelStream().forEach(num -> ints2.add(num));
		end = System.currentTimeMillis();

		System.out.println((end - start));

	}

}
