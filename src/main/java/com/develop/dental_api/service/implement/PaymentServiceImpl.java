package com.develop.dental_api.service.implement;

import org.springframework.stereotype.Service;

import com.develop.dental_api.model.dto.PaymentDetailDTO;
import com.develop.dental_api.model.dto.PaymentRequestDTO;
import com.develop.dental_api.model.dto.PaymentResponseDTO;
import com.develop.dental_api.model.entity.Appointment;
import com.develop.dental_api.model.entity.Payment;
import com.develop.dental_api.model.mapper.PaymentMapper;
import com.develop.dental_api.repository.AppointmentRepository;
import com.develop.dental_api.repository.PaymentRepository;
import com.develop.dental_api.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final AppointmentRepository appointmentRepository;

    @Override
    public PaymentResponseDTO registerPayment(PaymentRequestDTO dto) {
        Appointment appointment = appointmentRepository.findById(dto.getAppointmentId())
            .orElseThrow(() -> new IllegalArgumentException("Cita no encontrada"));

        Payment payment = paymentMapper.toPaymentEntity(dto, appointment);
        paymentRepository.save(payment);
        return new PaymentResponseDTO("Pago registrado", payment.getPaymentId());
    }

    @Override
    public PaymentDetailDTO getPaymentDetail(Integer paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return paymentMapper.toPaymentDetailDTO(payment);
    }
}
