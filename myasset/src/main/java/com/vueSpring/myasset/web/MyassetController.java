package com.vueSpring.myasset.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vueSpring.myasset.impl.MyassetServiceImpl;
import com.vueSpring.myasset.impl.UserManageServiceImpl;
import com.vueSpring.myasset.vo.UserInfoVo;

@Controller
@CrossOrigin(origins = "https://localhost:8081/api")
@RequestMapping("/api")
public class MyassetController {
    @Autowired
    private MyassetServiceImpl impl;
    @Autowired
    private UserManageServiceImpl userImpl;

    private final Logger log = LogManager.getLogger(MyassetController.class);
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @ResponseBody
    @PostMapping("/test")
    public Map<String, Object> test(@RequestBody Map<String, Object> param) {
        Map<String, Object> map = new HashMap();
        System.out.println("received param: " + param);
        map.put("result", param);
        return map;
    }

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> param) {
        log.info("login test");
        UserInfoVo vo = new UserInfoVo();
        vo.setId(String.valueOf(param.get("id")));
        vo.setPw(String.valueOf(param.get("pw")));

        return userImpl.getUserInfo(vo);
    }

    @ResponseBody
    @PostMapping("/register")
    public Map<String, Object> registUser(@RequestBody Map<String, Object> param) {
        UserInfoVo vo = new UserInfoVo();
        vo.setId(String.valueOf(param.get("id")));
        vo.setPw(String.valueOf(param.get("pw")));
        vo.setAddr(String.valueOf(param.get("userAddr")));
        vo.setMailAddr(String.valueOf(param.get("userMail")));
        vo.setUserTel(String.valueOf(param.get("userTel")));
        vo.setUserNm(String.valueOf(param.get("userName")));
        vo.setUserAge(String.valueOf(param.get("userAge")));
        vo.setMarketingYn("Y");

        return userImpl.registUser(vo);
    }

    @ResponseBody
    @PostMapping("/chkIdDuplicate")
    public Map<String, Object> checkIdDuplicate(@RequestBody Map<String, Object> param) {
        UserInfoVo vo = new UserInfoVo();
        vo.setId(String.valueOf(param.get("id")));

        return userImpl.getIdCount(vo);
    }
}
