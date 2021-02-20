package com.bwf.shop.admin.security;

import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.mapper.RoleMapper;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/*
* 授权类
* */
@Component
public class GrantPermission implements FilterInvocationSecurityMetadataSource {

    @Resource
    private RoleMapper roleMapper;

    //过滤到每一次客户端请求，根据请求的url 允许访问的角色列表
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请的url路径
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("-----当前请求的url ----"+requestUrl);
        // 根据当前请求的url 查询是有相应权限的角色列表
        List<Role> roleList = roleMapper.getRoleListByOperateUrl(requestUrl);
        //判断角色列表是否为空
        if (!roleList.isEmpty() && roleList.size()>=0) {
            //定义授权列表
            String []  grantArray =new String[roleList.size()];
            System.out.println("------开始授权------");
            // 拥有当前url访问权限的角色
            for (int i = 0; i <=roleList.size()-1 ; i++) {
                  //当前循环到的每一个角色名称 存放 到授权列表中
                  grantArray[i]=roleList.get(i).getRole_name();
                  System.out.println("授权角色-------"+roleList.get(i).getRole_name());
            }
            System.out.println("------------授权完毕------------");
            //生成授权列表 返回
            return SecurityConfig.createList(grantArray);
        }else{
            // 任何角色都能访问
            return SecurityConfig.createList("ROLE_LOGIN");
        }




    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}




