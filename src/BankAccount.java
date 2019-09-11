public class BankAccount {
    private int accountNumber;
    private int balance;

    private static int numberOfAccounts = 0;

    public BankAccount() {
        this.accountNumber = 0;
        this.balance = 0;
        numberOfAccounts++;
    }

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        numberOfAccounts++;
    }

    public void depositMoney(int amount) {
        this.balance += amount;
    }

    public int withdrawMoney(int amount) {
        this.balance -= amount;
        return amount;
    }
}
