package eas.contorller.impl;

import eas.contorller.CountryController;
import eas.model.Country;
import eas.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class CountryControllerImpl implements CountryController{
    private CountryService countryService;

    @Autowired
    CountryControllerImpl(CountryService countryService){
        this.countryService = countryService;
    }

    @Override
    @RequestMapping(value = "api/countries", method = RequestMethod.GET)
    @ResponseBody
    public List<Country> list() {
        return countryService.list();
    }
}
