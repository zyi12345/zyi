package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.mapper.AdminMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService implements UserDetailsService {

    @Resource
    private AdminMapper adminMapper;

    //根据员工姓名去验证
    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {
        // 根据账户名称 查询 角色列表
        Admin admin = adminMapper.getAdminByName(s);

        if (admin == null) {
            throw new UsernameNotFoundException("账户名称填写错误");
        }

        return admin;
    }
}
