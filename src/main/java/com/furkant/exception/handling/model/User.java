package com.furkant.exception.handling.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "user", schema = "rds")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "user_name")
    @Size(max = 20, message = "user name should not be grater then 20 character")
    private String userName;

    @Column
    @Size(max = 30, message = "password not be grater then 30 character")
    private String password;
}

