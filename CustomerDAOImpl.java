import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerDAOImpl implements CustomerDAO {
    Scanner sc =new Scanner(System.in);
    PreparedStatement ps = null;
    List<Customer> Customers = null;
    Connection con =DaUtil.getConnection();


    public void AddCustomerDetails() {
        int n =1;
        while (n==1){
            try {
                ps=con.prepareStatement(CustomerQuery.Insert_Query);
                System.out.println("Enter Customer Number");
                String CI = sc.next();
                while(!Pattern.matches("[0-9]{3}",CI)){
                    System.err.println("Enter valid Customer ID num");
                    CI = sc.next();
                }int CII = Integer.parseInt(CI);
                ps.setInt(1,CII);
                System.out.println("Enter Account Number");
                String c = sc.next();
                while(!Pattern.matches("\\d{16}",c)){
                    System.err.println("Enter valid Account card num Should be 16 Numbers:");
                    c = sc.next();
                }Long AccountNum = Long.parseLong(c);
                ps.setLong(2,AccountNum);
                System.out.println("Enter MobileNumber");
                String phone = sc.next();
                while(!Pattern.matches("\\d{10}",phone)){
                    System.err.println("Enter valid phone num");
                    phone = sc.next();
                }long mobileNum = Long.parseLong(phone);
                ps.setLong(3,mobileNum);
                System.out.println("Enter Customer's FirstName");
                String fname = sc.next();
                while(!Pattern.matches("[A-Za-z]+",fname)){
                    System.err.println("Enter only  char");
                    fname = sc.next();
                }
                ps.setString(4,fname);
                System.out.println("Enter Customer's LastName");
                String lname = sc.next();
                while(!Pattern.matches("[A-Za-z]+",lname)){
                    System.err.println("Enter only char");
                    lname = sc.next();
                }
                ps.setString(5,lname);
                System.out.println("Enter Gender");
                ps.setString(6,sc.next());
                System.out.println("Enter EmailID");
                String em = sc.next();
                while(!Pattern.matches("\\w*+@+[a-z&&gmail]+.+[a-z&&com]",em)){
                    System.err.println("enter valid email id");
                    em = sc.next();
                }
                ps.setString(7,em);
                System.out.println("Enter Address");
                ps.setString(8,sc.next());
                System.out.println("Enter AdharNO");
                String a = sc.next();
                while(!Pattern.matches("\\d{12}",a)){
                    System.err.println("Enter valid Adhar number Should be 12 Numbers");
                    a = sc.next();
                }Long Adhar = Long.parseLong(a);
                ps.setLong(9,Adhar);
                System.out.println("Enter PanNumber");
                String p = sc.next();
                while(!Pattern.matches("\\w{10}",p)){
                    System.err.println("Enter valid pan num Should be 10");
                    p=sc.next();
                }
                ps.setString(10,p);
                System.out.println("Enter AccountType 1.Savings 2.Current");
                String Type = sc.next();
                while(!Pattern.matches("[A-Za-z]{7}",Type)){
                    System.err.println("Enter only Characters");
                    Type = sc.next();
                }
                ps.setString(11,sc.next());
                System.out.println("Enter CustomerNo Should be 10 numbers");
                String CNum = sc.next();
                while(!Pattern.matches("\\d{10}",CNum)){
                    System.err.println("Enter valid Customer num Should be 10 numbers");
                    CNum = sc.next();
                }long CNUM = Long.parseLong(CNum);
                ps.setLong(12,CNUM);
                ps.setString(13,"Active");
                System.out.println("Enter balance");
                ps.setDouble(14,sc.nextDouble());
                System.out.println("Enter BId");
                String Branch = sc.next();
                while(!Pattern.matches("[0-9]{2}",Branch)){
                    System.err.println("Enter valid Branch ID num");
                    Branch = sc.next();
                }int BrID = Integer.parseInt(Branch);
                ps.setInt(15,BrID);
                int k = ps.executeUpdate();
                if(k!=0){
                    System.out.println("One Customer Detail Has been Inserted");
                }else{
                    System.out.println("not inserted");
                }
                System.out.println("Do you want to Add more Customer Details if 1 or any");
                String Choice = sc.next();
                while(!Pattern.matches("[0-9]{1}",Choice)){
                    System.err.println("Enter valid number");
                    Choice = sc.next();
                }n = Integer.parseInt(Choice);
                n = sc.nextInt();
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

    public Customer ViewCustomerDetails(int CID) {
        Customer c = new Customer();
        try {
            ps = con.prepareStatement(CustomerQuery.View_Query);
            ps.setInt(1,CID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                c.setCID(rs.getInt(1));
                c.setAccountNumber(rs.getLong(2));
                c.setMobileNumber(rs.getLong(3));
                c.setFirstName(rs.getString(4));
                c.setLastName(rs.getString(5));
                c.setGender(rs.getString(6));
                c.setEmailId(rs.getString(7));
                c.setAddress(rs.getString(8));
                c.setAdharNo(rs.getLong(9));
                c.setPanNo(rs.getString(10));
                c.setAccountType(rs.getString(11));
                c.setCustomerNo(rs.getLong(12));
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
        return c;
    }

    public List<Customer> ViewAllCustomerDetails() {
        Customers = new ArrayList<Customer>();
        Customer cs = new Customer();
        try {
            ps = con.prepareStatement(CustomerQuery.ViewAll_Query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cs.setCID(rs.getInt(1));
                cs.setAccountNumber(rs.getLong(2));
                cs.setMobileNumber(rs.getLong(3));
                cs.setFirstName(rs.getString(4));
                cs.setLastName(rs.getString(5));
                cs.setGender(rs.getString(6));
                cs.setEmailId(rs.getString(7));
                cs.setAddress(rs.getString(8));
                cs.setAdharNo(rs.getLong(9));
                cs.setPanNo(rs.getString(10));
                cs.setAccountType(rs.getString(11));
                cs.setCustomerNo(rs.getLong(12));
                Customers.add(cs);
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
        return Customers;
    }

    public void UpdateCustomerDetalis(int CID) {
        int n=0;
        System.out.println("Select 1)MobileNumber 2)EmailID 3)Address 4)AccountType");
        System.out.println("Enter which One To Update");
        String Choice = sc.next();
        while(!Pattern.matches("[0-9]{1}",Choice)){
            System.err.println("Enter valid number");
            Choice = sc.next();
        }int C = Integer.parseInt(Choice);
        try {
            switch (C){
                case 1:
                    ps = con.prepareStatement(CustomerQuery.Update_Mobile);
                    System.out.println("Enter MobileNUmber to be updated ");
                    String ph = sc.next();
                    while(!Pattern.matches("\\d{10}",ph)){
                        System.err.println("Enter valid phone num");
                        ph = sc.next();
                    }long mobileNum = Long.parseLong(ph);
                    ps.setLong(1,mobileNum);
                    ps.setInt(2,CID);
                    n = ps.executeUpdate();
                    if(n!=0){
                        System.out.println("Successfully updated");
                    }else{
                        System.out.println("not updated");
                    }
                    break;
                case 2:
                    ps=con.prepareStatement(CustomerQuery.Update_EMAIL);
                    System.out.println("Enter EmailID to be updated");
                    String ema = sc.next();
                    while(!Pattern.matches("\\w*+@+[a-z&&gmail]+.+[a-z&&com]",ema)){
                        System.err.println("enter valid email id");
                        ema = sc.next();
                    }
                    ps.setString(1,ema);
                    ps.setInt(2,CID);
                    n=ps.executeUpdate();
                    if(n!=0){
                        System.out.println("Successfully updated");
                    }else{
                        System.out.println("not updated");
                    }
                case 3:
                    ps = con.prepareStatement(CustomerQuery.Update_ADDRESS);
                    System.out.println("Enter Address to be updated");
                    ps.setString(1,sc.next());
                    ps.setInt(2,CID);
                    n=ps.executeUpdate();
                    if(n!=0){
                        System.out.println("Successfully updated");
                    }else{
                        System.out.println("not updated");
                    }
                case 4:
                    ps = con.prepareStatement(CustomerQuery.Update_ACCOUNT);
                    System.out.println("Enter AccountType to be updated");
                    ps.setString(1,sc.next());
                    ps.setInt(2,CID);
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



    public void DeleteCustomer(int CID) {
        try {
            ps = con.prepareStatement(CustomerQuery.Delete);
            ps.setInt(1,CID);
            int n = ps.executeUpdate();
            if(n!=0){
                System.out.println("Successfully Deleted");
            }
            else{
                System.out.println("not deleted");
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