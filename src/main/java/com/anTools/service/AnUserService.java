package com.anTools.service;

import com.anTools.entity.AnUser;

import java.util.Map;

public interface AnUserService {

    public AnUser loginUser(String openId);

    public void setTokenToRedis(String token, AnUser anUser);

    public AnUser getTokenForRedis(String token);

    public AnUser decryptUserInfo(String token, Map<String, Object> map);

    public Integer updateUser(AnUser anUser);

}
