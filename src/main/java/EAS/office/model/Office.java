package EAS.office.model;


import EAS.organization.model.Organization;
import EAS.user.model.Users;

import javax.persistence.*;
import java.util.List;


@Entity
public class Office {

    public Office(){

    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nameOf")
    private String nameOf;

    @Basic(optional = false)
    @Column(name = "address")

    private String address;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "isActive")
    private int isActive;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "office", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Users> users;


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOf() {
        return nameOf;
    }

    public void setNameOf(String nameOf) {
        this.nameOf = nameOf;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", nameOf='" + nameOf + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                ", organization=" + organization +
                ", users=" + users +
                '}';
    }
}