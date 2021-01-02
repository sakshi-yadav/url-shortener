package com.loando.userService.entities;

import com.loando.userService.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    public String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @Column(name = "user_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public UserType userType;

    @Column(name = "password", nullable = true)
    public String password;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Set<Document> document;

    @OneToOne(mappedBy = "user")
    private BankDetails bankDetails;
}
