public class LambdaExample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("The run method has started!");
            System.out.println("The run method has ended!");
        };

        Thread thread = new Thread(runnable);

        thread.start();
    }
}
