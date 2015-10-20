class threadCom implements Runnable{
 
    public static int myCount = 0;
    public threadCom(){
         
    }
    public void run() {
        while(threadCom.myCount <= 10){
            try{
                System.out.println(">>Thread: "+(++threadCom.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    } 
}
public class RunMyThread {
    public static void main(String a[]){
        System.out.println("Main Thread Start:");
        threadCom mrt = new threadCom();
        Thread t = new Thread(mrt);
        t.start();
        while(threadCom.myCount <= 10){
            try{
                System.out.println("Main Thread: "+(++threadCom.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("Main Thread Ended");
    }
}