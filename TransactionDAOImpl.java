
import java.sql.*;
import java.util.Scanner;
class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String msg){
        super(msg);
    }
}
public class TransactionDAOImpl implements TransactionDAO {
    Scanner sc = new Scanner(System.in);
    Customer c = new Customer();
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    Connection con = DaUtil.getConnection();


    public void Balance(int CID) {
        Transaction t = new Transaction();
        try {
            ps = con.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE CID=?");
            ps.setInt(1,CID);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                System.out.println("Current Balance :"+rs.getDouble(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }




    public void WithDrawAmount(int CID) {
        Transaction ts = new Transaction();
        double temp = 0;
        double temp1 = 0;
        double d;

        try {
            ps = con.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE CID=?");
            ps.setInt(1,CID);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                System.out.println("Current Balance :"+rs.getDouble(1));
                temp  = rs.getDouble(1);
            }
            System.out.println("Enter Withdraw Amount");
            d=ts.setWithdraw(sc.nextDouble());
            if(d < temp){
                temp1 = temp-d;
                System.out.println("Available balance:"+temp1);
                ps1= con.prepareStatement(TransactionQuery.Withdraw_Query);
                ps1.setDouble(1,d);
                ps1.setInt(2,CID);
                ps1.executeUpdate();
                ps =con.prepareStatement("UPDATE CUSTOMER SET BALANCE=? WHERE CID =?");
                ps.setDouble(1,temp1);
                ps.setInt(2,CID);
                ps.executeUpdate();
            }
            else{
                System.out.println("Balance Not Available");
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

    public void Deposit(int CID) {
        Transaction ts = new Transaction();
        double temp = 0;
        double temp1 = 0;
        double d;

        try {
            ps = con.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE CID=?");
            ps.setInt(1,CID);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                System.out.println("Current Balance :"+rs.getDouble(1));
                temp  = rs.getDouble(1);
            }
            System.out.println("Enter Deposit Amount");
            d=ts.setDeposit(sc.nextDouble());
                temp1 = temp+d;
                System.out.println("Available balance:"+temp1);
                ps1= con.prepareStatement(TransactionQuery.Deposit_Query);
                ps1.setDouble(1,d);
                ps1.setInt(2,CID);
                ps1.executeUpdate();
                ps =con.prepareStatement("UPDATE CUSTOMER SET BALANCE=? WHERE CID =?");
                ps.setDouble(1,temp1);
                ps.setInt(2,CID);
                ps.executeUpdate();

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

    public void Transfer(int fromCid,int toCid,double amount){
        try {
            ps = con.prepareStatement("select balance from customer where cid=?");

            ps.setInt(1,fromCid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            double famount = rs.getDouble(1);
            if(famount>=amount) {
                double damount = famount - amount;
                PreparedStatement ps2 = con.prepareStatement("select balance from customer where cid=?");
                ps2.setInt(1, toCid);
                ResultSet rs1 = ps2.executeQuery();
                rs1.next();
                double tamount = rs.getDouble(1);
                double updatedAmount = tamount + amount;
                Statement st = con.createStatement();
                st.addBatch("update customer set balance=" + damount + " where cid=" + fromCid);
                st.addBatch("update customer set balance=" + updatedAmount + " where cid=" + toCid);
                int[] rows = st.executeBatch();
                if (rows.length != 2) {
                    con.rollback();
                    System.out.println("Transaction Failed.Please try again after some times");
                } else {
                    System.out.println("Transaction Successfully done.");

                }
            }else{
                throw new InsufficientBalanceException("Insufficient Funds");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

    }


    public void Back(){
        BankManagementSystem.main(null);
    }
}


