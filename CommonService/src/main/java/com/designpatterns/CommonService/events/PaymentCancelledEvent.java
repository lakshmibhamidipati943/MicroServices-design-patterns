package com.designpatterns.CommonService.events;

import lombok.Data;

@Data
public class PaymentCancelledEvent {

	private String paymentId;
	private String orderId;
	private String paymentStatus;
}
