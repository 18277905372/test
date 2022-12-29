package com.liang.gateway.security;

import com.liang.utils.other.ResponseUtil;
import com.liang.utils.result.Result;
import com.liang.utils.result.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//尚未发现用处
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        int status = response.getStatus();
        switch (status) {
            case 404:
                ResponseUtil.out(response, new Result(ResultCode.VALIDATE_FAILED.getCode(), ResultCode.VALIDATE_FAILED.getMessage(), null));
                break;
            case 401:
                ResponseUtil.out(response, new Result(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null));
                break;
            case 403:
                ResponseUtil.out(response, new Result(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), null));
                break;
            default:
                ResponseUtil.out(response, new Result(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null));
                break;
        }
    }
}
