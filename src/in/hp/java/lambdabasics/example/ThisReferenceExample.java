package in.hp.java.lambdabasics.example;

import in.hp.java.lambdabasics.example.ClosureExample.Process;

public class ThisReferenceExample {

	public static void main(String[] args) {
		
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, new Process() {
			
			@Override
			public void doSomething(int i) {
				System.out.println(i);
				/*
				 * Notice that "this" instance is used inside a static method, which is main
				 * Also, since we are overriding the toStirng, we can observe that the "this" instance is 
				 * actually an instance of the anonymous inner class
				 */
				System.out.println(this);
			}
			
			@Override
			public String toString() {
				return "This is anonymous inner class";
			}
		});
		
		/*
		 * If we were to use the same implementation above with lambdas
		 */
		thisReferenceExample.doProcess(20, i -> {
			System.out.println(i);
			/*
			 * Notice we cannot use this inside the lambda
			 * Lambdas always points to parent instance, or in other words
			 * It does not have its own instance as like anonymous inner class
			 * So, since we are implementing the lambda inside main which is static,
			 * we are not able to use this keyword
			 */
//			System.out.println(this);
		});
		
		thisReferenceExample.execute();

	}
	
	/**
	 * Reusing the same method in Closure example
	 * Instead of static, we are keeping it as Instance method
	 * @param i
	 * @param p
	 */
	private void doProcess(int i, Process p) {
		p.doSomething(i);
	}

	/**
	 * Externalizing the lambda implementation outside static
	 * See what happens when using this here
	 */
	void execute() {
		doProcess(10, i -> {
			System.out.println(i);
			System.out.println(this);
		});
	}

	@Override
	public String toString() {
		return "This is an instance of ThisReferenceExample";
	}
	
}
