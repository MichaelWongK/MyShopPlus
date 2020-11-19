package com.micheal.myshop.plus.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.micheal.myshop.plus.provider.api.UmsAdminService;
import com.micheal.myshop.plus.provider.domain.UmsAdmin;
import com.micheal.myshop.plus.provider.mapper.UmsAdminMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/19 17:06
 * @Description
 */
@Service(version = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insert(UmsAdmin umsAdmin) {
        // 初始化用户对象
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }


    @Override
    public UmsAdmin get(String username) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        return umsAdminMapper.selectOne(queryWrapper);
    }

    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(new QueryWrapper<UmsAdmin>().eq("username", umsAdmin.getUsername()));
    }

    @Override
    public int update(UmsAdmin umsAdmin) {
        return 0;
    }

    @Override
    public int modifyPassword(String username, String password) {
        return 0;
    }

    @Override
    public int modifyIcon(String username, String path) {
        return 0;
    }

    /**
     * 初始化用户对象
     * @param umsAdmin {@link UmsAdmin}
     */
    private void initUmsAdmin(UmsAdmin umsAdmin) {
        // 初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());

        // 初始化状态
        if (umsAdmin.getStatus() == null) {
            umsAdmin.setStatus(0);
        }

        // 密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
    }
}
