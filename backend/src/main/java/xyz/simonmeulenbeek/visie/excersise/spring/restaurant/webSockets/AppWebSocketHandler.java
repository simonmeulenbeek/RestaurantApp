package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.webSockets;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class AppWebSocketHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("received: " + message.toString());
        super.handleTextMessage(session, message);
    }
}
