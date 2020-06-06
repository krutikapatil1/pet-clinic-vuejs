package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.config.PropertyConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Krutika Patil
 * @since : 6/5/2020, Fri
 **/
@RestController
public class IndexController {

    private final PropertyConfig propertyConfig;

    public IndexController(PropertyConfig propertyConfig) {
        this.propertyConfig = propertyConfig;
    }

    @RequestMapping(value = "getWelcomeMsg", method = RequestMethod.GET)
    public String getWelcomeMsg() {
        return propertyConfig.messageHelper().getWelcomeMsg();
    }
}
