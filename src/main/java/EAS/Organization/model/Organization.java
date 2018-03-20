package EAS.organization.model;

import EAS.office.model.Office;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Organization")
public class Organization {
    public Organization(){

    }

    public Organization(String nameOr, String fullName, String inn, int kpp, String address, String phone, boolean isActive) {
        this.nameOr = nameOr;
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
        @Column(name = "nameOr")
        private String nameOr;

        @Basic(optional = false)
        @Column(name = "fullName")
        private String fullName;

        @Basic(optional = false)
        @Column(name = "inn")
        private String inn;

        @Basic(optional = false)
        @Column(name = "kpp")
        private Integer kpp;

        @Basic(optional = false)
        @Column(name = "address")
        private String address;

        @Basic(optional = false)
        @Column(name = "phone ")
        private String phone ;

        @Basic(optional = false)
        @Column(name = "isActive")
        private boolean isActive;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        private List<Office> offices;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNameOr() {
            return nameOr;
        }

        public void setNameOr(String nameOr) {
            this.nameOr = nameOr;
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

        public int getKpp() {
            return kpp;
        }

        public void setKpp(int kpp) {
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
                ", nameOr='" + getNameOr() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", inn=" + getInn() +
                ", kpp=" + getKpp() +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", isActive=" + getIsActive() +
                '}';
    }
}
