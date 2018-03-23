package eas.service;

import eas.model.Office;

import java.util.List;

public interface OfficeService {
    List<Office> list(Integer orgId, String name, String phone, boolean isActive);
    Office getById(Integer id);
    String update(Integer id, String name, String address, String phone, boolean isActive);
    String delete(Integer id);
    String save(String name, String address, String phone, boolean isActive);
    List<Office> all();
}
