import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample1 implements Runnable{
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            addToCounter(1);
        }
        System.out.println("Final Counter: " + Thread.currentThread().getName() + " " + counter);
    }

    private void addToCounter(int amount) {
        if (amount >= 0) {
            try {
                lock.lock();
                counter += amount;
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockExample1 runnable = new LockExample1();

        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);

        thread_1.start();
        thread_2.start();
    }
}
