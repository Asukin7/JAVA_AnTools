package com.anTools.controller;

import com.anTools.common.Result;
import com.anTools.common.ResultStatus;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*权限异常处理，控制器都应该继承
*/
@Controller
@RequestMapping(value = "/Error")
public class ExceptionController {

    //拒绝请求
    @ResponseBody
    @RequestMapping(value = "/noToken", method = RequestMethod.GET)
    public Result noToken() {
        return new Result(ResultStatus.NO_TOKEN);
    }

    //无权时的异常处理
    @ResponseBody
    @ExceptionHandler({UnauthorizedException.class})
    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public Result unauthorized(){
        return new Result(ResultStatus.UNAUTHORIZED);
    }

}
