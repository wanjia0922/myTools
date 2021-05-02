package com.stu.tools.config;

import com.stu.tools.filter.WebSSHSocketHandler;
import com.stu.tools.filter.WebSocketInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSSHSocketConfig implements WebSocketConfigurer {

    @Autowired
    WebSSHSocketHandler webSSHWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSSHWebSocketHandler, "webssh")
                .addInterceptors(new WebSocketInterceptor())
                .setAllowedOrigins("*");
    }

}