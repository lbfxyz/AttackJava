package com.lxyz.cloud.orderservice.feign.callback;

import com.lxyz.cloud.orderservice.feign.api.ScoreService;
import com.lxyz.cloud.orderservice.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lbf
 * @date 2021/4/20
 */
@Component
@Slf4j
public class ScoreServiceFallbackImpl implements ScoreService {

    @Override
    public String addScore(OrderForm orderForm) {
        // 服务不可用的时候，进行降级处理，可以先记录日志，插入数据库，后续处理，优先保证整个链路的可用
        log.info("积分服务不可用，先记录日志后续处理。用户ID --> {}, 获得的积分 ---> {}",
                orderForm.getUserId(), orderForm.getScore());
        return "积分服务暂时不可用";
    }
}
