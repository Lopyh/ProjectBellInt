package eas.model;

import javax.persistence.*;

@Entity
public class Country {
    public Country(){}

    public Country(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
}
