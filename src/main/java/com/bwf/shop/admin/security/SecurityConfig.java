package com.bwf.shop.admin.security;

import com.bwf.shop.admin.security.handle.LoginErrorHandle;
import com.bwf.shop.admin.security.handle.LoginSuccessHandle;
import com.bwf.shop.admin.security.handle.LogoutSuccessHandle;
import com.bwf.shop.admin.security.handle.PermissionErrorHandle;
import com.bwf.shop.admin.service.impl.AdminService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//安全方法的开启
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AdminService adminService;

    //授权对象
    @Resource
    private GrantPermission grantPermission;

    //认证对象
    @Resource
    private  ValidPermission validPermission;

    //权限认证失败处理器
    @Resource
    private PermissionErrorHandle permissionErrorHandle;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置用户的登录的验证方式， 根据用户填写的账号名称获取用户对象
        auth.userDetailsService(adminService).passwordEncoder(new BCryptPasswordEncoder());//对用户密码进行加密

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 配置 Security 过滤请求的 例外
        web.ignoring().antMatchers("/administrator/login","/common/**","/img/**","/css/**","/js/**","/favicon.ico")
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/images/**", "/webjars/**", "/v2/api-docs", "/configuration/ui", "/configuration/security");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
       //配置springSecurity的流程
        http.headers().frameOptions().disable()//允许ifram嵌套
        .and()
        .authorizeRequests()//配置请求进行权限认证
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(grantPermission); //配置授权对象
                o.setAccessDecisionManager(validPermission); //配置认证对象
                return o;
            }
        })
                .and()
                .formLogin() //开启 表单验证
                .loginPage("/administrator/login") // 指定登录页面
                .loginProcessingUrl("/administrator/logindo") // 指定验证登录表单的url路径
                .usernameParameter("username") //账号名称的形参名称
                .passwordParameter("userpass")  //账号密码的形参名称
                .failureHandler(new LoginErrorHandle()) //登录验证失败处理器
                .successHandler(new LoginSuccessHandle()) //登录验证成功处理器
                .permitAll()
                .and()
                .logout()  //安全退出
                .logoutSuccessHandler(new LogoutSuccessHandle()) //安全退出成功处理器
                .permitAll()
                .and()
                .csrf()  //跨域请求的配置
                .disable() //禁用
                .exceptionHandling()
                .accessDeniedHandler(permissionErrorHandle); //权限认证失败处理器

    }
}
