package com.develop.dental_api.service;

import com.develop.dental_api.model.dto.PaymentDetailDTO;
import com.develop.dental_api.model.dto.PaymentRequestDTO;
import com.develop.dental_api.model.dto.PaymentResponseDTO;

public interface PaymentService {

    PaymentResponseDTO registerPayment(PaymentRequestDTO dto);

    PaymentDetailDTO getPaymentDetail(Integer paymentId);
}