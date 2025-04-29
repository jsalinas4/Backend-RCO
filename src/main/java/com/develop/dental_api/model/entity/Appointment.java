package com.develop.dental_api.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    private String reason;
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentService> appointmentServices;

    @OneToOne(mappedBy = "appointment")
    private Payment payment;
}
