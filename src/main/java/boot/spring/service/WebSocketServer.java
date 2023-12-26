package boot.spring.service;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import boot.spring.po.Message;
import boot.spring.config.MyThreadFactory;

//@Async("taskExecutor")
@ServerEndpoint("/webSocket/{username}")
@Component
//@Async("taskExecutor")
//@Async
public class WebSocketServer {
	private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(10,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000),new MyThreadFactory("websocket-"));
	// concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
	private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

	// 建立连接成功调用
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "username") String userName) {
		// 链接建立，存储链接对象
		sessionPools.put(userName, session);
		// 广播上线消息
		Message msg = new Message();
		msg.setFrom("系统消息");
		msg.setDate(new Date());
		msg.setTo("0");
		msg.setText(userName);
		broadcast(JSON.toJSONString(msg, true));
	}

	// 关闭连接时调用
	@OnClose
	public void onClose(@PathParam(value = "username") String userName) {
		sessionPools.remove(userName);
		// 广播下线消息
		Message msg = new Message();
		msg.setFrom("系统消息");
		msg.setDate(new Date());
		msg.setTo("-2");
		msg.setText(userName);
		broadcast(JSON.toJSONString(msg, true));
	}

	// 收到客户端信息后，根据接收人的username把消息推下去或者群发
	// to=-1群发消息

	@OnMessage
	public void onMessage(String message) throws IOException {
		Message msg = JSON.parseObject(message, Message.class);
		msg.setDate(new Date());
		if (msg.getTo().equals("-1") || msg.getTo().equals("1")) {
			broadcast(JSON.toJSONString(msg, true)); // -1群发, 1链接
		} else {
			sendInfo(msg.getTo(), JSON.toJSONString(msg, true));
		}
	}

	// 错误时调用
	@OnError
	public void onError(Session session, Throwable throwable) {
		throwable.printStackTrace();
	}

	// 给指定用户发送信息
	public void sendInfo(String userName, String message) {
		Session session = sessionPools.get(userName);
		try {
			sendMessage(session, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 群发消息
	//@Async("taskExecutor")
	public void broadcast(String message) {
		for (Session session : sessionPools.values()) {
			try {
				pool.submit(() -> {
					//synchronized (session) {
						//value.sendText(message);
						try {
							sendMessage(session, message);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					//}
				});
				sendMessage(session, message);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	// 发送消息
	public void sendMessage(Session session, String message) throws IOException {
		if (session != null) {
			synchronized (session) {
				session.getBasicRemote().sendText(message);
			}
		}
	}
	
	public static ConcurrentHashMap<String, Session> getSessionPools() {
		return sessionPools;
	}
}
