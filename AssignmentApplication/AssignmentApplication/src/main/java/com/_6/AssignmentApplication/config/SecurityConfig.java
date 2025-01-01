package com._6.AssignmentApplication.config;

import com._6.AssignmentApplication.filter.JwtFilter;
import com._6.AssignmentApplication.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
   }

   @Autowired
   private JwtFilter jwtFilter;

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http = http.csrf().disable().cors().disable();

       http = http.sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and();
       AuthenticationEntryPoint auth;
       http =http.exceptionHandling()
               .authenticationEntryPoint((request,response,ex)->{
                   response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
               }).and();

       http.authorizeRequests()
               .anyRequest().authenticated();

       http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
   }

   @Autowired
   private JwtFilter jwtFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.csrf().disable().cors().disable();


        http = http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http.exceptionHandling()
                .authenticationEntryPoint((request, response, ex) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                }).and();

        http.authorizeRequests()
                .antMatchers("/api/auth/**").permitAll() // Ensure this is correct
                .anyRequest().authenticated();




        http = http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http.exceptionHandling()
                .authenticationEntryPoint((request, response, ex) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                }).and();

        http.authorizeRequests()
                .antMatchers("/api/auth/**").permitAll() // Ensure this is correct
                .anyRequest().authenticated();


        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }



}
