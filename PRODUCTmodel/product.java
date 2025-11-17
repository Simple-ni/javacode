package PRODUCTmodel;
public class product {

    /* ---------------- 共享缓冲区 ---------------- */
    private static final int CAPACITY = 5;
    private static final int[] buffer = new int[CAPACITY];
    private static int count = 0;          // 当前元素个数

    /* ================= 生产者 ================= */
    static class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {          // 生产 10 个
                synchronized (buffer) {
                    while (count == CAPACITY) {      // 满则等待
                        try { buffer.wait(); }
                        catch (InterruptedException e) { return; }
                    }
                    buffer[count++] = i;
                    System.out.println("Producer 放入 " + i + "  缓冲区数量=" + count);
                    buffer.notify();                 // 唤醒一个等待的线程
                }
            }
        }
    }

    /* ================= 消费者 ================= */
    static class Consumer extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {          // 消费 10 个
                synchronized (buffer) {
                    while (count == 0) {             // 空则等待
                        try { buffer.wait(); }
                        catch (InterruptedException e) { return; }
                    }
                    int val = buffer[--count];
                    System.out.println("Consumer 取出 " + val + "  缓冲区数量=" + count);
                    buffer.notify();                 // 唤醒一个等待的线程
                }
            }
        }
    }

    /* ---------------- main ---------------- */
    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }
}