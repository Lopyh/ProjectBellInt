package EAS.organization.DAO;


import EAS.organization.model.Organization;

import java.util.List;

public interface OrganizationDAO {
    public Organization getById(Integer Id);
    public List<Organization> all();
    public void save(Organization organization);
    public void remove(Organization organization);
    public void update(Organization organization);
}
