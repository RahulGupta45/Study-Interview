public class MyThread extends Thread{
    Display display;
    String thread1;

    public MyThread(Display display, String thread1) {
        this.display = display;
        this.thread1 = thread1;
    }

    public void run(){
        for(int i=0;i<10;i++) {
            display.wish(thread1);
        }
    }

}
