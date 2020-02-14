package com.anTools.service.impl;

import com.anTools.dao.AnBookkeepingDao;
import com.anTools.entity.AnBookkeeping;
import com.anTools.service.AnBookkeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("anBookkeepingService")
public class AnBookkeepingServiceImpl implements AnBookkeepingService {

    @Autowired
    private AnBookkeepingDao anBookkeepingDao;

    @Override
    public List<AnBookkeeping> listAll(Map<String, Object> map) {
        return anBookkeepingDao.listAll(map);
    }

    @Override
    public Float sumMoney(Map<String, Object> map) {
        return anBookkeepingDao.sumMoney(map);
    }

    @Override
    public Integer save(AnBookkeeping anBookkeeping) {
        Integer result = 0;
        if (anBookkeeping.getId() == null) {
            result = anBookkeepingDao.insert(anBookkeeping);
        } else {
            result = anBookkeepingDao.update(anBookkeeping);
        }
        return result;
    }

    @Override
    public Integer delete(AnBookkeeping anBookkeeping) {
        return anBookkeepingDao.delete(anBookkeeping);
    }

    @Override
    public Map<String, Object> allTotalNumberAndDays(Map<String, Object> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("totalNumber", anBookkeepingDao.totalNumber(map));
        result.put("totalDays", anBookkeepingDao.totalDays(map));
        return result;
    }

}
