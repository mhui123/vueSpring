package com.vueSpring.myasset.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vueSpring.myasset.mapper.MyassetMapper;
import com.vueSpring.myasset.service.MyassetService;
import com.vueSpring.myasset.vo.UserInfoVo;

@Service
public class MyassetServiceImpl implements MyassetService {
    @Autowired
    MyassetMapper mapper;

    @Override
    public UserInfoVo getUserInfo(UserInfoVo vo) {
        return mapper.selectUserInfo(vo);
    }

}
