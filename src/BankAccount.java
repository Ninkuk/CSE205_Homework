public class BankAccount {

    private int accountNumber;
    private double balance;

    private static int numberOfAccounts;

    public BankAccount() {
        this.accountNumber = 0;
        this.balance = 0;
        numberOfAccounts++;
    }

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        numberOfAccounts++;
    }

    public double depositMoney(double amount) {
        balance += amount;
        return balance;
    }

    public double withdrawMoney(double amount) {
        balance -= amount;
        return balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ",\nbalance: " + balance;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
}
