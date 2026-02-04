package com.dyform.dynamic_forms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "forms")
@Getter @Setter
@AllArgsConstructor
@Builder
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID formId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id",nullable = false)
    private User admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Column(name = "form_name", nullable = false)
    private String formName;

    @Column(name = "is_payment_enabled")
    private Boolean isPaymentEnabled =false;

    @Column(name = "payment_amount",precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    @Column(length = 10)
    private String currency;

    @Enumerated(EnumType.STRING)
    private FormStatus status;

    @OneToMany(mappedBy = "form",cascade = CascadeType.ALL)
    private List<FormField> fields;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
