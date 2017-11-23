package org.mcp.java8.lambda;

public class LambdaTest {

	public static void main(String[] args) throws InterruptedException {

		long startTime = System.currentTimeMillis();
		Thread t1 = new Thread(new MyThread());
		t1.start();
		t1.join();
		System.out.println(System.currentTimeMillis() - startTime);
		startTime = System.currentTimeMillis();
		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("In Doing job with expression.");
		});

		t2.start();
		t2.join();
		System.out.println(System.currentTimeMillis() - startTime);
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("In Doing a JOB");
	}

}