package eas.contorller.impl;

import eas.contorller.OfficeController;
import eas.orika.OfficeOrika;
import eas.service.OfficeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class OfficeControllerImpl implements OfficeController{
    private OfficeService officeService;

    @Autowired
    OfficeControllerImpl(OfficeService officeService){
        this.officeService = officeService;
    }

    @Override
    @ApiOperation(value = "list", nickname = "list", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/office/list", method = RequestMethod.POST, consumes = "application/json")
    public List<OfficeOrika> list(@RequestBody  OfficeOrika officeOrika) {
        return officeService.list(officeOrika);
}


    @Override
    @ApiOperation(value = "getById", nickname = "getById", httpMethod = "GET")
    @RequestMapping(value = "api/office/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id) {
        return officeService.getById(id).toString();
    }

    @Override
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/office/update", method = RequestMethod.POST, consumes = "application/json")
    public void update(@RequestBody OfficeOrika officeOrika) {
        officeService.update(officeOrika);
    }

    @Override
    @ApiOperation(value = "delete", nickname = "delete", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/office/delete", method = RequestMethod.POST, consumes = "application/json")
    public void delete(@RequestBody OfficeOrika officeOrika) {
        officeService.delete(officeOrika);
    }

    @Override
    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/office/save", method = RequestMethod.POST, consumes = "application/json")
    public void save(@RequestBody OfficeOrika officeOrika) {
        officeService.save(officeOrika);
    }
}
