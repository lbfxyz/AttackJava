package com.lxyz.cloud.stockservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbf
 * @date 2021/4/19
 */
@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {


    @GetMapping("/reduce")
    public String reduceStock(@RequestParam("productId") String productId, @RequestParam("reduceStock") String reduceStock) {
        System.out.println("扣减库存成功，商品数据减 1");
        log.info("productId --> {}, 扣减的库存 --> {}", productId, reduceStock);
        return "reduce stock success";
    }


}
