package com.loando.userService.entities;

import com.loando.userService.enums.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Organisation extends User {
    @Column(name = "cr_Number")
    public String crNumber;

    @Column(name = "cr_status")
    public String crStatus;

    @Column(name = "cr_expiry_date")
    public LocalDate crExpiryDate;

    @Column(name = "country_name_arab")
    public String countryNameArab;

    @Column(name = "capital")
    public String capital;

    @Column(name = "vat_number")
    public String vatNumber;

    @Column(name = "entity_structure")
    public String entityStructure;

    @Column(name = "industry")
    public String industry;

    @Column(name = "national_address")
    public String nationalAddress;

    @Column(name = "company_vintage")
    public String companyVintage;

    @Column(name = "trading_name")
    public String tradingName;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "job_title")
    public String jobTitle;

    @Column(name = "current_clients_count")
    @Enumerated(EnumType.STRING)
    public ClientsCountGroup currentClientsCount;

    @Column(name = "current_employees_count")
    @Enumerated(EnumType.STRING)
    public EmployeesCountGroup currentEmployeesCount;

    @Column(name = "annual_revenue")
    @Enumerated(EnumType.STRING)
    public RevenueGroup annualRevenue;

    @Column(name = "nitiqat")
    public Nitiqat nitiqat;

    @Column(name = "website_url")
    public String websiteUrl;

    @Column(name = "logo_url")
    public String logoUrl;

    @Column(name = "org_status")
    @Enumerated(EnumType.STRING)
    public OrgStatus orgStatus;
}
