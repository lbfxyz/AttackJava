package com.lxyz.nacosdemo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbf
 * @date 2021/4/13
 */
@NacosPropertySource(dataId = "example", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@RestController
public class NacosConfigController {


    @NacosValue(value = "${info:Hello Nacos}", autoRefreshed = true)
    private String info;


    @GetMapping("/getInfo")
    public String getInfo() {
        return info;
    }

}
