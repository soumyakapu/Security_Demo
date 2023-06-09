package com.security_demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Employee_credentials")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String Id;
    private String username;
    private String  password;
    private String role;
}
