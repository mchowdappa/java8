package org.mcp.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamWithStringTest {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("ABCD");
		names.add("ABCDXYZZERWEREWRWZ");
		names.add("AQPBCD");
		names.add("QWABCD");
		names.add("ERCD");
		names.add("THYYCD");
		names.add("ABTYCDUUU");
		names.add("ATRFGVBCD");
		names.add("ABCD");
		names.add("ABWERCD");
		names.add("ABWERWCD");
		names.add("AEWRWBCERWD");
		names.add("AEWRWERBCEWREWD");

		names.forEach(name -> {
			System.out.println(name + "\t" + name.length());
		});

		List<String> emptyList = Collections.emptyList();
		System.out.println();
		names.parallelStream().filter(name -> (name.length() < 10)).map(i -> i).forEach((name -> {
			emptyList.add(name);
		}));
		emptyList.forEach(i-> {
			System.out.println(i + "\t" + i.length());
		});
	}

}
