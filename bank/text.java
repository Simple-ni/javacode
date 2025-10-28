package bank;

import java.util.Scanner;

public class text {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("初始金额：");
        BankAccount acc = new BankAccount(sc.nextDouble());

        System.out.print("存款：");
        acc.deposit(sc.nextDouble());

        System.out.print("取款：");
        boolean ok = acc.withdraw(sc.nextDouble());
        System.out.println(ok ? "取款成功" : "余额不足");

        System.out.println("当前余额：" + acc.getBalance());
        sc.close();
    }
}
