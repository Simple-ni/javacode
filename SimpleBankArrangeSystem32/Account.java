package SimpleBankArrangeSystem32;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String accountId;
    private final String userName;
    private double balance;

    public Account(String accountId, String userName, double balance) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = balance;
    }

    public String getAccountId() { return accountId; }
    public String getUserName() { return userName; }
    public double getBalance() { return balance; }

    // 线程安全存款
    public synchronized void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    // 线程安全取款
    public synchronized boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("ID:%s 用户名:%s 余额:%.2f", accountId, userName, balance);
    }
}