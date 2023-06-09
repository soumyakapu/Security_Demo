package com.security_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class EmployeeConfig {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
      httpSecurity
              .authorizeHttpRequests((http) -> http
                      .requestMatchers("/api/createEmployee").permitAll()
                      .requestMatchers("/api/getAllEmployees").authenticated()
              )
//              .formLogin((e)->e.setBuilder(httpSecurity))
              .formLogin(Customizer.withDefaults())
            ;

           return httpSecurity.build();
    }
    // giving the user using UserDetailsService

//    @Bean
//    public UserDetailsService users(PasswordEncoder encoder){
//        UserDetails user = User.withUsername("Sonu")
//                .password(encoder.encode("password1"))
//                .roles("user")
//                .build();
//        UserDetails admin = User.withUsername("Sss")
//                .password(encoder.encode("password2"))
//                .roles("ADMIN")
//                .build();
//        return  new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
