package boot.spring.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.po.User;
import boot.spring.service.LoginService;
import boot.spring.service.WebSocketServer;

@Controller
public class HistoryController {

    @RequestMapping("/chat")
    public String chat() {
        return "chatroom";
    }
}