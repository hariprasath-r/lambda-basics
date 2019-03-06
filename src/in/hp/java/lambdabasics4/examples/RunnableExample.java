package in.hp.java.lambdabasics4.examples;

import java.util.Scanner;

public class RunnableExample {

	public static void main(String[] args) {
		System.out.println(">---Select how you wanna create a new Thread");
		System.out.println("1. Classic Thread using Anonymmous Inner Class");
		System.out.println("2. Thread created using Lambda expression");
		Scanner scan = new Scanner(System.in);
		if(scan.next().equals("1"))
				classicThreadExampleUsingAnonymousInnerClass().run();
		else
			threadCreatedUsingLambda().run();
		scan.close();
	}

	static Thread classicThreadExampleUsingAnonymousInnerClass() {
		Thread myThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello, I'm a new Thread!");
			}
		});
		
		return myThread;
	}
	
	/**
	 * Reducing Boiler plate code
	 * @return
	 */
	static Thread threadCreatedUsingLambda() {
		Thread myThread = new Thread(() -> System.out.println("Hello, I'm a new Thread created using Lambda."));
		return myThread;
	}
	
}
