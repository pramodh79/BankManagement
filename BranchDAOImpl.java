import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class BranchDAOImpl implements BranchDAO {
    Scanner sc = new Scanner(System.in);
    PreparedStatement ps =null;
    Connection con = DaUtil.getConnection();
    List<Branch> Branches = null;

    public void AddBranchDetails() {
        int i =1;
        while (i==1){
            try {
                ps = con.prepareStatement(BranchQuery.Insert_Query);
                System.out.println("Enter Branch id");
                String Branch = sc.next();
                while(!Pattern.matches("[0-9]{2}",Branch)){
                    System.err.println("Enter valid Branch ID num");
                    Branch = sc.next();
                }int BrID = Integer.parseInt(Branch);
                ps.setInt(1,BrID);
                System.out.println("Enter Branch name");
                String BName = sc.next();
                while(!Pattern.matches("[A-Za-z]+",BName)){
                    System.err.println("Enter valid Branch Name");
                    BName = sc.next();
                }
                ps.setString(2,BName);
                System.out.println("Enter IFSC code");
                String p=sc.next();
                while(!Pattern.matches("\\w{11}",p)){
                    System.err.println("Enter valid IFSC number Should BE 11");
                    p=sc.next();
                }
                ps.setString(3,p);
                System.out.println("Enter City");
                String K = sc.next();
                while(!Pattern.matches("\\w+",K)){
                    System.err.println("Enter valid  name");
                    K=sc.next();
                }
                ps.setString(4,K);
                ps.setString(5,"Active");
                int n=ps.executeUpdate();
                if(n!=0){
                    System.out.println("one Branch is updated");
                }else{
                    System.out.println("not inserted");
                }
                System.out.println("Do you want to insert more Branches if 1 or any");
                String Choice = sc.next();
                while(!Pattern.matches("[0-9]{1}",Choice)){
                    System.err.println("Enter number");
                    Choice = sc.next();
                }i = Integer.parseInt(Choice);
                 i = sc.nextInt();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Branch ViewBranchDetails(int BID) {
        Branch b = new Branch();
        try {
            ps =con.prepareStatement(BranchQuery.View_Query);
            ps.setInt(1,BID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                b.setBID(rs.getInt(1));
                b.setBranchName(rs.getString(2));
                b.setIFSCCode(rs.getString(3));
                b.setCity(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return b;
    }

    public List<Branch> ViewAllBranchDetails() {
        Branches = new ArrayList<Branch>();
        Branch br = null;
        try {
            ps= con.prepareStatement(BranchQuery.ViewAll_Query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                br = new Branch();
                br.setBID(rs.getInt(1));
                br.setBranchName(rs.getString(2));
                br.setIFSCCode(rs.getString(3));
                br.setCity(rs.getString(4));
                Branches.add(br);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return Branches;
    }

    public void UpdateBranchDetalis(int BID) {
        int n=0;
        System.out.println("Select 1)BranchName 2)IFSCCODE 3)City");
        int choice = sc.nextInt();
        try {
            switch (choice){
                case 1:
                    ps = con.prepareStatement(BranchQuery.Update_Branch);
                    System.out.println("Enter Branchname to be updated ");
                    String BName = sc.next();
                    while(!Pattern.matches("[A-Za-z]+",BName)){
                        System.err.println("Enter valid Branch Name");
                        BName = sc.next();
                    }
                    ps.setString(1,BName);
                    ps.setInt(2,BID);
                    n = ps.executeUpdate();
                    if(n!=0){
                        System.out.println("Successfully updated");
                    }else{
                        System.out.println("not updated");
                    }
                    break;
                case 2:
                    ps=con.prepareStatement(BranchQuery.Update_IFSC);
                    System.out.println("Enter IFSCcode to be updated");
                    String p=sc.next();
                    while(!Pattern.matches("\\w{11}",p)){
                        System.err.println("Enter valid IFSC num");
                        p=sc.next();
                    }
                    ps.setString(1,p);
                    ps.setInt(2,BID);
                    n=ps.executeUpdate();
                    if(n!=0){
                        System.out.println("Successfully updated");
                    }else{
                        System.out.println("not updated");
                    }
                case 3:
                    ps = con.prepareStatement(BranchQuery.Update_CITY);
                    System.out.println("Enter City to be updated");
                    String K = sc.next();
                    while(!Pattern.matches("\\D+",K)){
                        System.err.println("Enter valid City name");
                        K=sc.next();
                    }
                    ps.setString(1,K);
                    ps.setInt(2,BID);
                    n=ps.executeUpdate();
                    if(n!=0){
                        System.out.println("Successfully updated");
                    }else{
                        System.out.println("not updated");
                    }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    public void Delete(int BID) {
        try {
            ps = con.prepareStatement(BranchQuery.Delete);
            ps.setInt(1, BID);
            int n = ps.executeUpdate();
            if(n!=0){
                System.out.println("Successfully Deleted");
            }else{
                System.out.println("not Deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }



    public void Back() {
        BankManagementSystem.main(null);

    }
}
