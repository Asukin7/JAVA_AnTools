package com.anTools.dao;

import com.anTools.entity.AnBookkeeping;
import com.anTools.sqlProvider.AnBookkeepingSqlProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface AnBookkeepingDao {

    /**带参数查找账单表*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="listAll")
    public List<AnBookkeeping> listAll(Map<String, Object> map);

}
