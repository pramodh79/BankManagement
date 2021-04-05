public interface TransactionQuery {
    public String Balance_query = "SELECT C.BALANCE FROM CUSTOMER C,TRANSACTION T WHERE C.CID=?=T.CID=?";
    public String Balance = "SELECT FROM TRANSACTION WHERE TID =?";
    public String Withdraw_Query ="UPDATE TRANSACTION SET WITHDRAW=? WHERE CID =?";
    public String Deposit_Query ="UPDATE TRANSACTION SET DEPOSIT=? WHERE CID=?";
}
