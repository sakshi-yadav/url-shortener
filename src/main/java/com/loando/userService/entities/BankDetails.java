package com.loando.userService.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bank_details")
public class BankDetails extends BaseEntity{
    @Column(name = "bank_name")
    public String bankName;

    @Column(name = "iban")
    public String IBAN;

    @Column(name = "bank_letter_url")
    public String bankLetterUrl;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
