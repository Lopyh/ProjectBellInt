package eas.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class DocType {
    public DocType(){}

    public DocType(String docName, Integer docCode) {
        this.docName = docName;
        this.docCode = docCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name_doc")
    private String docName;

    @Basic(optional = false)
    @Column(name = "code")
    private Integer docCode;

    public Integer getId() {
        return id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docType",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<User> users;

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Integer getDocCode() {
        return docCode;
    }

    public void setDocCode(Integer docCode) {
        this.docCode = docCode;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DocType{" +
                "docName='" + docName + '\'' +
                ", docCode=" + docCode +
                '}';
    }

}
