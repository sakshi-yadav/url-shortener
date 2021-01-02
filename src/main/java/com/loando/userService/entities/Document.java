package com.loando.userService.entities;

import com.loando.userService.enums.DocumentType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "document")
@Data
public class Document extends BaseEntity{
    @Column(name = "document_type")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "document_url")
    private String document_url;

    @Column(name = "verified")
    private boolean verified;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}
