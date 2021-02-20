package com.bwf.shop.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//安全退出成功的处理器
@Controller
@RequestMapping("administrator")
public class AdministratorController {

    @RequestMapping("/login")
    public String login(){
         return null;
     }

    @RequestMapping("/logindo")
    public String logindo(String username,String userpass){
        return null;
    }


}
