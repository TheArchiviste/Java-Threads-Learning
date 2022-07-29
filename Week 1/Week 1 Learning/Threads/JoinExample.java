public class JoinExample implements Runnable{
    private float result;

    @Override
    public void run() {
        float temp = 0.0f;
        float inc = 0.001f;

        for (int i = 0; i < 1000; i++) {
            temp += inc;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = temp;
    }

    public float getResult() {
        return result;
    }

    public static void main(String[] args) throws InterruptedException{
        JoinExample runnable = new JoinExample();
        Thread thread = new Thread(runnable);

        thread.start();

        System.out.println("Waiting for thread to terminate!");

        thread.join();

        System.out.println("The result is: " + runnable.getResult());

        System.out.println("Thread has terminated!");
    }
}
