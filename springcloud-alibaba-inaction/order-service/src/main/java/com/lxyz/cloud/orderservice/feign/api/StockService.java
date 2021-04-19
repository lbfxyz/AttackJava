package com.lxyz.cloud.orderservice.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lbf
 * @date 2021/4/19
 */
@FeignClient("stock-service")
public interface StockService {

    /**
     * 减库存
     * @param reduceStock
     * @param productId
     * @return
     */
    @GetMapping("/stock/reduce")
    String reduceStock(@RequestParam("productId") String productId,@RequestParam("reduceStock") Integer reduceStock);


}
