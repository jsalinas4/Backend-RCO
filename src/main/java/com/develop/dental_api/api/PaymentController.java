package com.develop.dental_api.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.dental_api.model.dto.PaymentDetailDTO;
import com.develop.dental_api.model.dto.PaymentRequestDTO;
import com.develop.dental_api.model.dto.PaymentResponseDTO;
import com.develop.dental_api.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> registerPayment(@RequestBody PaymentRequestDTO request) {
        return ResponseEntity.ok(paymentService.registerPayment(request));
    }

    @GetMapping("/{payment_id}")
    public ResponseEntity<PaymentDetailDTO> getPayment(@PathVariable Integer payment_id) {
        return ResponseEntity.ok(paymentService.getPaymentDetail(payment_id));
    }
}
