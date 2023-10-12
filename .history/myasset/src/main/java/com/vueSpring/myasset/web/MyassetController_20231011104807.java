package com.vueSpring.myasset.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vueSpring.myasset.impl.MyassetServiceImpl;
import com.vueSpring.myasset.vo.UserInfoVo;

@Controller
@CrossOrigin(origins = "https://localhost:8081/api")
@RequestMapping("/api")
public class MyassetController {
    @Autowired
    private MyassetServiceImpl impl;

    public static Logger log = LoggerFactory.getLogger(MainController.class.getName())

    @ResponseBody
    @PostMapping("/test")
    public Map<String, Object> test(@RequestBody Map<String, Object> param) {
        Map<String, Object> map = new HashMap();
        System.out.println("received param: " + param);
        map.put("result", param);
        return map;
    }

    @ResponseBody
    @PostMapping("/signin")
    public boolean signin(@RequestBody Map<String, Object> param) {
        boolean result = false;
        return result;
    }

    @ResponseBody
    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, Object> param) {
        log.info("login test");
        boolean result = false;
        UserInfoVo vo = new UserInfoVo();
        vo.setId((String) param.get("id"));
        vo.setPw((String) param.get("pw"));
        UserInfoVo loginResult = impl.getUserInfo(vo);

        if (loginResult != null) {
            result = true;
            log.info(loginResult.getId() + "의 계정정보 불러오기 성공");
        } else {
            log.info("계정정보 불러오기 실패");
        }

        return result;
    }
}
