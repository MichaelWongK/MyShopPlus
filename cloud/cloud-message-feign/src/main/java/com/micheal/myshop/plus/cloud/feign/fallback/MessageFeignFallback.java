package com.micheal.myshop.plus.cloud.feign.fallback;

import com.micheal.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import com.micheal.myshop.plus.cloud.feign.MessageFeign;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/27 11:30
 * @Description
 */
@Component
public class MessageFeignFallback implements MessageFeign {
    @Override
    public String sendAdminLoginLog(UmsAdminLoginLogDTO dto) {
        return null;
    }
}
