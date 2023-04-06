package com.spring.swagger.springsecurity.config;

import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Collections;

import com.spring.swagger.springsecurity.filters.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http

                /*.authorizeRequests()
                        .antMatchers("/sign-up").permitAll()
                .antMatchers()
                        .and()
                .httpBasic();*/
               /* .authorizeRequests((requests) ->
                {
            (requests.anyRequest()).authenticated();
        });
        http.formLogin();
        http.httpBasic();*/
        /*http.authorizeRequests().anyRequest().permitAll()
                .and().formLogin().and().httpBasic();*/

        /*http.authorizeRequests().anyRequest().denyAll()
                .and().formLogin().and().httpBasic();*/
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and()
         .cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setExposedHeaders(Arrays.asList("Authorization"));
                config.setMaxAge(2500L);
                return config;
            }
       // }).and().csrf().disable()
       // }).and().csrf().ignoringAntMatchers("/other/*").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        }).and().csrf().disable()
                .addFilterBefore(new FilterBefore(), BasicAuthenticationFilter.class)
                .addFilterAfter(new FilterAfter(),BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenFilter(),BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTValidationFilter(),BasicAuthenticationFilter.class)
                .addFilterAt(new FilterAt(),BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/football/*").hasRole("USER")
                .antMatchers("/basketball/*").hasRole("ADMIN")
                .antMatchers("/swimming/*").hasRole("MANAGER")
                .antMatchers("/subscribers/*").hasAnyRole("ADMIN","MANAGER")
                .antMatchers("/login").authenticated()
                .antMatchers("/about/*").permitAll()
                .antMatchers("/connect/*").permitAll()
                .antMatchers("/other/*").permitAll()
                .and().formLogin().and().httpBasic();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder()
                        .encode("admin123")).roles("ADMIN")
        .and().withUser("gado").password(passwordEncoder()
                        .encode("gado89")).roles("ADMIN")
                       .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    //@Override
    /*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetails_1 = User.withUsername("islam").password("12345").authorities("admin").build();
        UserDetails userDetails_2 = User.withUsername("ahmed").password("00000").authorities("player").build();
        inMemoryUserDetailsManager.createUser(userDetails_1);
        inMemoryUserDetailsManager.createUser(userDetails_2);
        auth.userDetailsService(inMemoryUserDetailsManager);
    }*/
/*
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
