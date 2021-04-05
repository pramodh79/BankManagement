import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BranchDetails {
    static Scanner sc=new Scanner(System.in);
    static BranchDAOImpl BranchDao=new BranchDAOImpl();
    public static void Branchmenu(){
        while (true){
            System.out.println("|-------------------------------|");
            System.out.println("|       BRANCH MAIN MENU        |");
            System.out.println("|-------------------------------|");
            System.out.println("|    1.ADD BRANCH               |");
            System.out.println("|    2.VIEW BRANCH              |");
            System.out.println("|    3.VIEW ALL BRANCHES        |");
            System.out.println("|    4.UPDATE BRANCH            |");
            System.out.println("|    5.DELETE BRANCH            |");
            System.out.println("|    6.BACK                     |");
            System.out.println("|-------------------------------|");
            String Choice = sc.next();
            while(!Pattern.matches("[0-9]{1}",Choice)){
                System.err.println("Enter valid number");
                Choice = sc.next();
            }int C = Integer.parseInt(Choice);
            switch (C){
                case 1:
                    BranchDao.AddBranchDetails();
                    Branchmenu();
                    break;
                case 2:
                    System.out.println("enter the branch id BID");
                    String BID = sc.next();
                    while(!Pattern.matches("[0-9]{2}",BID)){
                        System.err.println("Enter valid Branch ID num");
                        BID = sc.next();
                    }int ID = Integer.parseInt(BID);
                    Branch branch=BranchDao.ViewBranchDetails(ID);
                    System.out.println(branch);
                    Branchmenu();
                    break;
                case 3:
                    List<Branch> Branches=BranchDao.ViewAllBranchDetails();
                    for (Branch b:Branches) {
                        System.out.println(b);
                    }
                    Branchmenu();
                    break;
                case 4:
                    System.out.println("which branch do you want to update");
                    String iID = sc.next();
                    while(!Pattern.matches("[0-9]{2}",iID)){
                        System.err.println("Enter valid Branch ID num");
                        iID = sc.next();
                    }int iD = Integer.parseInt(iID);
                    BranchDao.UpdateBranchDetalis(iD);
                    Branchmenu();
                    break;
                case 5:
                    System.out.println("which branch do you want to delete");
                    String D = sc.next();
                    while(!Pattern.matches("[0-9]{2}",D)){
                        System.err.println("Enter valid Branch ID num");
                        D = sc.next();
                    }int dD = Integer.parseInt(D);
                    BranchDao.Delete(dD);
                    Branchmenu();
                    break;
                case 6:BranchDao.Back();
                    break;

                default:System.out.println("enter ranging from 1-5");
            }
        }
    }
}
