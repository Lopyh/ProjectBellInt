package eas.contorller.impl;

import eas.contorller.UserController;
import eas.orika.UserOrika;
import eas.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
public class UserControllerImpl implements UserController{

    private UserService userService;

    @Autowired
    UserControllerImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    @ApiOperation(value = "list", nickname = "list", httpMethod = "POST")
    @RequestMapping(value = "api/user/list", method = RequestMethod.POST, consumes = "application/json")
    public List<UserOrika> list(@RequestBody UserOrika userOrika) {
        return userService.list(userOrika);
    }

    @Override
    @ApiOperation(value = "getById", nickname = "getById", httpMethod = "GET")
    @RequestMapping(value = "api/user/{id}", method = RequestMethod.GET)
    public UserOrika getUserById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @Override
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/user/update", method = RequestMethod.POST, consumes = "application/json")
    public ResultView update(@RequestBody UserOrika userOrika) {
        try{
        userService.update(userOrika);
        return new ResultView();
    }
        catch (Exception e){
        return new ResultView(e.toString());
    }
    }

    @Override
    @ApiOperation(value = "delete", nickname = "delete", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/user/delete", method = RequestMethod.POST, consumes = "application/json")
    public ResultView delete(@RequestBody UserOrika userOrika) {
       try{
        userService.delete(userOrika);
        return new ResultView();
    }
        catch (Exception e){
        return new ResultView(e.toString());
    }
    }

    @Override
    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/user/save", method = RequestMethod.POST, consumes = "application/json")
    public ResultView save(@RequestBody UserOrika userOrika) {
     try{
        userService.save(userOrika);
        return new ResultView();
    }
        catch (Exception e){
        return new ResultView(e.toString());
    }
    }
}
