package com.cdu.SoulMate.controller;

import com.cdu.SoulMate.exception.BusinessException;
import com.cdu.SoulMate.common.BaseResponse;
import com.cdu.SoulMate.common.ErrorCode;
import com.cdu.SoulMate.common.ResultUtil;
import com.cdu.SoulMate.model.entity.User;
import com.cdu.SoulMate.model.request.QQLoginRequest;
import com.cdu.SoulMate.service.ThirdPartyLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.cdu.SoulMate.contant.UserConstant.LOGIN_USER_STATUS;

/**
 * @author luokunsong
 * @Date: 2023年04月24日 09:39
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("login")
public class ThirdPartyLoginController {
    @Resource
    private ThirdPartyLoginService thirdPartyLoginService;

    @GetMapping("qq")
    public BaseResponse<String> qqLogin() throws IOException {
        String url = thirdPartyLoginService.qqLogin();
        return ResultUtil.success(url);
    }

    @PostMapping("loginInfo")
    public BaseResponse<User> saveLoginInfo(@RequestBody QQLoginRequest qqLoginRequest, HttpServletRequest request) throws IOException {
        if (qqLoginRequest == null || StringUtils.isBlank(qqLoginRequest.getCode())) {
            throw new BusinessException(ErrorCode.NOT_LOGIN, "请重新登录");
        }
        User user = thirdPartyLoginService.getLoginInfo(qqLoginRequest, request);
        request.getSession().setAttribute(LOGIN_USER_STATUS, user);
        return ResultUtil.success(user);
    }
}
