package com.zcswl.spring.eureka.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * spring-cloud-eureka 使用了spring-boot-starter-security进行权限验证，
 * 需要在服务段添加下面代码
 *
 * https://cloud.spring.io/spring-cloud-netflix/2.2.x/reference/html/#securing-the-eureka-server
 *
 * 否则使用http://username:passowrd@host:port/eureka/ 注册不进去
 *
 * @author zhoucg
 * @date 2020-08-03 17:07
 */
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.csrf().disable();
        // 注意：为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,所以必须是httpBasic,
        // 如果是form方式,不能使用url格式登录
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();*/


        // 官方给的解决方法
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

}
