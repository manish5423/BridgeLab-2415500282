public class BackgroundJobExecutor {
    public static void main(String[] args){
        Runnable backgroundTask = () -> {
            try{
                for(int i=1;i<=3;i++){
                    System.out.println("Background task step " + i);
                    Thread.sleep(300);
                }
                System.out.println("Background task completed");
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };
        Thread worker = new Thread(backgroundTask, "worker-thread");
        worker.start();
        try{
            worker.join();
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Main finished after background job");
    }
}
