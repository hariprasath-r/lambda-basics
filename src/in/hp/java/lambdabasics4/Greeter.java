package in.hp.java.lambdabasics4;

public class Greeter {

    private void greet(Greeting greeting) {
        greeting.performGreeting();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        /*
         * Below is a lambda expression which matches the functional interface "Greeting"
         */
        Greeting lambdaGreeting =  () -> System.out.println("Hello World from Lambda Expression!!!");
        greeter.greet(lambdaGreeting);
    }
}