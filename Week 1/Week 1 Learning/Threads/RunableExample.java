public class RunableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("The run method has started!");
        System.out.println("The run method has ended!");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunableExample());

        thread.start();
    }
}
