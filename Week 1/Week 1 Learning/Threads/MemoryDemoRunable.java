public class MemoryDemoRunable implements Runnable{
    private int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter++;
        }
        System.out.println(Thread.currentThread().getName() + " " + counter);
    }

    public static void main(String[] args) {
        MemoryDemoRunable runable_1 = new MemoryDemoRunable();
        Thread thread_1 = new Thread(runable_1);

        MemoryDemoRunable runable_2 = new MemoryDemoRunable();
        Thread thread_2 = new Thread(runable_2);

        thread_1.start();
        thread_2.start();
    }
}
