package eas.service;

import eas.model.Office;
import eas.orika.OfficeOrika;

import java.util.List;

public interface OfficeService {
    List<OfficeOrika> list(OfficeOrika officeOrika);

    /**получить офис по id*/
    OfficeOrika getById(Integer id);
    void update(OfficeOrika officeOrika);
    void delete(OfficeOrika officeOrika);
    void save(OfficeOrika officeOrika);
}
