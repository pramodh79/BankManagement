import java.util.Scanner;
import java.util.regex.Pattern;

public class TransactionDetails {
    static TransactionDAOImpl impl = new TransactionDAOImpl();
    static Scanner sc = new Scanner(System.in);
    public static void Atm(){
        System.out.println("|-------------------------------|");
        System.out.println("|            ATM                |");
        System.out.println("|-------------------------------|");
        System.out.println("|     1.CHECK BALANCE           |");
        System.out.println("|     2.DEPOSIT                 |");
        System.out.println("|     3.WITHDRAW                |");
        System.out.println("|     4.TRANSFER                |");
        System.out.println("|     5.BACK                    |");
        System.out.println("|-------------------------------|");
        System.out.println("enter your choice");
        String Choice = sc.next();
        while(!Pattern.matches("[0-9]{1}",Choice)){
            System.err.println("Enter valid number");
            Choice = sc.next();
        }int C = Integer.parseInt(Choice);
        switch (C){
            case 1:
                System.out.println("Enter Customer ID");
                String CID = sc.next();
                while(!Pattern.matches("[0-9]{3}",CID)){
                    System.err.println("Enter valid Customer ID num");
                    CID = sc.next();
                }int ID = Integer.parseInt(CID);
                impl.Balance(ID);
                Atm();
                break;
            case 2:
                System.out.println("Enter  Customer ID For Deposit");
                String IID = sc.next();
                while(!Pattern.matches("[0-9]{3}",IID)){
                    System.err.println("Enter valid Customer ID num");
                    IID = sc.next();
                }int I = Integer.parseInt(IID);
                impl.Deposit(I);
                Atm();
                break;
            case 3:
                System.out.println("Enter Customer ID for Withdraw");
                String iID = sc.next();
                while(!Pattern.matches("[0-9]{3}",iID)){
                    System.err.println("Enter valid Customer ID num");
                    iID = sc.next();
                }int D = Integer.parseInt(iID);
                impl.WithDrawAmount(D);
                Atm();
                break;
            case 4:
                System.out.println("Enter 1. From Account(CID) 2. To Account(CID) 3. Transfer Amount");
                impl.Transfer(sc.nextInt(),sc.nextInt(),sc.nextDouble());
                break;
            case 5:
                impl.Back();
            default:
                System.out.println("Enter Ranging From 1-5");

        }

    }
}
