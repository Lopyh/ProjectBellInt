package EAS.User.model;

import EAS.Ofice.model.Office;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    public Users(){

    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

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
    @Column(name = "positionUs")
    private String positionUs;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "doc_number")
    private int docNumber;

    @Basic(optional = false)
    @Column(name = "doc_name")
    private String docName;

    @Basic(optional = false)
    @Column(name = "doc_date")
    private String docDate;

    @Basic(optional = false)
    @Column(name = "sitizenship_name")
    private String sitizenshipName;

    @Basic(optional = false)
    @Column(name = "sitizenship_code")
    private int sitizenshipCode;

    @Basic(optional = false)
    @Column(name = "is_identified")
    private Boolean isIdentified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;


}
