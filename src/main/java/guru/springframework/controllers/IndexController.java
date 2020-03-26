package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        System.out.println("Some message. yo bro 21321 sdsd3");

        return "index";
    }

}
