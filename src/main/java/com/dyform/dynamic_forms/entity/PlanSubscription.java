package com.dyform.dynamic_forms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "plan_subscriptions")
@Getter @Setter
public class PlanSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID subscriptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id",nullable = false)
    private User admin;

    @Enumerated(EnumType.STRING)
    private PlanType planType;

    private LocalDate startDate;

    private  LocalDate endDate;

    private Boolean isActive = true;
}
