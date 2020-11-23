package com.micheal.myshop.plus.business.feign;

import com.micheal.myshop.plus.business.dto.ProfileParam;
import com.micheal.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/21 20:31
 * @Description
 */
@FeignClient(value = "business-profile", path = "profile", configuration = FeignRequestConfiguration.class)
public interface ProfileFeign {

    @GetMapping(value = "/info/{username}")
    String info(@PathVariable String username);

    @PostMapping(value = "/update")
    String update(@RequestBody ProfileParam profileParam);
}
