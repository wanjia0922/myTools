package com.stu.tools.filter;

import java.util.Map;
import java.util.UUID;

import com.stu.tools.common.Const;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class WebSocketInterceptor implements HandshakeInterceptor {

    @Override
    public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest httpRequest, ServerHttpResponse httpResponse, WebSocketHandler handler,
            Map<String, Object> map) throws Exception {
        if (httpRequest instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest request = (ServletServerHttpRequest) httpRequest;
            String uuid = UUID.randomUUID().toString().replace("-", "");
            map.put(Const.USER_UUID_KEY, uuid);
        }
        return false;
    }
    
    
}