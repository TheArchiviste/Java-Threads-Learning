public class MemoryDemoRaceCondition implements Runnable{
    private int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter++;
        }
        System.out.println(Thread.currentThread().getName() + " " + counter);
    }

    public static void main(String[] args) {
        MemoryDemoRaceCondition runable_1 = new MemoryDemoRaceCondition();

        Thread thread_1 = new Thread(runable_1);
        Thread thread_2 = new Thread(runable_1);

        thread_1.start();
        thread_2.start();
    }
}
