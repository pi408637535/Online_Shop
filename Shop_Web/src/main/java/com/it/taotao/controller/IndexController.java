package com.it.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 55 on 5/3/2016.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String IndexController(){
        return "index";
    }
}
