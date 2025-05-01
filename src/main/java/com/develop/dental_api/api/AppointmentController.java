package com.develop.dental_api.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.develop.dental_api.model.dto.AppointmentAgendaDTO;
import com.develop.dental_api.model.dto.AppointmentRequestDTO;
import com.develop.dental_api.model.dto.AppointmentResponseDTO;
import com.develop.dental_api.model.dto.MessageResponseDTO;
import com.develop.dental_api.model.dto.RescheduleAppointmentDTO;
import com.develop.dental_api.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody AppointmentRequestDTO request) {
        return ResponseEntity.ok(appointmentService.createAppointment(request));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentAgendaDTO>> getAgenda(
            @RequestParam String date,
            @RequestParam Integer user_id) {
        return ResponseEntity.ok(appointmentService.getAgendaForUser(LocalDate.parse(date), user_id));
    }

    @PutMapping("/{appointment_id}/reschedule")
    public ResponseEntity<MessageResponseDTO> rescheduleAppointment(
            @PathVariable Integer appointment_id,
            @RequestBody RescheduleAppointmentDTO request) {
        return ResponseEntity.ok(appointmentService.reschedule(appointment_id, request.getNewDate()));
    }
}
