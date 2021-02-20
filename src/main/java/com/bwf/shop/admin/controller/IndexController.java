package com.bwf.shop.admin.controller;

import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.service.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




/*public class IndexController {
	@RequestMapping(value = {"/","index"})
	public String index(){
		return "index/index";
	}*/
@Controller
@RequestMapping(value = {"/","index"})
public class IndexController {
	@Autowired
	private IAdminService adminService;
	@RequestMapping(value = {"/","index"})
	public String index(Authentication auth , Model model){
		System.out.println("当前登录的用户："+auth.getName());
		//根据当前登录的员工的账号名称 获取 当前登录的员工对象
		Admin admin= adminService.getAdminByName(auth.getName());
		model.addAttribute("admin",admin);
		return "index/index";
	}

	@RequestMapping("/home")
	public String home(){
		return "index/home";
	}
}
