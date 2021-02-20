package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.po.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    /**
     *   根据员工查询该员工的角色列表
     *  @param admin_id   查询角色列表的员工的员工编号
     *  @return 该员工的角色列表
     * */
    List<Role> getRoleListByAdminId(@Param("admin_id") Integer admin_id);


    /**
     *  根据操作请求的url 获取相应访问权限的角色列表
     *  @param    operate_url 操作请求的URL
     *  @return   有该url访问权限的角色列表
     *
     * * */
    List<Role> getRoleListByOperateUrl(@Param("operate_url") String operate_url);

    /**
     * 获取所有角色列表
     * @return 系统中的所有角色
     *
     * */

    List<Role> getAllRoleList();


    /**
     * 根据角色搜索业务模型对象 查询满足条件的角色列表
     *
     * @param bo 角色搜索业务模型对象
     * @return 满足条件的角色列表
     * */
    List<Role> getRoleList(@Param("bo") RoleSearchBo bo);

}
