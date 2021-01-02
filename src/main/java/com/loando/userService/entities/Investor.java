package com.loando.userService.entities;

import com.loando.userService.enums.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Investor extends User {
    @Column(name = "national_id")
    public String nationalId;

    @Column(name = "iqama_id")
    public String iqamaId;

    @Column(name = "date_of_birth", nullable = false)
    public LocalDate dateOfBirth;

    @Column(name = "full_name_eng", nullable = false)
    public String fullNameEng;

    @Column(name = "full_name_arab", nullable = false)
    public String fullNameArab;

    @Column(name = "is_saudi", nullable = false)
    public Boolean isSaudi;

    @Column(name = "id_expiry_date", nullable = false)
    public LocalDate idExpiryDate;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    public Gender gender;

    @Column(name = "national_address", nullable = false)
    public String nationalAddress;

    @Column(name = "nationality", nullable = false)
    public String nationality;

    @Column(name = "annual_income")
    @Enumerated(EnumType.STRING)
    public IncomeGroup annualIncome;

    @Column(name = "source_of_income")
    @Enumerated(EnumType.STRING)
    public IncomeSource sourceOfIncome;

    @Column(name = "job_status")
    @Enumerated(EnumType.STRING)
    public JobStatus jobStatus;

    @Column(name = "job_title")
    public String jobTitle;

    @Column(name = "employer")
    public String employer;

    @Column(name = "is_credit_investor")
    public Boolean isCreditInvestor;

    @Column(name = "investor_status")
    @Enumerated(EnumType.STRING)
    public InvestorStatus investorStatus;
}
