package com.bitcamp.firstSpring.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.firstSpring.order.domain.OrderCommand;

@Controller
@RequestMapping("/order/order")
public class OrderController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getOrderForm() {
		return "order/orderForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String order(
			OrderCommand orderCommand
			) {
		
		System.out.println(orderCommand);
		return "order/order";
	}
}
