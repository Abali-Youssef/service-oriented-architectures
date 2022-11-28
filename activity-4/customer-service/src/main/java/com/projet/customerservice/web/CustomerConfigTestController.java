package com.projet.customerservice.web;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RefreshScope
public class CustomerConfigTestController {
    @Value("${global.params.p1:noValue}")
    private  String p1;
    @Value("${global.params.p2:noValue}")
    private  String p2;
    @Value("${customer.params.x:noValue}")
    private  String x;
    @Value("${customer.params.y:noValue}")
    private String y;

    @GetMapping("/params")
    public Map<String,String> params(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
}
