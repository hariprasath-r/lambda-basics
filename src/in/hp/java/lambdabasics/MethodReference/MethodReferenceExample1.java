package in.hp.java.lambdabasics.MethodReference;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		Thread t = new Thread(() -> printMessage());
		t.start();
		
		/*
		 * Replacing the above lambda expression with Method Reference
		 * 1. Since the lambda expression takes in no arg and calls a method with no arg
		 * 		We can replace it with the below Method Reference
		 * 
		 * () -> method() === Classname::method()
		 */
		Thread t1 = new Thread(MethodReferenceExample1::printMessage);
		t1.start();
	}

	static void printMessage() {
		System.out.println("Hello.!");
	}
}
