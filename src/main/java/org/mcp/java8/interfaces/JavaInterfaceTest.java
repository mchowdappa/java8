package org.mcp.java8.interfaces;

public class JavaInterfaceTest {

	public static void main(String[] args) {
		
		FunctionalIntf fi = () -> {
			System.out.println("In ananymus impl, trying to call default method");
			// doInternal
			return "Hello";
			
		};
		
		fi.doFunction(); // How this line valid ?
		fi.doInternal();
		
		FunctionalIntf.doSomething();
		
	}

}

@FunctionalInterface
interface FunctionalIntf {
	
	String doFunction();
	
	default void doInternal(){
		System.out.println("In doInternal");
	}
	
	static void doSomething(){
		System.out.println("In doSomething");
	}
	
}

