package com.vueSpring.myasset.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vueSpring.myasset.vo.MyassetVo;
import com.vueSpring.myasset.vo.UserInfoVo;

@Mapper
public interface MyassetMapper {
    List<MyassetVo> selectMyasset();

    UserInfoVo selectUserInfo(UserInfoVo vo);
}
