package EAS.office.dao;

import EAS.office.model.Office;


import java.util.List;

public interface OfficeDAO {

    List<Office> all();
    List<Office> list(Integer orgId, String name, String phone, boolean isActive);
    Office getById(Integer id);
    public void update(Office office);
    public void remove(Office office);
    public void save(Office office);
}
