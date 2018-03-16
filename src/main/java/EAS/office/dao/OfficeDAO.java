package EAS.office.dao;

import EAS.office.model.Office;


import java.util.List;

public interface OfficeDAO {

    List<Office> all();
    Office getById(Integer id);
}
