package com.anTools.controller;

import com.anTools.common.Result;
import com.anTools.common.ResultStatus;
import com.anTools.entity.AnBookkeeping;
import com.anTools.service.AnBookkeepingService;
import com.anTools.service.AnUserService;
import com.anTools.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bookkeeping")
public class AnBookkeepingController extends ExceptionController {

    @Autowired
    private AnBookkeepingService anBookkeepingService;
    @Autowired
    private AnUserService anUserService;

    @ResponseBody
    @RequiresRoles("user")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public Result listAll(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> map) {
        Result result = new Result();

        Integer userId = anUserService.getTokenForRedis(token).getId();
        if (userId == null) {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为登录失效
            return result;
        }
        map.put("userId", userId);

        if (map.get("bkRemark") != null) map.put("bkRemark", StringUtil.formatLike(map.get("bkRemark").toString()));
        if (map.get("bkDateStr") != null) map.put("bkDateStr", StringUtil.formatLike(map.get("bkDateStr").toString()));
        List<AnBookkeeping> anBookkeepingListAll = anBookkeepingService.listAll(map);
        map.put("incomeOrExpend", "income");
        Float sumIncomeMoney = anBookkeepingService.sumMoney(map);
        map.put("incomeOrExpend", "expend");
        Float sumExpendMoney = anBookkeepingService.sumMoney(map);

        Map<String, Object> resultData = new HashMap<String, Object>();
        resultData.put("bookkeepingListAll", anBookkeepingListAll);
        resultData.put("sumIncomeMoney", sumIncomeMoney);
        resultData.put("sumExpendMoney", sumExpendMoney);
        result.setData(resultData);
        return result;
    }

    @ResponseBody
    @RequiresRoles("user")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestHeader("Authorization") String token, @RequestBody AnBookkeeping anBookkeeping) {
        Result result = new Result();

        Integer userId = anUserService.getTokenForRedis(token).getId();
        if (userId == null) {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为登录失效
            return result;
        }
        anBookkeeping.setUserId(userId);

        Integer saveNumber = anBookkeepingService.save(anBookkeeping);

        Map<String, Object> resultData = new HashMap<String, Object>();
        resultData.put("saveNumber", saveNumber);
        result.setData(resultData);
        return result;
    }

    @ResponseBody
    @RequiresRoles("user")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestHeader("Authorization") String token, @RequestBody AnBookkeeping anBookkeeping) {
        Result result = new Result();

        Integer userId = anUserService.getTokenForRedis(token).getId();
        if (userId == null) {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为登录失效
            return result;
        }
        anBookkeeping.setUserId(userId);

        Integer deleteNumber = anBookkeepingService.delete(anBookkeeping);

        Map<String, Object> resultData = new HashMap<String, Object>();
        resultData.put("deleteNumber", deleteNumber);
        result.setData(resultData);
        return result;
    }

    @ResponseBody
    @RequiresRoles("user")
    @RequestMapping(value = "/allTotalNumberAndDays", method = RequestMethod.POST)
    public Result allTotalNumberAndDays(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> map) {
        Result result = new Result();

        Integer userId = anUserService.getTokenForRedis(token).getId();
        if (userId == null) {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为登录失效
            return result;
        }
        map.put("userId", userId);

        if (map.get("bkRemark") != null) map.put("bkRemark", StringUtil.formatLike(map.get("bkRemark").toString()));
        if (map.get("bkDateStr") != null) map.put("bkDateStr", StringUtil.formatLike(map.get("bkDateStr").toString()));

        Map<String, Object> resultData = anBookkeepingService.allTotalNumberAndDays(map);
        result.setData(resultData);
        return result;
    }

}
