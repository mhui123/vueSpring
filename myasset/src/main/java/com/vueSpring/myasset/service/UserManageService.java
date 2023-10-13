package com.vueSpring.myasset.service;

import com.vueSpring.myasset.vo.UserInfoVo;

public interface UserManageService {
    public int registUser(UserInfoVo vo);

    public UserInfoVo getUserInfo(UserInfoVo vo);
}
