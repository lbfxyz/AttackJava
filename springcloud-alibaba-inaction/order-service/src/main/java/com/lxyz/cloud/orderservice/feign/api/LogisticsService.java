package com.lxyz.cloud.orderservice.feign.api;

import com.lxyz.cloud.orderservice.form.OrderForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lbf
 * @date 2021/4/20
 */
@FeignClient("logistics-service")
public interface LogisticsService {


    /**
     * 物流服务-添加物流单
     * @param orderForm
     * @return
     */
    @PostMapping("/logistics/add")
    String add(OrderForm orderForm);


}
