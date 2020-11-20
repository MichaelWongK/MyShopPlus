package com.micheal.myshop.plus.business.controller;

import com.google.common.collect.Maps;
import com.micheal.myshop.plus.business.dto.LoginParam;
import com.micheal.myshop.plus.commons.dto.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/20 17:53
 * @Description 登录管理
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("token", "123456");
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, HttpStatus.OK.toString(), map);
    }
}
