package com.vueSpring.myasset.service;

import java.util.Map;

import com.vueSpring.myasset.vo.UserInfoVo;

public interface UserManageService {
    public Map<String, Object> registUser(UserInfoVo vo);

    public Map<String, Object> getIdCount(UserInfoVo vo);

    public Map<String, Object> getUserInfo(UserInfoVo vo);
}
