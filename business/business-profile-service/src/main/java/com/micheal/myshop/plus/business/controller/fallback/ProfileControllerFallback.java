package com.micheal.myshop.plus.business.controller.fallback;

import com.micheal.myshop.plus.business.dto.UmsAdminDTO;
import com.micheal.myshop.plus.business.feign.fallback.ProfileFeignFallback;
import com.micheal.myshop.plus.commons.dto.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/25 17:04
 * @Description
 */
public class ProfileControllerFallback {

    private static final Logger logger = LoggerFactory.getLogger(ProfileControllerFallback.class);

    public static ResponseResult<UmsAdminDTO> infoFallback(String username, Throwable ex) {
        logger.warn("invoke infoFallback: " + ex.getClass().getTypeName());
        return new ResponseResult<UmsAdminDTO>(ResponseResult.CodeStatus.BREAKING, ProfileFeignFallback.BREAKING_MESSAGE);
    }
}
