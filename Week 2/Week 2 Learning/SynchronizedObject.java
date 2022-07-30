public class SynchronizedObject implements Runnable{
    private Counter counter;

    public SynchronizedObject(Counter c) {
        counter = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            synchronized(counter) {
                counter.incCounter();
            }
        }
        System.out.println("Final Counter: " + Thread.currentThread().getName() + " " + counter);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        SynchronizedObject runnable_1 = new SynchronizedObject(counter);
        SynchronizedObject runnable_2 = new SynchronizedObject(counter);

        Thread thread_1 = new Thread(runnable_1);
        Thread thread_2 = new Thread(runnable_2);

        thread_1.start();
        thread_2.start();
    }
}
