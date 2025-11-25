package work17PRODUCTmodel;
public class product {

  
    private static final int CAPACITY = 5;
    private static final int[] buffer = new int[CAPACITY];
    private static int count = 0;         

    static class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {          
                synchronized (buffer) {
                    while (count == CAPACITY) {      
                        try { buffer.wait(); }
                        catch (InterruptedException e) { return; }
                    }
                    buffer[count++] = i;
                    System.out.println("Producer 放入 " + i + "  缓冲区数量=" + count);
                    buffer.notify();           
                }
            }
        }
    }

 
    static class Consumer extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {          
                synchronized (buffer) {
                    while (count == 0) {             
                        try { buffer.wait(); }
                        catch (InterruptedException e) { return; }
                    }
                    int val = buffer[--count];
                    System.out.println("Consumer 取出 " + val + "  缓冲区数量=" + count);
                    buffer.notify();                 
                }
            }
        }
    }


    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }
}