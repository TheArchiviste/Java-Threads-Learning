public class SynchronizedMethod implements Runnable {
    private int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            incCounter();
        }
        System.out.println("Final Counter: " + Thread.currentThread().getName() + " " + counter);
    }

    private synchronized void incCounter(){
        counter++;
    }

    public static void main(String[] args) {
        SynchronizedMethod runnable = new SynchronizedMethod();

        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);

        thread_1.start();
        thread_2.start();
    }
}