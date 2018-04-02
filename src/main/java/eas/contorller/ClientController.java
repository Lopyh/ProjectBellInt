package eas.contorller;

import eas.model.Client;
import eas.orika.ClientOrika;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientController {
    void register(@RequestBody ClientOrika orika);
    String activation(String code);
}
