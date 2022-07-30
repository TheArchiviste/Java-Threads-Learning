public class SynchronizedBlock implements Runnable{
    private int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            addToCounter(1);
        }
        System.out.println("Final Counter: " + Thread.currentThread().getName() + " " + counter);
    }

    private void addToCounter(int amount) {
        if (amount >= 0) {
            synchronized(this) {
                counter += amount;
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedBlock runnable = new SynchronizedBlock();

        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);

        thread_1.start();
        thread_2.start();
    }
}
