package org.mcp.java8.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEachTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		System.out.println("Using iterator:");
		Iterator<Integer> iterator = list.iterator();
		for (; iterator.hasNext();) {
			System.out.print(iterator.next() + "\t");

		}
		// Traversing using for-each loop way
		System.out.println("\nUsing for-each loop:");
		for (Integer integer : list) {
			System.out.print(integer + "\t");
		}

		// Traversing using forEach() method
		System.out.println("\nUsing forEach():");

		Consumer<? super Integer> after = new MyConsumer2();
		list.forEach(new MyConsumer(25).andThen(after));
	}

}




interface MyIntf<T> {

	MyIntf<? super T> method2(MyIntf<? super T> myIntf);

	MyIntf<T> method3(MyIntf<T> myIntf);

}

class MyInteger implements MyIntf<Integer>{

	@Override
	public MyIntf<? super Integer> method2(MyIntf<? super Integer> myIntf) {
		MyNumber number = new MyNumber();
		return number;
	}

	@Override
	public MyIntf<Integer> method3(MyIntf<Integer> myIntf) {
		return myIntf;
	}
	
}


class MyNumber implements MyIntf<Number> {

	@Override
	public MyIntf<? super Number> method2(MyIntf<? super Number> myIntf) {
		MyInteger integer = new MyInteger();
		return null;
	}

	@Override
	public MyIntf<Number> method3(MyIntf<Number> myIntf) {
		
		return null;
	}
	
}



















class MyConsumer2 implements Consumer<Number>{

	@Override
	public void accept(Number t) {
			System.out.println("In Number accept:" +t);
	}
	
}


@SuppressWarnings("hiding")
class MyConsumer<Integer> implements Consumer<Integer> {

	public MyConsumer(Integer num) {
		this.num = num;
	}
	private Integer num;
	@Override
	public void accept(Integer t) {
		System.out.println("IN accept():"+ t);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Consumer<Integer> andThen(Consumer<? super Integer> after) {
		System.out.println("IN andThen():");
		return (Consumer<Integer>) after;
	}

	public Integer getNum() {
		return num;
	}
	
	
}
