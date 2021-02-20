package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//员工业务层
public interface IAdminService {
    /**
     * 员工账号名称获取员工账户
     *
     *
     * */
 Admin getAdminByName(String admin_name);



    /**
     *
     *根据业务模型对象查询员工列表
     * @param bo 业务模型对象
     *
     * @return 满足条件的员工列表
     */
    List<Admin> getAddminList(@Param("bo") AdminSearchBo bo);


    /**
     * 添加员工
     * @param  bo 添加员工业务模型
     *
     * @return 是否执行成功
     */


    Boolean addAdmin(AdminAddBo bo);

   /**
   *根据员工编号删除单个员工
   * @param admin_id 删除员工的员工编号
   * @return 删除操作是否成功
   * */


    boolean delete0ne(@Param("admin_id") Integer admin_id);


/**
 * 根据员工编号批量副服员工
 * @param ids 删除员工的编号数组
 *@return  删除操作是否成功
 *
 * */
boolean deleteList(Integer [] ids);


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
     * @return    修改执行是否成功
     */


boolean updateAdmin(AdminUpdateBo bo);



}
