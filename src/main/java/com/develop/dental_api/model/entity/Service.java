package com.develop.dental_api.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private BigDecimal price;

    @Column(name = "is_recurring")
    private Boolean isRecurring;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "service")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "service")
    private List<TreatmentDone> treatments;
}
