package eas.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {
    public Country(){}

    public Country(String citizenshipName, Integer citizenshipCode) {
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String citizenshipName;

    @Basic(optional = false)
    @Column(name = "code")
    private Integer citizenshipCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<User> users;

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public Integer getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Integer citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
