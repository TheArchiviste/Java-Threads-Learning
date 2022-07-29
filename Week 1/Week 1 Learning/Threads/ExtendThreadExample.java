public class ExtendThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("The run method has started!");
        System.out.println("The run method has ended!");
    }

    public static void main(String[] args) {
        ExtendThreadExample thread = new ExtendThreadExample();

        thread.start();
    }
}