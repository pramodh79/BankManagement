public interface CustomerQuery {
    public String Insert_Query = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public String View_Query = "SELECT*FROM CUSTOMER WHERE CID=?";
    public String ViewAll_Query = "SELECT * FROM CUSTOMER";
    public String Update_Mobile = "UPDATE CUSTOMER SET MOBILENUMBER =? WHERE CID=?";
    public String Update_EMAIL = "UPDATE CUSTOMER SET EMAILID =? WHERE CID=?";
    public String Update_ADDRESS= "UPDATE CUSTOMER SET ADDRESS =? WHERE CID=?";
    public String Update_ACCOUNT= "UPDATE CUSTOMER SET ACCOUNTTYPE =? WHERE CID=?";
    public String Delete ="UPDATE CUSTOMER SET STATUS ='INACTVE' WHERE CID=?";
}
