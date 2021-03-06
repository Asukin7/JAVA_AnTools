package com.anTools.dao;

import com.anTools.entity.AnBookkeeping;
import com.anTools.entity.AnNameValue;
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

    /**查询账单表条数*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="totalNumber")
    public Integer totalNumber(Map<String, Object> map);

    /**查询账单表天数*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="totalDays")
    public Integer totalDays(Map<String, Object> map);

    /**查询某年每月收支总额*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="listMonthsSumMoney")
    public List<AnNameValue> listMonthsSumMoney(Map<String, Object> map);

    /**查询某月每日收支总额*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="listDaysSumMoney")
    public List<AnNameValue> listDaysSumMoney(Map<String, Object> map);

    /**查询各类型收支总额*/
    @SelectProvider(type=AnBookkeepingSqlProvider.class, method="listTypeSumMoney")
    public List<AnNameValue> listTypeSumMoney(Map<String, Object> map);

}
