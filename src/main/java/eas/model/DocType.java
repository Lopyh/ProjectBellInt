package eas.model;

import javax.persistence.*;

@Entity
public class DocType {
    DocType(){}

    public DocType(String nameDoc, Integer code) {
        this.nameDoc = nameDoc;
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name_doc")
    private String nameDoc;

    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;

    public Integer getId() {
        return id;
    }

    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
