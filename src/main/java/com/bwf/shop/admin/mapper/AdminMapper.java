package com.bwf.shop.admin.mapper;


import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    //根据 账户名称 获取角色对象
    public Admin getAdminByName(@Param("admin_name") String admin_name);

    /**
     *
     *根据业务模型对象查询员工列表
     * @param bo 业务模型对象
     *
     * @return 满足条件的员工列表
     */
    List<Admin> getAddminList(@Param("bo") AdminSearchBo bo);

    /**
     * 添加员工对象
     *@param bo 业务模型对象
     *@return 数据库受到影响的行数
     */
   int addAdmin(@Param("bo") AdminAddBo bo);


    /**
     * 给员工对象添加角色
     * @param admin_id 员工编号
     *@param role_id   角色编号
     * @return 数据库受到影响的行数
     */
    int addAdminRole (@Param("admin_id") Integer admin_id,
                      @Param("role_id") Integer role_id);

    //删除单个员工
    int deleteOne(@Param("admin_id") Integer admin_id);
    //批量删除多个员工
    int deleteList(@Param("ids") Integer [] ids);

    /**
     * 根据员工编号查询员工对象
     * @param admin_id 要查询
     *
     * return  查询到的员工对象
     *
     * */
    Admin getAdminById(Integer admin_id);




    /***
     *
     * @param bo 修改员工业务模型
     *
     * @return    数据库修改受到影响的行数
     */


    int updateAdmin(@Param("bo") AdminUpdateBo bo);

}
