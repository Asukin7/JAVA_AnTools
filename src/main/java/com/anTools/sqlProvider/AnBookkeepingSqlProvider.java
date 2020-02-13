package com.anTools.sqlProvider;

import com.anTools.entity.AnBookkeeping;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class AnBookkeepingSqlProvider {

    public String listAll(Map<String, Object> map) {
        String queryStr = new SQL() {
            {
                SELECT("*");
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

    public String sumMoney(Map<String, Object> map) {
        String queryStr = new SQL() {
            {
                SELECT("SUM(bkMoney)");
                FROM("t_bookkeeping");
//                if (map.get("id") != null) WHERE("id = #{id}");
                if (map.get("userId") != null) WHERE("userId = #{userId}");
                if (map.get("incomeOrExpend") != null) WHERE("incomeOrExpend = #{incomeOrExpend}");
                if (map.get("bkType") != null) WHERE("bkType = #{bkType}");
                if (map.get("bkDateStr") != null) WHERE("bkDate like #{bkDateStr}");
//                if (map.get("bkMoney") != null) WHERE("bkMoney = #{bkMoney}");
//                if (map.get("bkRemark") != null) WHERE("bkRemark like #{bkRemark}");
                ORDER_BY("bkDate DESC");
            }
        }.toString();
        System.out.println(queryStr);
        return queryStr;
    }

    public String insert(AnBookkeeping anBookkeeping) {
        String queryStr = new SQL() {
            {
                INSERT_INTO("t_bookkeeping");
//                if (anBookkeeping.getId() != null) VALUES("id", "#{id}");
                if (anBookkeeping.getUserId() != null) VALUES("userId", "#{userId}");
                if (anBookkeeping.getIncomeOrExpend() != null) VALUES("incomeOrExpend", "#{incomeOrExpend}");
                if (anBookkeeping.getBkType() != null) VALUES("bkType", "#{bkType}");
                if (anBookkeeping.getBkDate() != null) VALUES("bkDate", "#{bkDate}");
                if (anBookkeeping.getBkMoney() != null) VALUES("bkMoney", "#{bkMoney}");
                if (anBookkeeping.getBkRemark() != null) VALUES("bkRemark", "#{bkRemark}");
            }
        }.toString();
        System.out.println(queryStr);
        return queryStr;
    }

    public String update(AnBookkeeping anBookkeeping) {
        String queryStr = new SQL() {
            {
                UPDATE("t_bookkeeping");
                if (anBookkeeping.getIncomeOrExpend() != null) SET("incomeOrExpend = #{incomeOrExpend}");
                if (anBookkeeping.getBkType() != null) SET("bkType = #{bkType}");
                if (anBookkeeping.getBkDate() != null) SET("bkDate = #{bkDate}");
                if (anBookkeeping.getBkMoney() != null) SET("bkMoney = #{bkMoney}");
                if (anBookkeeping.getBkRemark() != null) SET("bkRemark = #{bkRemark}");
                WHERE ("id = #{id}");
                WHERE ("userId = #{userId}");
            }
        }.toString();
        System.out.println(queryStr);
        return queryStr;
    }

    public String delete(AnBookkeeping anBookkeeping) {
        String queryStr = new SQL() {
            {
                DELETE_FROM("t_bookkeeping");
                WHERE ("id = #{id}");
                WHERE ("userId = #{userId}");
            }
        }.toString();
        System.out.println(queryStr);
        return queryStr;
    }

}
