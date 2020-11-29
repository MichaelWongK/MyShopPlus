package com.micheal.myshop.plus.cloud.feign;

import com.micheal.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import com.micheal.myshop.plus.cloud.feign.fallback.MessageFeignFallback;
import com.micheal.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/27 11:22
 * @Description
 */
@FeignClient(value = "cloud-message", path = "upload", configuration = FeignRequestConfiguration.class, fallback = MessageFeignFallback.class)
public interface MessageFeign {

    @PostMapping(value = "admin/login/log")
    public String sendAdminLoginLog(@RequestBody UmsAdminLoginLogDTO umsAdminLoginLogDTO);
}
