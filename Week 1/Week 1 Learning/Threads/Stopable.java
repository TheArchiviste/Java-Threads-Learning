// Alternative method for stopping threads instead of using the stop() method.

public class Stopable implements Runnable{
    private boolean stopped = false;

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped() {
        this.stopped = true;
    }

    @Override
    public void run() {
        System.out.println("The run method has started!");

        while(!stopped) {
            System.out.println("Executing the run method.");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The run method has ended!");
    }

    public static void main(String[] args) throws InterruptedException{
        Stopable stopable = new Stopable();

        Thread thread = new Thread(stopable);

        thread.start();

        Thread.sleep(5000);

        stopable.setStopped();

        System.out.println("Exiting the main method!");
    }
}
