// 当前文件所在包名（包声明必须放在最上面）
package DUOXIAN12;

/**
 * 主类：负责启动两个线程
 * 线程1：NumberThread 打印 1~10
 * 线程2：LetterTask   打印 A~J
 */
public class duoxiancheng {
    public static void main(String[] args) {
        // 创建并启动数字线程（继承 Thread 的方式）
        new NumberThread().start();

        // 创建并启动字母线程（实现 Runnable 的方式）
        new Thread(new LetterTask()).start();
    }
}

/**
 * 方式一：继承 Thread
 * 在 run() 中打印 1 到 10，每打印一次休眠 90 毫秒
 */
class NumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            // 让线程暂停 90 ms，主动让出 CPU，方便观察交替效果
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                // 休眠被中断时打印异常栈（简单示例，直接打印）
                e.printStackTrace();
            }
        }
    }
}

/**
 * 方式二：实现 Runnable
 * 在 run() 中打印 A 到 J，每打印一次休眠 100 毫秒
 */
class LetterTask implements Runnable {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.println("Letter: " + c);
            // 让线程暂停 100 ms，主动让出 CPU，方便观察交替效果
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // 同样简单处理中断异常
                e.printStackTrace();
            }
        }
    }
}