package com.anTools.service.impl;

import com.anTools.dao.AnUserDao;
import com.anTools.entity.AnUser;
import com.anTools.service.AnUserService;
import com.anTools.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("anUserService")
public class AnUserServiceImpl implements AnUserService {

    @Autowired
    private AnUserDao anUserDao;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<AnUser> listAll() {
        return anUserDao.listAll();
    }

    @Override
    public AnUser loginUser(String openId) {
        AnUser anUser = anUserDao.getByOpenId(openId);
        if (anUser == null) {
            anUser = new AnUser();
            anUser.setOpenId(openId);
            anUserDao.insertUser(anUser);
        }
        return anUser;
    }

    @Override
    public void setTokenToRedis(String token, AnUser anUser) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", anUser.getId().toString());
        map.put("openId", anUser.getOpenId());
        redisUtil.hPutAll(token, map);
        redisUtil.expire(token, 30, TimeUnit.MINUTES);
    }

    @Override
    public AnUser getTokenForRedis(String token) {
        AnUser anUser = new AnUser();
        anUser.setId(Integer.parseInt(redisUtil.hGet(token, "id").toString()));
        anUser.setOpenId(redisUtil.hGet(token, "openId").toString());
        return anUser;
    }

    @Override
    public Integer updateUser(AnUser anUser) {
        return anUserDao.updateUser(anUser);
    }

}
