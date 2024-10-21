package com.designpatterns.PaymentService.events;

import java.util.Date;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.designpatterns.CommonService.events.PaymentCancelledEvent;
import com.designpatterns.CommonService.events.PaymentProcessedEvent;
import com.designpatterns.PaymentService.data.Payment;
import com.designpatterns.PaymentService.data.PaymentRepository;

@Component
public class PaymentsEventHandler {

	private PaymentRepository paymentRepository;

    public PaymentsEventHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        Payment payment
                = Payment.builder()
                .paymentId(event.getPaymentId())
                .orderId(event.getOrderId())
                .paymentStatus("COMPLETED")
                .timeStamp(new Date())
                .build();

        paymentRepository.save(payment);
    }

    @EventHandler
    public void on(PaymentCancelledEvent event) {
        Payment payment
                = paymentRepository.findById(event.getPaymentId()).get();

        payment.setPaymentStatus(event.getPaymentStatus());

        paymentRepository.save(payment);
    }
}
