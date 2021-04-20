package com.lxyz.cloud.logisticsservice.controller;

import com.lxyz.cloud.logisticsservice.form.OrderForm;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbf
 * @date 2021/4/20
 */
@RestController
@Slf4j
@RequestMapping("/logistics")
public class LogisticsController {


    @PostMapping("/add")
    public String add(@RequestBody OrderForm orderForm) {
        log.info("用户id为{}，商品ID为{}的商品已经添加了物流单", orderForm.getUserId(), orderForm.getProductId());
        return "添加物流单成功";
    }

}
