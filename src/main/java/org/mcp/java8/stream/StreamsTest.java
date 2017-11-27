package org.mcp.java8.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		// Stream Creation.

		/**
		 * 1. Creating Empty stream.
		 * 2. Stream of Collections/List
		 */
		List<String> names = Collections.emptyList();
		@SuppressWarnings("unused")
		Stream<String> streamNames = (names == null || names.isEmpty()) ? Stream.empty() : names.stream();
		
	}

}
