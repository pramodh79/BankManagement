public class Branch {
    private int BID;
    private String BranchName;
    private String IFSCCode;
    private String city;

    public Branch(){}

    public Branch(int BID, String branchName, String IFSCCode, String city) {
        this.BID = BID;
        BranchName = branchName;
        this.IFSCCode = IFSCCode;
        this.city = city;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String toString(){
        return BID+"\t"+BranchName+"\t"+IFSCCode+"\t"+city;
    }
}
