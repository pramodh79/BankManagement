public class Customer {
    private int CID;
    private long AccountNumber;
    private long MobileNumber;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String EmailId;
    private String Address;
    private long AdharNo;
    private String PanNo;
    private String AccountType;
    private long CustomerNo;
    private double balance;

    public Customer(){}

    public Customer(int CID, long accountNumber, long mobileNumber, String firstName, String lastName, String gender, String emailId, String address, long adharNo, String panNo, String accountType, long customerNo, double balance) {
        this.CID = CID;
        AccountNumber = accountNumber;
        MobileNumber = mobileNumber;
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
        EmailId = emailId;
        Address = address;
        AdharNo = adharNo;
        PanNo = panNo;
        AccountType = accountType;
        CustomerNo = customerNo;
        this.balance = balance;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        AccountNumber = accountNumber;
    }

    public long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getAdharNo() {
        return AdharNo;
    }

    public void setAdharNo(long adharNo) {
        AdharNo = adharNo;
    }

    public String getPanNo() {
        return PanNo;
    }

    public void setPanNo(String panNo) {
        PanNo = panNo;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public long getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(long customerNo) {
        CustomerNo = customerNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return CID +"\t"+ AccountNumber +"\t"+ MobileNumber +"\t"+ FirstName + "\t"+ LastName + "\t" +Gender +"\t"+ EmailId+"\t"+ Address +"\t"+ AdharNo +"\t"+ PanNo+"\t"+ AccountType +"\t"+ CustomerNo;
    }
}
