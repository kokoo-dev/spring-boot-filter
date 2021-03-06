package com.example.filter.xss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;


@RestController
public class XssController {
    Logger logger = LogManager.getLogger(XssController.class);

    @RequestMapping("/xss")
    public String xss(String msg){
        logger.info("Print msg :: " + msg);

        return msg;
    }

    @PostMapping("/xssRequestBody")
    public String xssRequestBody(@RequestBody XssDto xssDto){
        //DTO를 RequestBody로 받을 땐 No Argument Constructor 필요
        //RequestBody의 경우 xss필터 적용 안됨
        logger.info("Print name :: " + xssDto.getName());
        logger.info("Print script :: " + xssDto.getScript());

        return xssDto.getName();
    }

    @RequestMapping("/test.kf")
    public String kokooFilter(String data1, String data2){
        logger.info("Print data1 :: " + data1);
        logger.info("Print data2 :: " + data2);

        return data1 + " " + data2;
    }
}
