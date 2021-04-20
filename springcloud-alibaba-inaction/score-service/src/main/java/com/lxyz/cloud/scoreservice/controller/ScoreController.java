package com.lxyz.cloud.scoreservice.controller;

import com.lxyz.cloud.scoreservice.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
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
@RequestMapping("/score")
public class ScoreController {


    @PostMapping("/add")
    public String add(@RequestBody OrderForm orderForm) {
        log.info("用户ID为{}的用户增加了{}积分", orderForm.getUserId(), orderForm.getScore());
        return "添加积分成功";
    }




}
