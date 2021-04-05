public class Transaction {
    private int TID;
    private double Balance;
    private double Withdraw;
    private double Deposit;
    private long TransactionNOI;

    public Transaction(){}

    public Transaction(int TID, double balance, double withdraw, double deposit, long transactionNOI) {
        this.TID = TID;
        Balance = balance;
        Withdraw = withdraw;
        Deposit = deposit;
        TransactionNOI = transactionNOI;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getWithdraw() {
        return Withdraw;
    }

    public double setWithdraw(double withdraw) {
        Withdraw = withdraw;
        return withdraw;
    }

    public double getDeposit() {
        return Deposit;
    }

    public double setDeposit(double deposit) {
        Deposit = deposit;
        return deposit;
    }

    public long getTransactionNOI() {
        return TransactionNOI;
    }

    public void setTransactionNOI(long transactionNOI) {
        TransactionNOI = transactionNOI;
    }
    public String toString(){

        return TID+"\t"+Balance+"\t"+Withdraw+"\t"+Deposit+"\t"+TransactionNOI;
    }
}
