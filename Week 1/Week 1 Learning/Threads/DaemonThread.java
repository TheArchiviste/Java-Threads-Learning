public class DaemonThread implements Runnable{
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
        DaemonThread stoppable = new DaemonThread();

        Thread thread = new Thread(stoppable);
        // When the Main thread exits so will the one we have created.
        thread.setDaemon(true);

        thread.start();
        Thread.sleep(4000);

        System.out.println("Exiting main method");
    }
}
