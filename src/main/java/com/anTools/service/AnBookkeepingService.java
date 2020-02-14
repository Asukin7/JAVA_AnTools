package com.anTools.service;

import com.anTools.entity.AnBookkeeping;

import java.util.List;
import java.util.Map;

public interface AnBookkeepingService {

    public List<AnBookkeeping> listAll(Map<String, Object> map);

    public Float sumMoney(Map<String, Object> map);

    public Integer save(AnBookkeeping anBookkeeping);

    public Integer delete(AnBookkeeping anBookkeeping);

    public Map<String, Object> allTotalNumberAndDays(Map<String, Object> map);

}
