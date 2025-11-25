package work7bank;

public class BankAccount {
    private double balance;
    public BankAccount() {
        this.balance = 0.0;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存入金额：" + amount + "，当前余额：" + balance);
        } else {
            System.out.println("存款金额必须大于0");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("取出金额：" + amount + "，当前余额：" + balance);
            } else {
                System.out.println("余额不足，无法取款");
            }
        } else {
            System.out.println("取款金额必须大于0");
        }
    }
    public void checkBalance() {
        System.out.println("当前余额：" + balance);
    }
}