package com.micheal.myshop.plus.provider.api;

import com.micheal.myshop.plus.provider.domain.UmsAdmin;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/19 16:51
 * @Description
 */
public interface UmsAdminService {

    /**
     * 新增用户
     * @param umsAdmin
     * @return
     */
    int insert(UmsAdmin umsAdmin);
}
