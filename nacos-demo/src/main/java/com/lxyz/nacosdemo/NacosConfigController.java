package com.lxyz.nacosdemo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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


    public static void main(String[] args) {
        // 8  ---> 1000
        int a = 38;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a >>> 3));
        System.out.println(Integer.toBinaryString(a >> 3));
        System.out.println(a >>> 3);

        int b = -38;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b >>> 3));
        System.out.println(Integer.toBinaryString(b >> 3));
        System.out.println(b >>> 3);

        System.out.println(Integer.parseInt("11111111111111111111111111011",2));
        System.out.println("===============");
        int c = 5;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(c << 1));
        System.out.println("================");

        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(10 >> 1));
        System.out.println(Integer.parseInt(Integer.toBinaryString(10 >> 1),2));
        System.out.println(Integer.toBinaryString(8 ^ 5));

        Map<String, String> map = new HashMap<>();
        map.put("name", "hello");


    }

}
