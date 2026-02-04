package com.dyform.dynamic_forms.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.UUID;

@Entity
@Table(name = "form_fields")
@Getter @Setter
@Builder
public class FormField {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID fieldId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id", nullable = false)


    private Form form;

    @Column(name = "field_label", nullable = false)
    private String fieldLabel;

    @Enumerated(EnumType.STRING)
    private FieldType fieldType;

    @Column(name = "field_order")
    private Integer fieldOrder;


    private Boolean isRequired = false;

    @JdbcTypeCode(org.hibernate.type.SqlTypes.JSON)
    @Column(name = "options", columnDefinition = "jsonb")
    private java.util.Map<String, Object> options;
}
