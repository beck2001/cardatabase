package com.sharibekoff.cardatabase;

import com.sharibekoff.cardatabase.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception { // here we specify which endpoints are secure and which are not
        http.csrf().disable().cors().and().authorizeRequests().anyRequest().permitAll();
//        http.csrf().disable().cors().and().authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                // Filter for the api/login requests
//                .addFilterBefore(new LoginFilter("/login", authenticationManager()),
//                        UsernamePasswordAuthenticationFilter.class)
//                // Filter for other requests to check JWT in header
//                .addFilterBefore(new AuthenticationFilter(),
//                        UsernamePasswordAuthenticationFilter.class);
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(Arrays.asList("*"));
//        config.setAllowedMethods(Arrays.asList("*"));
//        config.setAllowedHeaders(Arrays.asList("*"));
//        config.setAllowCredentials(true);
//        config.applyPermitDefaultValues();
//
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }

}