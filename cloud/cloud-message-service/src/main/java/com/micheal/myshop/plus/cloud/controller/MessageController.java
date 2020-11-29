package com.micheal.myshop.plus.cloud.controller;

import com.micheal.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import com.micheal.myshop.plus.cloud.producer.MessageProducer;
import com.micheal.myshop.plus.commons.dto.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/27 16:15
 * @Description
 */
@RestController
@RequestMapping(value = "message")
public class MessageController {

    @Resource
    private MessageProducer producer;

    @PostMapping(value = "admin/login/log")
    public ResponseResult<Void> sendAdminLoginLog(@RequestBody UmsAdminLoginLogDTO dto) {
        boolean vipChannelEnabled = Boolean.parseBoolean(System.getProperty("com.rocketmq.sendMessageWithVIPChannel", "true"));
        boolean flag = producer.sendAdminLoginLog(dto);
        if (flag) {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "发送管理员登陆日志成功");
        }
        return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "发送管理员登陆日志失败");
    }

}
