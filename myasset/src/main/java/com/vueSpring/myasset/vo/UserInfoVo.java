package com.vueSpring.myasset.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoVo {
    private String id;
    private String pw;
    private String useYn; // 계정사용여부
    private String grade;

    private String userNm;
    private String userAge;
    private String userTel;
    private String mailAddr; // 메일주소
    private String addr; // 주소
    private String marketingYn;
    private Date signinDate;
    private Date transPwDate; // 패스워드 변경일자
}
