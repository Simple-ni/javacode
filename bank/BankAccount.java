package bank;

public class BankAccount {
    private double balance;
   public BankAccount(){

   }
   public BankAccount(double balance){
     this.balance = balance < 0 ? 0 : balance;

   }
   public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

}
