import java.util.Scanner;
import java.util.regex.Pattern;

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("|-------------------------------|");
            System.out.println("|    BANK MANAGEMENT SYSTEM     |");
            System.out.println("|-------------------------------|");
            System.out.println("|     1.ADMIN MENU              |");
            System.out.println("|     2.CUSTOMER TRANSACTIONS   |");
            System.out.println("|     3.EXIT                    |");
            System.out.println("|-------------------------------|");
            System.out.println("enter your choice");
            String Choice = sc.next();
            while(!Pattern.matches("[0-9]{1}",Choice)){
                System.err.println("Enter valid number");
                Choice = sc.next();
            }int C = Integer.parseInt(Choice);
            switch (C){

                case 1:
                    AdminDetails.AdminMenu();
                    break;
                case 2:
                    TransactionDetails.Atm();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Select only from 1-3");
            }
        }
    }
}
