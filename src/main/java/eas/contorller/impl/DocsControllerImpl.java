package eas.contorller.impl;



import eas.contorller.DocsController;
import eas.model.DocType;
import eas.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class DocsControllerImpl implements DocsController {

    private DocsService docsService;

    @Autowired
    DocsControllerImpl(DocsService docsService){
        this.docsService = docsService;
    }

    @Override
    @RequestMapping(value = "api/docs", method = RequestMethod.GET)
    @ResponseBody
    public List<DocType> list() {
        return docsService.list();
    }
}
