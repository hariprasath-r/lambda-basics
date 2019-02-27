package in.hp.java.lambdabasics2;

public class Greeter {

    private void greet(Greeting greeting) {
        greeting.performGreeting();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
        greeter.greet(helloWorldGreeting);
    }
}
