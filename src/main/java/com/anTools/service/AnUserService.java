package com.anTools.service;

import com.anTools.entity.AnUser;

import java.util.List;

public interface AnUserService {

    public List<AnUser> listAll();

    Integer insertUser(AnUser anUser);

    Integer updateUser(AnUser anUser);

}
