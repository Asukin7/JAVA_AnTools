package com.anTools.controller;

import com.alibaba.fastjson.JSONObject;
import com.anTools.common.Result;
import com.anTools.common.ResultStatus;
import com.anTools.entity.AnUser;
import com.anTools.entity.AnUserLogin;
import com.anTools.service.AnUserService;
import com.anTools.util.HttpUtil;
import com.anTools.util.TokenUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AnUserController {

    @Autowired
    private AnUserService anUserService;

    @ResponseBody
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public Result listAll() {
        Map<String, Object> resultData = new HashMap<String, Object>();
        List<AnUser> userList = anUserService.listAll();
        resultData.put("userList", userList);
        return new Result(ResultStatus.SUCCESS, resultData);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody String code) {
        Result result = new Result();

        JSONObject code2Session = HttpUtil.code2Session(code);
        String session = code2Session.getString("session_key");
        String openid = code2Session.getString("openid");

        if (session != null) {
            Map<String, Object> resultData = new HashMap<String, Object>();
            resultData.put("token", TokenUtil.creatToken(openid,"user"));
            result.setData(resultData);
        } else {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为登录失败
        }

        return result;
    }

    @ResponseBody
    @RequiresRoles("user")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Result getUserInfo(@RequestHeader("Authorization") String token, @RequestBody AnUserLogin anUserLogin) {
        Result result = new Result();



        return result;
    }

}
