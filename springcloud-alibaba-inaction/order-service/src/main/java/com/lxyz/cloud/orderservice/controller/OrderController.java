package com.lxyz.cloud.orderservice.controller;

import com.lxyz.cloud.orderservice.feign.api.LogisticsService;
import com.lxyz.cloud.orderservice.feign.api.ScoreService;
import com.lxyz.cloud.orderservice.feign.api.StockService;
import com.lxyz.cloud.orderservice.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private LogisticsService logisticsService;

    @GetMapping("/stock/reduce")
    public String reduceStock() {
        this.restTemplate.getForObject("http://stock-service/stock/reduce?productId=1&reduceStock=1", String.class);
        return "OK";
    }


    @PostMapping("/create")
    public String createOrder(@RequestBody OrderForm orderForm) {
        // 减库存
        String stockResult = stockService.reduceStock(orderForm.getUserId(), orderForm.getProductCount());
        System.out.println("stockResult ->" + stockResult);
        // 添加积分
        String scoreResult = scoreService.addScore(orderForm);
        System.out.println(scoreResult);
        // 添加物流单
        String logisticsResult = logisticsService.add(orderForm);
        System.out.println(logisticsResult);
        return "OK";
    }



}
