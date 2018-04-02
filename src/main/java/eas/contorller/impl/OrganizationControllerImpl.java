package eas.contorller.impl;

import eas.contorller.OrganizationController;
import eas.model.Organization;
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

    @Autowired
    OrganizationControllerImpl(OrgService orgService){
        this.orgService = orgService;
    }

    @Override
    @RequestMapping(value = "api/organization/list", method = RequestMethod.POST)
    public List<OrganizationOrika> list(@RequestBody OrganizationOrika organizationOrika) {
        return orgService.list(organizationOrika);
    }


    @Override
    @ApiOperation(value = "getById", nickname = "getById", httpMethod = "GET")
    @RequestMapping(value = "api/organization/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id) {
        return orgService.getById(id).toString();
    }

    @Override
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/organization/update", method = RequestMethod.POST, consumes = "application/json")
    public void update(@RequestBody OrganizationOrika organizationOrika) {
        orgService.update(organizationOrika);
    }

    @Override
    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/organization/save", method = RequestMethod.POST, consumes = "application/json")
    public void save(@RequestBody OrganizationOrika organizationOrika) {
        orgService.saveOrg(organizationOrika);
    }

    @ApiOperation(value = "delete", nickname = "delete", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "api/organization/delete", method = RequestMethod.POST, consumes = "application/json")
    public void delete(@RequestBody OrganizationOrika organizationOrika) {
        orgService.delete(organizationOrika);
    }


}
