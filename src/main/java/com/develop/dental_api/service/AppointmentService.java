package com.develop.dental_api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.develop.dental_api.model.dto.AppointmentAgendaDTO;
import com.develop.dental_api.model.dto.AppointmentRequestDTO;
import com.develop.dental_api.model.dto.AppointmentResponseDTO;
import com.develop.dental_api.model.dto.MessageResponseDTO;

public interface AppointmentService {

    AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto);

    List<AppointmentAgendaDTO> getAgendaForUser(LocalDate date, Integer userId);

    MessageResponseDTO reschedule(Integer appointmentId, LocalDateTime newDate);
}