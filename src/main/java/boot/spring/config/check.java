// package com.badao.demo.websocket;

// import com.badao.demo.config.MyThreadFactory;
// import lombok.extern.slf4j.Slf4j;
// import org.yeauty.pojo.Session;

// import java.util.Collection;
// import java.util.Map;
// import java.util.Set;
// import java.util.concurrent.*;


// @Slf4j
// public class check {

//     private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(10,WebSocketServer.socketMaxOnlineCount,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000),new MyThreadFactory("websocket-"));


//     /**
//      * 用户集
//      */
//     private static Map<String, Session> USERS = new ConcurrentHashMap<String, Session>();

//     /**
//      * 存储用户
//      *
//      * @param key     唯一键
//      * @param session 用户信息
//      */
//     public static void put(String key, Session session) {
//         USERS.put(key, session);
//     }

//     /**
//      * 移除用户
//      *
//      * @param session 用户信息
//      * @return 移除结果
//      */
//     public static boolean remove(Session session) {
//         String key = null;
//         boolean flag = USERS.containsValue(session);
//         if (flag) {
//             Set<Map.Entry<String, Session>> entries = USERS.entrySet();
//             for (Map.Entry<String, Session> entry : entries) {
//                 Session value = entry.getValue();
//                 if (value.equals(session)) {
//                     key = entry.getKey();
//                     break;
//                 }
//             }
//         } else {
//             return true;
//         }
//         return remove(key);
//     }

//     /**
//      * 移出用户
//      *
//      * @param key 键
//      */
//     public static boolean remove(String key) {
//         Session remove = USERS.remove(key);
//         if (remove != null) {
//             boolean containsValue = USERS.containsValue(remove);
//             log.warn("\n 移出结果 - {}", containsValue ? "失败" : "成功");
//             return containsValue;
//         } else {
//             return true;
//         }
//     }

//     /**
//      * 获取在线用户列表
//      *
//      * @return 返回用户集合
//      */
//     public static Map<String, Session> getUsers() {
//         return USERS;
//     }

//     /**
//      * 群发消息文本消息
//      *
//      * @param message 消息内容
//      */
//     public static void sendMessageToUsersByText(String message) {
//         Collection<Session> values = USERS.values();
//         for (Session value : values) {
//             pool.submit(() -> {
//                 synchronized (value) {
//                     value.sendText(message);
//                 }
//             });
//         }
//     }

//     /**
//      * 发送文本消息
//      *
//      * @param session 自己的用户名
//      * @param message 消息内容
//      */
//     public static void sendMessageToUserByText(Session session, String message) {
//         if (session != null) {
//             session.sendText(message);
//         } else {
//             log.info("\n[你已离线]");
//         }
//     }
// }