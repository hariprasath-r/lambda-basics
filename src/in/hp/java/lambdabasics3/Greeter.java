package in.hp.java.lambdabasics3;

public class Greeter {

    private void greet(Greeting greeting) {
        greeting.performGreeting();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        Greeting helloWorldGreeting = new Greeting() {
            @Override
            public void performGreeting() {
                System.out.println("Hello World from Inner Class!!!");
            }
        };
        greeter.greet(helloWorldGreeting);
    }
}
