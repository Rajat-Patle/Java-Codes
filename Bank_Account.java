import java.util.Scanner;

class ATM {
          String name, acc_no;
          int phone_no;
          int balance = 0;
          int amt = 0;
          Scanner S = new Scanner(System.in);
          

    ATM() {
        System.out.println("Enter Name:");
        name = S.next();
        System.out.println("Enter your account Number:");
        acc_no = S.next();
        System.out.println("Enter your Phone Number:");
        phone_no = S.nextInt();
        System.out.println("Enter your Balance:");
        balance = S.nextInt();
    }

    void withdraw() {
        System.out.print("Enter the Amount you want to Withdraw: ");
        amt = S.nextInt();
        if(balance == 0)
        {
          System.out.println("Your Bank Account is Empty!!");
        }
        if (amt > balance) {
            System.out.println("You have 'Insufficient Balance' Go to Deposit!");
            deposit();
        } else {
            balance -= amt;
            System.out.println("Withdrawal Done Successfully!!");
        }
    }

    void deposit() {
        System.out.print("Enter the Amount you want to Deposit: ");
        amt = S.nextInt();
        balance += amt;
        System.out.println("Deposit Done Successfully");
    }

    void checkBalance() {
          if(balance == 0)
        {
          System.out.println("Your Bank Account is Empty!!");
        }
        System.out.println("The Current Balance is: " + balance);
    }
}

class Bank_Account extends ATM {
    public static void main(String[] args) {
        Bank_Account B = new Bank_Account();
        int choice = 0;
Scanner SC = new Scanner(System.in);
        do {
            System.out.println("Enter Your Choice:\n1. Deposit\n2. Withdraw\n3. Display\n4. Exit");
            choice = SC.nextInt();

            switch (choice) {
                case 1:
                    B.deposit();
                    break;

                case 2:
                    B.withdraw();
                    break;

                case 3:
                    B.checkBalance();
                    break;

                case 4:
                    System.out.println("Program has been terminated!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        SC.close();
    }
}
