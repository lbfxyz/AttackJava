package com.lxyz.cloud.orderservice.feign.api;

import com.lxyz.cloud.orderservice.feign.callback.ScoreServiceFallbackImpl;
import com.lxyz.cloud.orderservice.form.OrderForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lbf
 * @date 2021/4/20
 */
@FeignClient(value = "score-service",fallback = ScoreServiceFallbackImpl.class)
public interface ScoreService {


    /**
     * 调用积分服务的添加积分接口
     * @param orderForm
     * @return
     */
    @PostMapping("/score/add")
    String addScore(OrderForm orderForm);

}
