package com.anTools.service;

import com.anTools.entity.AnUser;

import java.util.List;

public interface AnUserService {

    public List<AnUser> listAll();

    public AnUser loginUser(String openId);

    public void setTokenToRedis(String token, AnUser anUser);

    public AnUser getTokenForRedis(String token);

    Integer updateUser(AnUser anUser);

}
