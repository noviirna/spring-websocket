package com.research.ovi.springwebsocketserver.listener;

import com.research.ovi.springwebsocketserver.domain.ChatMessage;
import com.research.ovi.springwebsocketserver.domain.MessageType;
import com.research.ovi.springwebsocketserver.util.MomentUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
public class WebSocketEventListener {

    @Autowired
    private SimpMessageSendingOperations sendingOperations;

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
        log.info("Someone joined the public chat room");
    }

    @EventListener
    public void handleWebSocketDisonnectListener(final SessionDisconnectEvent event) {
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        sendingOperations.convertAndSend("/topic/public", ChatMessage.builder()
                .type(MessageType.DISCONNECT)
                .sender(username)
                .timestamp(MomentUtil.calendar(new DateTime()))
                .build());
        log.info("{} left the public chat room", username);
    }
}
