package com.anTools.service.impl;

import com.anTools.dao.AnUserDao;
import com.anTools.entity.AnUser;
import com.anTools.service.AnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("anUserService")
public class AnUserServiceImpl implements AnUserService {

    @Autowired
    private AnUserDao anUserDao;

    @Override
    public List<AnUser> listAll() {
        return anUserDao.listAll();
    }

    @Override
    public Integer insertUser(AnUser anUser) {
        return anUserDao.insertUser(anUser);
    }

    @Override
    public Integer updateUser(AnUser anUser) {
        return anUserDao.updateUser(anUser);
    }

}
