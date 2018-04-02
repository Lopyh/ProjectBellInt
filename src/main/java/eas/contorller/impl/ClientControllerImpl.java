package eas.contorller.impl;


import eas.contorller.ClientController;
import eas.orika.ClientOrika;
import eas.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class ClientControllerImpl implements ClientController {

    private ClientService clientService;

    @Autowired
    ClientControllerImpl(ClientService clientService){
        this.clientService = clientService;
    }

    @ApiOperation(value = "register", nickname = "register", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/register", method = RequestMethod.POST, consumes = "application/json")
    public void register(@RequestBody ClientOrika orika){
        clientService.save(orika);
    }



    @RequestMapping(value = "api/activation")
    public @ResponseBody String activation(@RequestParam("code") String code){
        return (code);
    }



}
