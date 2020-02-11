package com.anTools.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class AnBookkeepingSqlProvider {

    public String listAll(Map<String, Object> map) {
        String queryStr = new SQL() {
            {
                SELECT("*, DAY(bkDate) as bkDateDay");
                FROM("t_bookkeeping");
                if (map.get("id") != null) WHERE("id = #{id}");
                if (map.get("userId") != null) WHERE("userId = #{userId}");
                if (map.get("incomeOrExpend") != null) WHERE("incomeOrExpend = #{incomeOrExpend}");
                if (map.get("bkType") != null) WHERE("bkType = #{bkType}");
                if (map.get("bkDateStr") != null) WHERE("bkDate like #{bkDateStr}");
                if (map.get("bkMoney") != null) WHERE("bkMoney = #{bkMoney}");
                if (map.get("bkRemark") != null) WHERE("bkRemark like #{bkRemark}");
                ORDER_BY("bkDate DESC");
            }
        }.toString();
        System.out.println(queryStr);
        return queryStr;
    }

}
