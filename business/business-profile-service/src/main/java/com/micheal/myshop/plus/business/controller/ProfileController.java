package com.micheal.myshop.plus.business.controller;

import com.micheal.myshop.plus.commons.dto.ResponseResult;
import com.micheal.myshop.plus.provider.api.UmsAdminService;
import com.micheal.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/21 20:17
 * @Description 个人信息管理
 */
@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @GetMapping(value = "/info/{username}")
    public ResponseResult<UmsAdmin> info(@PathVariable String username) {
        UmsAdmin umsAdmin = umsAdminService.get(username);
        return new ResponseResult<UmsAdmin>(ResponseResult.CodeStatus.OK, "查询用户信息", umsAdmin);
    }
}
