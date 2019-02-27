package in.hp.java.lambdabasics1;

public class Greeter {

    private void greet() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.greet();
    }
}
