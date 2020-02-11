package com.anTools.service;

import com.anTools.entity.AnBookkeeping;

import java.util.List;
import java.util.Map;

public interface AnBookkeepingService {

    public List<AnBookkeeping> listAll(Map<String, Object> map);

}
