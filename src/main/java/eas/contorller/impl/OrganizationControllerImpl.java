package eas.contorller.impl;

import eas.contorller.OrganizationController;
import eas.orika.OrganizationOrika;
import eas.service.OrgService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class OrganizationControllerImpl implements OrganizationController{
    private OrgService orgService;
    ResultView resultView;

    @Autowired
    OrganizationControllerImpl(OrgService orgService){
        this.orgService = orgService;
        this.resultView = resultView;
    }

    @Override
    @RequestMapping(value = "api/organization/list", method = RequestMethod.POST)
    public List<OrganizationOrika> list(@RequestBody OrganizationOrika organizationOrika) {
        return orgService.list(organizationOrika);
    }


    @Override
    @ApiOperation(value = "getById", nickname = "getById", httpMethod = "GET")
    @RequestMapping(value = "api/organization/{id}", method = RequestMethod.GET)
    public OrganizationOrika getById(@PathVariable("id") Integer id) {
        return orgService.getById(id);
    }

    @Override
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/organization/update", method = RequestMethod.POST, consumes = "application/json")
    public ResultView update(@RequestBody OrganizationOrika organizationOrika) {
        try{
            orgService.update(organizationOrika);
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
    @RequestMapping(value = "api/organization/save", method = RequestMethod.POST, consumes = "application/json")
    public ResultView save(@RequestBody OrganizationOrika organizationOrika) {
        try{
        orgService.saveOrg(organizationOrika);
        return new ResultView();
        }
        catch (Exception e){
        return new ResultView(e.toString());
        }
    }

    @ApiOperation(value = "delete", nickname = "delete", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/organization/delete", method = RequestMethod.POST, consumes = "application/json")
    public ResultView delete(@RequestBody OrganizationOrika organizationOrika) {
     try {
        orgService.delete(organizationOrika);
        return new ResultView();
        }
        catch (Exception e){
        return new ResultView(e.toString());
     }
    }


}
