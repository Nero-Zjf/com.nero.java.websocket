import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket")
public class WebSocketTest {
    //连接时执行
    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("新连接");
    }

    //关闭时执行
    @OnClose
    public void onClose(){
        System.out.println("连接关闭");
    }

    //收到消息时执行
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("收到用户的消息"+message);
        session.getBasicRemote().sendText("收到消息"); //回复用户
    }

    //连接错误时执行
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("连接错误");
        error.printStackTrace();
    }
}
