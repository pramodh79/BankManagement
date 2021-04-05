import java.util.List;

public interface BranchDAO {
    public void AddBranchDetails();
    public Branch ViewBranchDetails(int BID);
    public List<Branch> ViewAllBranchDetails();
    public void UpdateBranchDetalis(int BID);
    public void Delete(int BID);
    public void Back();
}
