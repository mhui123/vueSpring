package com.vueSpring.myasset.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vueSpring.myasset.vo.UserInfoVo;

@Mapper
public interface UserManageMapper {
    int insertUserInfo(UserInfoVo vo);

    int selectIdCount(UserInfoVo vo);

    UserInfoVo selectUserInfo(UserInfoVo vo);
}
