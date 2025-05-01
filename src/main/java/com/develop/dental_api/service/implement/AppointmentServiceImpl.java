package com.develop.dental_api.service.implement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.develop.dental_api.model.dto.AppointmentAgendaDTO;
import com.develop.dental_api.model.dto.AppointmentRequestDTO;
import com.develop.dental_api.model.dto.AppointmentResponseDTO;
import com.develop.dental_api.model.dto.MessageResponseDTO;
import com.develop.dental_api.model.entity.Appointment;
import com.develop.dental_api.model.entity.User;
import com.develop.dental_api.model.mapper.AppointmentMapper;
import com.develop.dental_api.repository.AppointmentRepository;
import com.develop.dental_api.repository.ServiceRepository;
import com.develop.dental_api.repository.UserRepository;
import com.develop.dental_api.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final AppointmentMapper appointmentMapper;
    private final ServiceRepository serviceRepository;

    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto) {
        User patient = userRepository.findById(dto.getPatientId())
        .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
        User dentist = userRepository.findById(dto.getDentistId())
        .orElseThrow(() -> new IllegalArgumentException("Dentista no encontrado"));
        com.develop.dental_api.model.entity.Service service = serviceRepository.findById(dto.getServiceId())
        .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));

        Appointment appointment = appointmentMapper.toAppointmentEntity(dto, patient, dentist, service);
        appointment.setStatus("Scheduled");
        appointment = appointmentRepository.save(appointment);

        return appointmentMapper.toAppointmentResponseDTO(appointment);
    }

    @Override
    public List<AppointmentAgendaDTO> getAgendaForUser(LocalDate date, Integer userId) {
        List<Appointment> appointments = appointmentRepository.findByDentist(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        return appointments.stream()
                .map(appointmentMapper::toAgendaDTO)
                .toList();
    }

    @Override
    public MessageResponseDTO reschedule(Integer appointmentId, LocalDateTime newDate) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        appointment.setAppointmentDate(newDate);
        appointmentRepository.save(appointment);
        return new MessageResponseDTO("Cita reprogramada");
    }
}
