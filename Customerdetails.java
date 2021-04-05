
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Customerdetails {
    static Scanner sc=new Scanner(System.in);
    static CustomerDAOImpl customerDao=new CustomerDAOImpl();
    public static void Customermenu(){
        while (true){
            System.out.println("|---------------------------------|");
            System.out.println("|       CUSTOMER MAIN MENU        |");
            System.out.println("|---------------------------------|");
            System.out.println("|    1.ADD CUSTOMER               |");
            System.out.println("|    2.VIEW CUSTOMER              |");
            System.out.println("|    3.VIEW ALL CUSTOMERS         |");
            System.out.println("|    4.UPDATE CUSTOMER            |");
            System.out.println("|    5.DELETE CUSTOMER            |");
            System.out.println("|    6.BACK                       |");
            System.out.println("|---------------------------------|");
            String Choice = sc.next();
            while(!Pattern.matches("[0-9]{1}",Choice)){
                System.err.println("Enter valid number");
                Choice = sc.next();
            }int C = Integer.parseInt(Choice);
            switch (C){
                case 1:
                    customerDao.AddCustomerDetails();

                    break;
                case 2:
                    System.out.println("Enter the customer id CID");
                    String IID = sc.next();
                    while(!Pattern.matches("[0-9]{3}",IID)){
                        System.err.println("Enter valid Customer ID num");
                        IID = sc.next();
                    }int I = Integer.parseInt(IID);
                    Customer customer=customerDao.ViewCustomerDetails(I);
                    System.out.println(customer);
                    Customermenu();
                    break;
                case 3:
                    List<Customer> customers=customerDao.ViewAllCustomerDetails();
                    for (Customer c:customers) {
                        System.out.println(c);
                    }
                    Customermenu();
                    break;
                case 4:
                    System.out.println("which Customer do you want to update");
                    String ID = sc.next();
                    while(!Pattern.matches("[0-9]{3}",ID)){
                        System.err.println("Enter valid Customer ID num");
                        ID = sc.next();
                    }int Ii = Integer.parseInt(ID);
                    customerDao.UpdateCustomerDetalis(Ii);
                    Customermenu();
                    break;
                case 5:
                    System.out.println("which Customer do you want to delete");
                    String iD = sc.next();
                    while(!Pattern.matches("[0-9]{3}",iD)){
                        System.err.println("Enter valid Customer ID num");
                        iD = sc.next();
                    }int ii = Integer.parseInt(iD);
                    customerDao.DeleteCustomer(ii);
                    Customermenu();
                    break;
                case 6:customerDao.Back();
                    break;

                default:System.out.println("enter ranging from 1-6");
            }
        }
    }
}
