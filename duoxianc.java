public class duoxianc {
    public static void main(String[] args) {
        // 线程1：1 到 10
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i);
            }
        }).start();
    
        // 线程2：A 到 J
        new Thread(() -> {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.print(c);
            }
        }).start();
    }
}