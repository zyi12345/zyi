package com.bwf.shop.admin.controller;

import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
     private   IRoleService iRoleService;
    //角色管理页面
    @RequestMapping("/admin")
    public String admin(RoleSearchBo bo, Model model){
        //根据角色搜索业务模型对象 查询 满足条件的角色列表
        List<Role> roleList = iRoleService.getRoleList(bo);

      model.addAttribute("roleList",roleList);

        return null;
    }
}
