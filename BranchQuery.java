public interface BranchQuery {
    public String Insert_Query = "INSERT INTO BRANCH VALUES(?,?,?,?,?)";
    public String View_Query = "SELECT*FROM BRANCH WHERE BID=?";
    public String ViewAll_Query = "SELECT * FROM BRANCH";
    public String Update_Branch = "UPDATE BRANCH SET BRANCHNAME =? WHERE BID=?";
    public String Update_IFSC = "UPDATE BRANCH SET IFSCCODE =? WHERE BID=?";
    public String Update_CITY = "UPDATE BRANCH SET CITY =? WHERE BID=?";
    public String Delete ="UPDATE BRANCH SET STATUS = 'INACTIVE' WHERE BID=?";

}
