import java.util.List;

public interface CustomerDAO {
    public void AddCustomerDetails();
    public Customer ViewCustomerDetails(int CID);
    public List<Customer> ViewAllCustomerDetails();
    public void UpdateCustomerDetalis(int CID);
    public void DeleteCustomer(int CID);
    public void Back();
}
