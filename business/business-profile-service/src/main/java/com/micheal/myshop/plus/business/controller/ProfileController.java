package com.micheal.myshop.plus.business.controller;

import com.micheal.myshop.plus.business.dto.ProfileParam;
import com.micheal.myshop.plus.commons.dto.ResponseResult;
import com.micheal.myshop.plus.provider.api.UmsAdminService;
import com.micheal.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ProfileParam profileParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(profileParam, umsAdmin);
        int result = umsAdminService.update(umsAdmin);

        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "更新个人信息成功");
        }

        return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "更新个人信息失败");
    }
}
