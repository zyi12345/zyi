package com.bwf.shop.admin.security;


import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/*权限认证类 */
@Component
public class ValidPermission implements AccessDecisionManager {


    @Override
    public void decide(Authentication authentication, Object o,
                       Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("------开始权限认证-------");
        // 迭代  当前请求的url 授权的所有角色

        for(ConfigAttribute attr :collection){
            //判断当前登录对象 是否为空
            if(authentication ==null){
                System.out.println("-------------权限认证失败");
                throw new AccessDeniedException("权限认证失败");
            }
            //获取当前迭代到的授权角色的名称
            String grantName =attr.getAttribute();
            //判断是否有默认授权
            if ("ROLE_LOGIN".equals(grantName)) {
                //判断当前用户是否已经登录
                if(authentication instanceof AnonymousAuthenticationToken){
                    System.out.println("用户还未登录！");
                    throw  new BadCredentialsException("请先登录");
                }else{
                    //当前用户已经登录 ，可以访问 公共资源
                    System.out.println("********公共资源, 已登录的用户认证通过");
                    return;
                }
            }
            //获取当前用户的角色列表
            Collection<? extends GrantedAuthority> roleList = authentication.getAuthorities();

            //迭代遍历 当前用户的角色列表
            for(GrantedAuthority role:roleList){
                System.out.println("授权角色---"+grantName+"==> 用户角色"+role.getAuthority());
                //判断 当前迭代的用户角色 是否是 当前外循环迭代到的授权角色
                if(grantName.equals(role.getAuthority())){
                    System.out.println("权限认证成功！！！！");
                }
            }

        }
        System.out.println("-----------权限认证结束----------");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
