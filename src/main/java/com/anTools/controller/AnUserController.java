package com.anTools.controller;

import com.anTools.common.Result;
import com.anTools.common.ResultStatus;
import com.anTools.entity.AnUser;
import com.anTools.service.AnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AnUserController {

    @Autowired
    private AnUserService anUserService;

    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public Result listAll(){
        Map<String, Object> resultData = new HashMap<String, Object>();
        List<AnUser> userList = anUserService.listAll();
        resultData.put("userList", userList);
        return new Result(ResultStatus.SUCCESS, resultData);
    }

}
