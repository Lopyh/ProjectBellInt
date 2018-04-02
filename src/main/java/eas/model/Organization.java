package eas.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Organization")
public class Organization {
    public Organization(){

    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Basic(optional = false)
        @Column(name = "name")
        private String name;

        @Basic(optional = false)
        @Column(name = "full_name")
        private String fullName;

        @Basic(optional = false)
        @Column(name = "inn")
        private String inn;

        @Basic(optional = false)
        @Column(name = "kpp")
        private String kpp;

        @Basic(optional = false)
        @Column(name = "address")
        private String address;

        @Basic(optional = false)
        @Column(name = "phone ")
        private String phone ;

        @Basic(optional = false)
        @Column(name = "isActive")
        private boolean isActive;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
        private List<Office> offices;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String nameOr) {
            this.name = nameOr;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getInn() {
            return inn;
        }

        public void setInn(String inn) {
            this.inn = inn;
        }

        public String getKpp() {
            return kpp;
        }

        public void setKpp(String kpp) {
            this.kpp = kpp;
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

        public boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }


    @Override
    public String toString() {
        return "Organization{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", inn=" + getInn() +
                ", kpp=" + getKpp() +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", isActive=" + getIsActive() +
                '}';
    }
}
