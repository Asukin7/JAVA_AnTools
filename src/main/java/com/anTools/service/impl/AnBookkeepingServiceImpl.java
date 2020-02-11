package com.anTools.service.impl;

import com.anTools.dao.AnBookkeepingDao;
import com.anTools.entity.AnBookkeeping;
import com.anTools.service.AnBookkeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("anBookkeepingService")
public class AnBookkeepingServiceImpl implements AnBookkeepingService {

    @Autowired
    private AnBookkeepingDao bookkeepingDao;

    @Override
    public List<AnBookkeeping> listAll(Map<String, Object> map) {
        return bookkeepingDao.listAll(map);
    }

}
