package eas.contorller;

import eas.contorller.impl.ResultView;
import eas.orika.ClientOrika;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientController {
    ResultView register(@RequestBody ClientOrika orika);
    String activation(String code);
    ResultView login(@RequestBody ClientOrika orika);
}
