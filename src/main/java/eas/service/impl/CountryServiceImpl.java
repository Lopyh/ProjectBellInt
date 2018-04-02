package eas.service.impl;

import eas.dao.CountryDAO;
import eas.model.Country;
import eas.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class CountryServiceImpl implements CountryService{
    CountryDAO countryDAO;

    @Autowired
    CountryServiceImpl(CountryDAO countryDAO){
        this.countryDAO = countryDAO;
    }

    @Override
    @Transactional
    public List<Country> list() {
        return countryDAO.list();
    }
}
