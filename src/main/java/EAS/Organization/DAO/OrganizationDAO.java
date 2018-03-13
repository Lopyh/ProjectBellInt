package EAS.Organization.DAO;

import EAS.Organization.model.Organization;
import java.util.List;

public interface OrganizationDAO {
    public Organization getById(Integer Id);
    public List<Organization> all();
    public void save(Organization organization);
}
