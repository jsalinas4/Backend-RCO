package com.develop.dental_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.dental_api.model.entity.AppointmentService;

@Repository
public interface AppointmentServiceRepository extends JpaRepository<AppointmentService, Long> {
}
