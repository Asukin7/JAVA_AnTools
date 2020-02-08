package com.anTools.controller;

import com.alibaba.fastjson.JSONObject;
import com.anTools.common.Result;
import com.anTools.common.ResultStatus;
import com.anTools.entity.AnUser;
import com.anTools.service.AnUserService;
import com.anTools.util.HttpUtil;
import com.anTools.util.TokenUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AnUserController {

    @Autowired
    private AnUserService anUserService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody String code) {
        Result result = new Result();

        JSONObject code2Session = HttpUtil.code2Session(code);
        String openid = code2Session.getString("openid");
        String session = code2Session.getString("session_key");

        if (openid != null && session!= null) {
            AnUser anUser = anUserService.loginUser(openid);//查询数据库是否存在用户openId，不存在则写入
            String token = TokenUtil.creatToken(session, "user");//创建token
            anUserService.setTokenToRedis(token, anUser);//将token写入Redis

            Map<String, Object> resultData = new HashMap<String, Object>();
            resultData.put("token", token);
            result.setData(resultData);
        } else {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为登录失败
        }
        return result;
    }

    @ResponseBody
    @RequiresRoles("user")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Result getUserInfo(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> map) {
        Result result = new Result();

        AnUser anUser = anUserService.decryptUserInfo(token, map);
        if (anUserService.updateUser(anUser) != 0) {
            Map<String, Object> resultData = new HashMap<String, Object>();
            resultData.put("nickName", anUser.getNickName());
            resultData.put("gender", anUser.getGender());
            resultData.put("avatarUrl", anUser.getAvatarUrl());
            result.setData(resultData);
        } else {
            result.setResultStatus(ResultStatus.UNKNOWN_ERROR);//应修改为数据更新失败
        }

        return result;
    }

}
