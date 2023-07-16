import java.util.Scanner;
import javax.swing.*;

public class BankAccount {
    private String account_number;
    private double amount_withdrawn;
    private double amount_deposited;
    private double balance;

    public BankAccount(String an, double aw, double ad, double b) {
        this.account_number = an;
        this.amount_withdrawn = aw;
        this.amount_deposited = ad;
        this.balance = b;
    }

    public BankAccount() {
    }

    public void setAccount_number(String an) {
        this.account_number = an;
    }

    public String getAccount_number() {
        return this.account_number;
    }

    public void setAmount_withdrawn(double aw) {
        this.amount_withdrawn = aw;
    }

    public double getAmount_withdrawn() {
        return this.amount_withdrawn;
    }

    public void setAmount_deposited(double ad) {
        this.amount_deposited = ad;
    }

    public double getAmount_deposited() {
        return this.amount_deposited;
    }

    public void setBalance(double b) {
        this.balance = b;
    }

    public double getBalance() {
        return this.balance;
    }

    private double calcDeposit(double depositAmount) {
        double sum = balance + depositAmount;
        return sum;
    }

    private double calcWithdraw(double amount_withdrawn) {
        double sum = balance - amount_withdrawn;
        return sum;
    }

    public String toString() {
        String s = "";
        s += "Account_number:" + this.account_number + "/n";
        s += "Amount_withdrawn:" + this.amount_withdrawn + "/n";
        s += "Amount_deposited:" + this.amount_deposited + "/n";
        s += "Balance:" + this.balance + "/n";

        return s;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setBalance(100.00);
        double depositOrWithdraw, depositAmount;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type 0 to deposit or 1 to withdraw");
        depositOrWithdraw = keyboard.nextDouble();

        try {
            if (depositOrWithdraw == 0) {

                System.out.println("Enter amount you wish to deposit here: ");
                double amount_deposited = keyboard.nextDouble();
                if (account1.amount_deposited == 0) {
                    throw new InvalidAmountException();
                } else if (amount_deposited < 0) {
                    throw new DepositNegativeException();
                } else {
                    account1.calcDeposit(amount_deposited);
                    System.out.print("New Balance: " + account1);
                    System.exit(0);
                }
            } else {
                System.out.println("Enter the amount you would like to withdraw here: ");
                double amount_withdrawn = keyboard.nextDouble();
                if (account1.amount_withdrawn == 0) {
                    throw new InvalidAmountException();
                } else if (amount_withdrawn > account1.amount_withdrawn) {
                    throw new IllegalArgumentException();
                } else if (amount_withdrawn < 0) {
                    throw new DepositNegativeException();
                } else {

                    account1.calcWithdraw(amount_withdrawn);
                    System.out.println("Your new Balance" + account1);
                    System.exit(0);
                }
            }
        } catch (InvalidAmountException e) {
            System.out.println("You have zero Balance");
        } catch (IllegalArgumentException e) {
            System.out.println("You currently do not have enough to withdraw");
        } catch (DepositNegativeException e) {
            System.out.println("You can not withdraw an amount below zero");
        }
    }
}