package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.po.Role;

import java.util.List;

//Role角色模块业务层
public interface IRoleService {
    /**
     * 获取所有的角色列表
     *
     * */
    List<Role> getAllRoleList();


    /**
     * 根据角色搜索业务模型对象 查询满足条件的角色列表
     *
     * @param bo 角色搜索业务模型对象
     * @return 满足条件的角色列表
     * */
    List<Role> getRoleList(RoleSearchBo bo);
}
