package com.anTools.dao;

import com.anTools.entity.AnBookkeeping;
import com.anTools.sqlProvider.AnBookkeepingSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

public interface AnBookkeepingDao {

    /**带参数查找账单表*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="listAll")
    public List<AnBookkeeping> listAll(Map<String, Object> map);

    /**带参数查找账单表总收支*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="sumMoney")
    public Float sumMoney(Map<String, Object> map);

    /**插入账单表数据*/
    @InsertProvider(type=AnBookkeepingSqlProvider.class, method="insert")
    public Integer insert(AnBookkeeping anBookkeeping);

    /**更新账单表数据*/
    @UpdateProvider(type=AnBookkeepingSqlProvider.class, method="update")
    public Integer update(AnBookkeeping anBookkeeping);

    /**删除账单表数据*/
    @DeleteProvider(type=AnBookkeepingSqlProvider.class, method="delete")
    public Integer delete(AnBookkeeping anBookkeeping);

}
