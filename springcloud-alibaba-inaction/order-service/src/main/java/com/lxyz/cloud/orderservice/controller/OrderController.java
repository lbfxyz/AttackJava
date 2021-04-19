package com.lxyz.cloud.orderservice.controller;

import com.lxyz.cloud.orderservice.feign.api.StockService;
import com.lxyz.cloud.orderservice.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lbf
 * @date 2021/4/19
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockService stockService;

    @GetMapping("/stock/reduce")
    public String reduceStock() {
        this.restTemplate.getForObject("http://stock-service/stock/reduce", String.class);
        return "OK";
    }


    @PostMapping("/create")
    public String createOrder(OrderForm orderForm) {
        stockService.reduceStock(orderForm.getUserId(), orderForm.getProductId());
        return "OK";
    }




}
