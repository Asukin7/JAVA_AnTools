package com.anTools.controller;

import com.anTools.common.Result;
import com.anTools.common.ResultStatus;
import com.anTools.entity.AnBookkeeping;
import com.anTools.service.AnBookkeepingService;
import com.anTools.service.AnUserService;
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
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public Result listAll(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> map) {
        Result result = new Result();

        Integer userId = anUserService.getTokenForRedis(token).getId();
        if (userId == null) {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为登录失效
            return result;
        }
        map.put("userId", userId);

        List<AnBookkeeping> anBookkeepingListAll = anBookkeepingService.listAll(map);

        Map<String, Object> resultData = new HashMap<String, Object>();
        resultData.put("bookkeepingListAll", anBookkeepingListAll);
        result.setData(resultData);
        return result;
    }

}
