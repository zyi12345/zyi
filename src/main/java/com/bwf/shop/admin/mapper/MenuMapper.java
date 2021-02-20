package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.po.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MENU菜单模块 数据访问层
 *
 *
 *
 * */
@Repository
public interface MenuMapper {
/**
 *
 * 根据员工编号查询菜单列表
 * @param  admin_id 员工编号查询菜单列表
 *
 * **/

List<Menu> getMenuListAdminId(@Param("admin_id") Integer admin_id);

}
