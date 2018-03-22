package EAS.Client.DAO;

import EAS.Client.model.Client;

public interface ClientDAO {
    void registr(Client client);
    void activationCode();
    Client findByName(String name);
}
