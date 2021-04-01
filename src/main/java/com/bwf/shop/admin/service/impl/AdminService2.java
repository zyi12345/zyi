package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.mapper.AdminMapper;
import com.bwf.shop.admin.service.IAdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService2 implements IAdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public Admin getAdminByName(String admin_name) {

     //获取用户名
        return  adminMapper.getAdminByName(admin_name);
    }

    @Override
    public List<Admin> getAddminList(AdminSearchBo bo) {
        return adminMapper.getAddminList(bo);
    }

    //添加员工
    @Override
    public Boolean addAdmin(AdminAddBo bo) {
        Admin admin = adminMapper.getAdminByName(bo.getAdmin_name());
        //判断账户是否存在
        if(admin==null){
            //该账户名不存在 可以添加
            //给当前添加员工业务模型对象 设置初始密码
            bo.setAdmin_pass(new BCryptPasswordEncoder().encode("12345"));
            //将员工模型对象添加到数据库中
            int a = adminMapper.addAdmin(bo);
            //给新增加的员工配置角色
            int b = adminMapper.addAdminRole(bo.getAdmin_id(), bo.getRole_id());
            return a>0 && b>0;
        }else {

            return false;//账户已经存在不可以添加
        }

    }

    @Override
    public boolean delete0ne(Integer admin_id) {
        return adminMapper.deleteOne(admin_id)>0;
    }

    @Override
    public boolean deleteList(Integer[] ids) {
        return adminMapper.deleteList(ids)>0;
    }

    @Override
    public Admin getAdminById(Integer admin_id) {
        return adminMapper.getAdminById(admin_id);
    }

    @Override
    public boolean updateAdmin(AdminUpdateBo bo) {


        return adminMapper.updateAdmin(bo)>0;
    }
}
