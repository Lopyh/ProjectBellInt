//package eas.contorller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HelloController {
//
//    @RequestMapping(value = "/api/activation/code",method = RequestMethod.GET)
//    public String getStr(){
//        return "OMG this WORK";
//    }
//
//    @RequestMapping(value = "/api/activation/code/{name}",method = RequestMethod.GET)
//    public String getByname(@PathVariable("name") String code){
//        return (code);
//    }
//
//
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)public String printHello(ModelMap model) {
//        model.addAttribute("message", "Hello Spring MVC Framework!");
//        return "index.jsp";
//    }
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)public String print(ModelMap model) {
//        model.addAttribute("message", "FUCK THIS SHIT");
//        return "hello.jsp";
//    }
//}