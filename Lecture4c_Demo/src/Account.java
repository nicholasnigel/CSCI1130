
import javax.swing.JOptionPane;

class Account {
    // no modifier static, these are instance fields
    private String holderName;
    private int    balance;

    // constructor for filling in default Account object information
    public Account()
    {
        holderName = "Unknown";
        balance = 0;
    }
    
    // constructor for filling in initial Account object information
    public Account(String name, int initialBalance)
    {
        this.holderName = name;
        balance = initialBalance;
    }
    
    // no modifier static, this is an instance method
    public void printBalance() {
        JOptionPane.showMessageDialog(null, holderName + "'s Account Balance: $" + balance);
        return;
    }

    // no modifier static, this is an instance method
    public void deposit(int money) {
        JOptionPane.showMessageDialog(null, holderName + " is Depositing $" + money);
        balance += money;
        return;
    }

    /**
     * Withdraw money method
     * has no modifier static, this is an instance method
     * @param money is the amount to be withdrawn
     * @return true on success, false on not enough balance
     */
    public boolean withdraw(int money) {
        if (money > balance)
        {
            JOptionPane.showMessageDialog(null, holderName + " has not enough balance, CANNOT Withdraw $" + money);
            return false;
        }

        JOptionPane.showMessageDialog(null, holderName + " is Withdrawing $" + money + ", new Balance is $" + (balance -= money));
        return true;
    }

    // no modifier static, this is an instance method
    public void transfer(Account receivingAccount, int money) {
        if (!withdraw(money))
            JOptionPane.showMessageDialog(null, "Transfer $" + money + " to " + receivingAccount.holderName + "'s Account FAILED!");
        else
            receivingAccount.deposit(money);
        return;
    }
    
    // the beginning of the program
    public static void main(String args[]) {
        
        // create a new Account object for michael
        Account michaelAccount;
        michaelAccount = new Account("Michael", 1000);
        michaelAccount.printBalance();
        michaelAccount.deposit(800);
        michaelAccount.printBalance();
        michaelAccount.withdraw(3000);
        michaelAccount.withdraw(500);


        // create another new Account object for peter
        Account peterAccount;
        peterAccount = new Account("Peter", 350);
        michaelAccount.transfer(peterAccount, 109700);
        michaelAccount.transfer(peterAccount, 450);

        
        // create another new Account object
        Account someAccount;
        someAccount = new Account();
        someAccount.printBalance();

        
        JOptionPane.showMessageDialog(null, "The program finished!");
        return;
    }
}