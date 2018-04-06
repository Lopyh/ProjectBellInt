package eas.service;

import eas.contorller.impl.ResultView;
import eas.orika.OrganizationOrika;

import java.util.List;

public interface OrgService {
    public List<OrganizationOrika> list(OrganizationOrika organizationOrika);
    public OrganizationOrika getById(Integer id);
    public void delete(OrganizationOrika organizationOrika);
    public void saveOrg(OrganizationOrika organizationOrika);
    public void update(OrganizationOrika organizationOrika);

}
