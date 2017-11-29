package org.mcp.java.innerclass;

import org.mcp.java.innerclass.OuterClass.NestedClass;
import org.mcp.java.innerclass.OuterClass.ProtectedNestedClass;
import org.mcp.java.innerclass.OuterClass.PublicNestedClass;

public class InnerClassTest {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.method2();
		// Static class can access out side of the class.
		NestedClass nc = new NestedClass();
		nc.method();
		
		PublicNestedClass pnc = new PublicNestedClass();
		pnc.method();
		
		System.out.println(ProtectedNestedClass.c);
	}

}

class OuterClass {

	private int a = 10;

	private static int b =100;

	class InnerClass {
		public void method() {
			System.out.println(a);
		}
	}

	private class PrivateInnerClass {
		public void method() {
			System.out.println(a);
		}
	}

	public class PublicInnerClass {
		public void method() {
			System.out.println(a);
		}
	}

	protected class ProtectedInnerClass {
		public void method() {
			System.out.println(a);
		}
	}

	static class NestedClass {
		public void method() {
			System.out.println(++b); // a not accessible as its not static.
		}
	}

	private static class PrivateNestedClass {
		public void method() {
			System.out.println(b); // a not accessible as its not static.
		}
	}

	public static class PublicNestedClass {
		public void method() {
			System.out.println(b); // a not accessible as its not static.
		}
	}

	protected static class ProtectedNestedClass {
		public static int c = b;
		
		public void method() {
			
			System.out.println(b); // a not accessible as its not static.
		}
	}

	PrivateInnerClass pic = new PrivateInnerClass();
	PrivateNestedClass pnc = new PrivateNestedClass();
	public void method2(){
		pic.method();
		pnc.method();
	}
}