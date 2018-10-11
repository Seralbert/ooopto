package ys.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ys.project.service.UserService;

/**
 * Created by zorrax on 21.09.2018.
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private UserService userService;
    @Autowired
    public void setUserService(UserService service){this.userService = service;}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/docs", "/parts/*","/imgres/*", "/img/*", "/reg", "/css/*")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
                    .formLogin().loginPage("/login").permitAll()
                .and()
                    //.rememberMe()
                //.and()
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }

    @Bean
    public PasswordEncoder bcPassEncoder(){
        return new BCryptPasswordEncoder();
    }
       @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           auth.userDetailsService(userService)
                   .passwordEncoder(bcPassEncoder());
       }
}
