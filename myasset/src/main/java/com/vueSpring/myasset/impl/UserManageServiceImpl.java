package com.vueSpring.myasset.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public int registUser(UserInfoVo vo) {
        int result = 0;
        try {
            result = mapper.insertUserInfo(vo);
        } catch (Exception e) {
            result = 0;
            return result;
        }
        return result; // insert정상 : 1 else : 0
    }

    @Override
    public UserInfoVo getUserInfo(UserInfoVo vo) {
        return mapper.selectUserInfo(vo);
    }

}
