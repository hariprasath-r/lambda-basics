package in.hp.java.lambdabasics2;

public class HelloWorldGreeting implements Greeting {
    @Override
    public void performGreeting() {
        System.out.println("Hello World!");
    }
}
