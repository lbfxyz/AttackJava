package com.lxyz.cloud.orderservice.feign.api;

import com.lxyz.cloud.orderservice.form.OrderForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lbf
 * @date 2021/4/19
 */
@FeignClient("stock-service")
public interface StockService {

    /**
     * 减库存
     * @return
     */
    @GetMapping("/order/reduceStock")
    String reduceStock(@RequestParam("productId") String productId, @RequestParam("reduceStock") String reduceStock);


}
