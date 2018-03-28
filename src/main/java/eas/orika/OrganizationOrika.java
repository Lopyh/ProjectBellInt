package eas.orika;

import eas.model.Office;

import java.util.List;


public class OrganizationOrika {
    public OrganizationOrika(){

    }

    public OrganizationOrika(String nameOr, String fullName, String inn, int kpp, String address, String phone, boolean isActive) {
        this.nameOr = nameOr;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
    private Integer id;
    private String nameOr;
    private String fullName;
    private String inn;
    private Integer kpp;
    private String address;
    private String phone;
    private boolean isActive;
    private List<Office> offices;

}
