package bank;

public class test {
    public static void main(String[] args) {
        // 创建银行账户对象
        BankAccount account = new BankAccount();

        // 调用存款方法
        account.deposit(1000);

        // 调用取款方法
        account.withdraw(500);

        // 调用查看余额方法
        account.checkBalance();
    }
}