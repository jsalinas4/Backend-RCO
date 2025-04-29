package com.develop.dental_api.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinical_records")
public class ClinicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String allergies;
    private String medicalHistory;
    private String familyHistory;
    private String treatmentPlan;
    private String evolutionNotes;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "clinicalRecord")
    private List<TreatmentDone> treatments;
}
