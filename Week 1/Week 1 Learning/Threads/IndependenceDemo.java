public class IndependenceDemo implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("The run method has started!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        IndependenceDemo stoppable = new IndependenceDemo();

        Thread thread = new Thread(stoppable);

        thread.start();
        Thread.sleep(4000);

        System.out.println("Exiting main method");
    }
}
