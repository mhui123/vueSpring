package com.vueSpring.myasset.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vueSpring.myasset.mapper.UserManageMapper;
import com.vueSpring.myasset.service.UserManageService;
import com.vueSpring.myasset.vo.UserInfoVo;
import com.vueSpring.myasset.web.MyassetController;

@Service
public class UserManageServiceImpl implements UserManageService {
    private final Logger log = LogManager.getLogger(MyassetController.class);
    @Autowired
    UserManageMapper mapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Map<String, Object> registUser(UserInfoVo vo) {
        log.info("register!!!!!!!!!!!!!!!!!!!!!");
        String rawPw = String.valueOf(vo.getPw());
        String encPw = encoder.encode(rawPw);

        int result = 0;
        Map<String, Object> resultMap = new HashMap<>();

        try {
            result = mapper.insertUserInfo(vo);
            String toSendResult = "";
            if (result == 1) {
                toSendResult = "SUCCESS";
            } else {
                toSendResult = "FAIL";
            }
            resultMap.put("result", toSendResult);
            return resultMap;
        } catch (Exception e) {
            result = 0;
            resultMap.put("result", "ERROR");
            return resultMap;
        }
    }

    @Override
    public Map<String, Object> getUserInfo(UserInfoVo vo) {
        UserInfoVo userData = mapper.selectUserInfo(vo);
        Map<String, Object> resultMap = new HashMap<>();

        if (userData != null) {
            String rawPw = vo.getPw();
            boolean matchResult = encoder.matches(rawPw, String.valueOf(userData.getPw()));
            if (matchResult) {
                userData.setPw("");
                resultMap.put("userData", userData);
            }
        } else {
            // 유저데이터 없음
            resultMap.put("userData", null);
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> getIdCount(UserInfoVo vo) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            int regResult = mapper.selectIdCount(vo);
            String toSendResult = "";
            if (regResult == 0) {
                toSendResult = "POSSIBLE";
            } else {
                toSendResult = "IMPOSSIBLE";
            }
            resultMap.put("result", toSendResult);

            return resultMap;
        } catch (Exception e) {
            resultMap.put("result", "ERROR");
            return resultMap;
        }
    }

}
