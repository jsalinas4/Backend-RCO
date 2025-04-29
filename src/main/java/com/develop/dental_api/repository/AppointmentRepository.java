package com.develop.dental_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.dental_api.model.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}