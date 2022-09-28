package ac.mtvs.indianbob.main.model;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@ServerEndpoint(value="/webSocket") // WebSocket을 활성화시키는 매핑 정보 지정
public class WebSocketService extends TextWebSocketHandler {
 
    // 세션 정보를 정적으로 저장하여 1:N 통신 가능하도록 설정
    private static List<WebSocketSession> clients = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        clients.add(session);
        System.out.println("opent : " + session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        for(WebSocketSession client: clients) {
            client.sendMessage(message);
        }

        System.out.println("message : " + payload + message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        clients.remove(session);
        System.out.println("close : " + session);

    }

    // 발생 이벤트에 따라 실행할 메소드 정의
//    @OnOpen
//    public  void onOpen(Session session) {
//        System.out.println("OPEN : " + session.getId());
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) throws IOException {
//        System.out.println("MESSAGE : " + session);
//        session.getBasicRemote().sendText("MESSAGE");
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        System.out.println("CLOSE : " + session);
//    }
    
}