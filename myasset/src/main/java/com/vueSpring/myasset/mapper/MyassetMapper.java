package com.vueSpring.myasset.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vueSpring.myasset.vo.UserInfoVo;

@Mapper
public interface MyassetMapper {
    UserInfoVo selectUserInfo(UserInfoVo vo);
}
