import java.util.Scanner;

class BankAcc {
    private double bal;

    public BankAcc(double initbal) {
        this.bal = initbal;
    }

    public double getBal() {
        return bal;
    }

    public void deposit(double amount) {
        bal += amount;
        System.out.println("Deposit successful. New balance: $" + bal);
    }

    public boolean withdraw(double amount) {
        if (amount <= bal) {
            System.out.println("Confirm? (Y/N)");
            Scanner sc = new Scanner(System.in);
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                bal -= amount;
                System.out.println("Collect the Cash $"+ amount);
                System.out.println("Withdrawal successful. New balance: $" + bal);
                return true;
            } 
            else {
                System.out.println("Withdrawal cancelled.");
                return false;
            }
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}


class ATM {
    private BankAcc useracc;

    public ATM(BankAcc useracc) {
        this.useracc = useracc;
    }

    public void display() {
        System.out.println("\n1. View Available Balance\n2. Deposit Amount\n3. Withdraw Amount\n4. Exit");
        System.out.print("Enter Choice: ");
    }

    public void checkBalance() {
        System.out.println("Loading Account Balance...");
        System.out.println("Current balance: $" + useracc.getBal());
    }

    public void deposit(double amount) {
        useracc.deposit(amount);
    }

    public void withdraw(double amount) {
        useracc.withdraw(amount);
    }
}


public class Machine{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAcc useracc = new BankAcc(1000.00);
        ATM atm = new ATM(useracc);
        int atmpin = 123;
        while (true) {
            atm.display();
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter ATM Pin: ");
                    int pin = sc.nextInt();
                    if (atmpin == pin) {
                        System.out.println("Account Authorized.");
                        atm.checkBalance();
                    } else {
                        System.out.println("Incorrect pin.");
                        System.exit(0);
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter ATM Pin: ");
                    pin = sc.nextInt();
                    if (atmpin == pin) {
                        System.out.println("Account Authorized.");
                        System.out.print("Enter deposit amount: $");
                        double amount = sc.nextDouble();
                        atm.deposit(amount);
                    } else {
                        System.out.println("Incorrect pin.");
                        System.exit(0);
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter ATM Pin: ");
                    pin = sc.nextInt();
                    if (atmpin == pin) {
                        System.out.println("Account Authorized.");
                        System.out.print("Enter withdrawal amount: $");
                        double amount = sc.nextDouble();
                        atm.withdraw(amount);
                    } else {
                        System.out.println("Incorrect pin.");
                        System.exit(0);
                    }
                    break;
                    
                case 4:
                    System.out.println("Please collect your ATM Card. Thank you for banking with us.");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Please enter a valid choice.");
            }
        }
    }
}
