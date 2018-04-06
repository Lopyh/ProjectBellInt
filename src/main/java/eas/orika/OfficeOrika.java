package eas.orika;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfficeOrika {
    public OfficeOrika(){
    }

    public OfficeOrika(Integer orgId, Integer id, String name, String address, String phone, String isActive) {
        this.orgId = orgId;
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    private Integer orgId;
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String isActive;
    private OrganizationOrika organization;
    private List<UserOrika> user;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

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

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
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

    @Override
    public String toString() {
        return "OfficeOrika{" +
                "orgId=" + orgId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
