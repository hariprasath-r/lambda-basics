package in.hp.java.lambdabasics.example;

public class ClosureExample {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		/**
		 * Here we are calling method foo and passing the inteface Process implementation anonymously
		 * If we are about to pass the variable b, it'll only take the value of b at the moment
		 * The variable b should be final or effectively final, as in it should not be changed inside the implementation
		 */
		foo(a, new Process() {
			@Override
			public void doSomething(int i) {
				/*
				 * The below statement is passed as 
				 * System.out.prinltn(i + 20);
				 * 20 being the value of b at that time
				 */
				System.out.println(i + b);
			}
		});
		
		/**
		 * Similarly for lambda expression
		 * the below statement is same as System.out.prinltn(i + 20);
		 */
		foo(a, i -> System.out.println(i + b));
	}
	
	private static void foo(int a, Process p) {
		p.doSomething(a);
	}

	interface Process {
		void doSomething(int i);
	}
}
