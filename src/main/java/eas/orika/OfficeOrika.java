package eas.orika;

import java.util.List;

public class OfficeOrika {
    public OfficeOrika(){
    }
    public OfficeOrika(String name, String address, String phone, boolean isActive){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private boolean isActive;
    private OrganizationOrika organization;
    private List<UserOrika> user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public OrganizationOrika getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationOrika organization) {
        this.organization = organization;
    }

    public List<UserOrika> getUser() {
        return user;
    }

    public void setUser(List<UserOrika> user) {
        this.user = user;
    }
}
