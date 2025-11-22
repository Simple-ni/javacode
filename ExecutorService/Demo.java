package ExecutorService;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        int core = 3;   // 池大小
        ExecutorService pool = Executors.newFixedThreadPool(core);

        // 提交 10 个任务
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName()
                        + " 正在执行任务 " + taskId);
                try {
                    Thread.sleep(500); // 模拟耗时
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdown(); // 不再接受新任务
        // 等待所有任务完成
        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
        System.out.println("所有任务执行完毕！");
    }
}