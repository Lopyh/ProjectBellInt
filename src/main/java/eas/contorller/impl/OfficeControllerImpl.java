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
    @RequestMapping(value = "api/office/list/{orgId}", method = RequestMethod.POST, consumes = "application/json")
    public List<OfficeOrika> list(@PathVariable("orgId") Integer orgId, @RequestBody  OfficeOrika officeOrika) {
        officeOrika.setOrgId(orgId);
        return officeService.list(officeOrika);
}


    @Override
    @ApiOperation(value = "getById", nickname = "getById", httpMethod = "GET")
    @RequestMapping(value = "api/office/{id}", method = RequestMethod.GET)
    public OfficeOrika getById(@PathVariable("id") Integer id) {
        return officeService.getById(id);
    }

    @Override
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/office/update", method = RequestMethod.POST, consumes = "application/json")
    public ResultView update(@RequestBody OfficeOrika officeOrika) {
        try {officeService.update(officeOrika);
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
    @RequestMapping(value = "api/office/delete", method = RequestMethod.POST, consumes = "application/json")
    public ResultView delete(@RequestBody OfficeOrika officeOrika) {
        try{
        officeService.delete(officeOrika);
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
    @RequestMapping(value = "api/office/save", method = RequestMethod.POST, consumes = "application/json")
    public ResultView save(@RequestBody OfficeOrika officeOrika) {
        try {
            officeService.save(officeOrika);
            return new ResultView();
        }
        catch (Exception e){
            return new ResultView(e.toString());
        }

    }
}
