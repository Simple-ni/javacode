package SimpleBankArrangeSystem32;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class BankTest {
    private static final Map<String, Account> accounts = new HashMap<>();
    private static final String FILE = "accounts.txt";
    private static final Scanner sc = new Scanner(System.in);
    private static final ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        loadAccounts(); // 启动即读
        int opt;
        do {
            System.out.print("\n1-开户 2-存款 3-取款 4-查询 5-并发测试 6-保存 0-退出\n选择：");
            opt = sc.nextInt();
            sc.nextLine(); // 吞换行
            switch (opt) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: query(); break;
                case 5: concurrentTest(); break;
                case 6: saveAccounts(); break;
                case 0: System.out.println("已退出！"); break;
                default: System.out.println("无效选择！");
            }
        } while (opt != 0);
        pool.shutdown();
    }

    /* 1. 开户 */
    private static void createAccount() {
        System.out.print("账户ID 用户名 初始余额：");
        String id = sc.next();
        String name = sc.next();
        double balance = sc.nextDouble();
        accounts.put(id, new Account(id, name, balance));
        System.out.println("开户成功！");
    }

    /* 2. 存款 */
    private static void deposit() {
        System.out.print("账户ID 存款金额：");
        String id = sc.next();
        double amount = sc.nextDouble();
        Account acc = accounts.get(id);
        if (acc == null) { System.out.println("账户不存在！"); return; }
        acc.deposit(amount);
        System.out.println("存款成功！当前余额：" + acc.getBalance());
    }

    /* 3. 取款 */
    private static void withdraw() {
        System.out.print("账户ID 取款金额：");
        String id = sc.next();
        double amount = sc.nextDouble();
        Account acc = accounts.get(id);
        if (acc == null) { System.out.println("账户不存在！"); return; }
        if (acc.withdraw(amount)) {
            System.out.println("取款成功！当前余额：" + acc.getBalance());
        } else {
            System.out.println("余额不足或金额非法！");
        }
    }

    /* 4. 查询 */
    private static void query() {
        System.out.print("账户ID：");
        String id = sc.next();
        Account acc = accounts.get(id);
        System.out.println(acc == null ? "账户不存在！" : acc.toString());
    }

    /* 5. 并发测试 */
    private static void concurrentTest() {
        System.out.print("测试账户ID：");
        String id = sc.next();
        Account acc = accounts.get(id);
        if (acc == null) { System.out.println("账户不存在！"); return; }
        // 10 线程，每人存 10 次 10 元
        for (int i = 0; i < 10; i++) {
            pool.submit(() -> {
                for (int j = 0; j < 10; j++) acc.deposit(10);
            });
        }
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("并发测试完成！当前余额：" + acc.getBalance());
    }

    /* 6. 保存账户（UTF-8 文本，一行一个） */
    private static void saveAccounts() {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(FILE), "UTF-8"))) {
            for (Account a : accounts.values()) {
                pw.printf("%s,%s,%.2f%n", a.getAccountId(), a.getUserName(), a.getBalance());
            }
            System.out.println("已保存到 " + FILE);
        } catch (IOException e) {
            System.out.println("保存失败：" + e.getMessage());
        }
    }

    /* 7. 加载账户（UTF-8 文本） */
    private static void loadAccounts() {
        File f = new File(FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                accounts.put(arr[0], new Account(arr[0], arr[1], Double.parseDouble(arr[2])));
            }
        } catch (IOException e) {
            System.out.println("加载失败：" + e.getMessage());
        }
    }
}