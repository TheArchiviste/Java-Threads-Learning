public class MultipleThreads implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside Thread: " + Thread.currentThread().getName());

        System.out.println("The run method has started!");
        System.out.println("The run method has ended!");
    }

    public static void main(String[] args) {
        Thread thread_1 = new Thread(new MultipleThreads());
        thread_1.start();

        Thread thread_2 = new Thread(new MultipleThreads());
        thread_2.start();
    }
}

// Different output every time we run them !!!