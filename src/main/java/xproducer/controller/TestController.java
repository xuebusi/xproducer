package xproducer.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xproducer.service.TestService;

/**
 * 生产者测试
 * Created by SYJ on 2017/11/20.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    /**
     * 消息发送到该tipic
     */
    @Value("${kafka.producer.topic}")
    private String topic;

    @Autowired
    private TestService testService;

    /**
     * 发送消息
     * @param data 要发
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject test(@RequestParam(value = "data") String data){
        JSONObject jsonObject = new JSONObject();
        String result;
        try {
            result = testService.send(topic, data);
        } catch (Exception e) {
            jsonObject.put("result", e.getMessage());
            return jsonObject;
        }
        jsonObject.put("result", result);
        return jsonObject;
    }
}
