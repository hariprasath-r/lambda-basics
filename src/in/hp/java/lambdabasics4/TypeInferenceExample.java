package in.hp.java.lambdabasics4;

public class TypeInferenceExample {

	public static void main(String[] args) {
		/*
		 * When a lambda expression accepts only one input, we can send without paranthesis
		 */
		callSquareNumberLambda(s -> s * s);
	}

	static void callSquareNumberLambda(SquareNumberLambda SquareNumberLambda) {
		System.out.println(SquareNumberLambda.square(4));
	}
	
	/*
	 * The interface type will be infered by Java
	 */
	interface SquareNumberLambda {
		int square(int a);
	}
}
