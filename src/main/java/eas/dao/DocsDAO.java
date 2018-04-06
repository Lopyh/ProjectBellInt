package eas.dao;

import eas.model.DocType;


import java.util.List;

public interface DocsDAO {
    List<DocType> list();
    DocType getByCode(Integer code);
    DocType getByName(String name);
}
