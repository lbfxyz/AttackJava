package com.lxyz.redis.controller;

import com.lxyz.redis.utils.RedisUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbf
 * @date 2021/4/10
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedissonClient redissonClient;

    @PostMapping("/reduceStock")
    public String setData() {
        String lockKey = "product_123";
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
        try {
            int stock = Integer.parseInt(redisUtil.getStr("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                redisUtil.setStr("stock", String.valueOf(realStock));
                System.out.println("减库存成功，剩余库存数： " + realStock);
            } else {
                System.out.println("库存不足");
            }
        } catch (Exception e) {
            lock.unlock();
        }
        return "OK";
    }

}
