package com.example.filter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilterController {
    Logger logger = LogManager.getLogger(FilterController.class);

    @RequestMapping("/xss")
    public String xss(String msg){
        logger.info("Print msg :: " + msg);

        return msg;
    }
}
