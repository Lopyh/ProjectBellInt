package EAS.Client.model;

import javax.persistence.*;

@Entity
public class Client {
    public Client(){}

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "login")
    private String login;


}
