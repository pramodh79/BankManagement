public interface TransactionDAO {
    public void Balance(int CID);
    public void WithDrawAmount(int CID);
    public void Deposit(int CID);
    public void Transfer(int fromcid,int tocid,double amount);
    public void Back();


}
