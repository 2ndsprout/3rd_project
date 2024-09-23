package com._ndsprout.Education_platform.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final AgentWebSocketHandlerDecoratorFactory agentWebSocketHandlerDecoratorFactory;
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/api/ws-stomp") //
                .setAllowedOriginPatterns("http://localhost:3000", "http://localhost", "http://www.벌꿀오소리.메인.한국", "http://www.벌꿀오소리.메인.한국:3000", "*") //
                .withSockJS();
    }
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.setMessageSizeLimit(50*1024 * 1024);//default:64*1024
        registration.setSendTimeLimit(100 * 10000);//default:10*10000
        registration.setSendBufferSizeLimit(20 * 512 * 1024); // default : 512 * 1024
        registration.setDecoratorFactories(agentWebSocketHandlerDecoratorFactory);
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/api/sub", "/topic");
        registry.setApplicationDestinationPrefixes("/api/pub");
    }

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/websocket")
//                .setAllowedOrigins("*")
//                .withSockJS();
//    }


}