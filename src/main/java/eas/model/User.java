package eas.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "User")
public class User {

    public User(){
    }

    public User(String firstName, String secondName,
                 String middleName, String position, String phone, String docName,
                 Integer docNumber, Date docDate, String citizenshipName, Integer citizenshipCode, boolean isIdentified){

        this.firstName = firstName;
        this.lastName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "middle_name")
    private String middleName;

    @Basic(optional = false)
    @Column(name = "position")
    private String position;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "doc_number")
    private int docNumber;


//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name="MGR_COUNTRY", referencedColumnName="COUNTRY"),
//            @JoinColumn(name="MGR_ID", referencedColumnName="EMP_ID")
//    })


    @Basic(optional = false)
    @Column(name = "doc_name")
    private String docName;

    @Basic(optional = false)
    @Column(name = "doc_date")
    private Date docDate;

    @Basic(optional = false)
    @Column(name = "citizenship_name")
    private String citizenshipName;

    @Basic(optional = false)
    @Column(name = "citizenship_code")
    private int citizenshipCode;

    @Basic(optional = false)
    @Column(name = "is_identified")
    private Boolean isIdentified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id")
    private Office office;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\''+'}';

    }
}
