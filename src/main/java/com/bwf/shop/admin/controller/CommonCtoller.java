package com.bwf.shop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonCtoller {
    @RequestMapping("/permissonerror")
    public String permissionerror(){

        return null;
    }
}
