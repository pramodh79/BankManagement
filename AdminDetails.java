import java.util.Scanner;

public class AdminDetails {
    static Scanner sc = new Scanner(System.in);
   static BranchDetails dt = new BranchDetails();
   static Customerdetails ct = new Customerdetails();

public static void AdminMenu(){
    System.out.println("|-------------------------------|");
    System.out.println("|      ADMIN OPERATIONS         |");
    System.out.println("|-------------------------------|");
    System.out.println("|     1.BRANCH MENU             |");
    System.out.println("|     2.CUSTOMER MENU           |");
    System.out.println("|     3.BACK                    |");
    System.out.println("|-------------------------------|");
    System.out.println("enter your choice");
    int choice =sc.nextInt();
    switch (choice){
        case 1:
            dt.Branchmenu();
            AdminMenu();
            break;
        case 2:
            ct.Customermenu();
            AdminMenu();
            break;
        case 3:
            BankManagementSystem.main(null);
            break;

    }

}
}
