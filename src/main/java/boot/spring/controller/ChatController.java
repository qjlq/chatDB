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
public class ChatController {

	//@Autowired //重复注入导致报错？ Error creating bean with name
	LoginService loginservice;
	
	/**
	 * 在线用户
	 */
	//加载当前用户
	@RequestMapping("/onlineusers")
	@ResponseBody
	public Set<String> onlineusers(@RequestParam("currentuser") String currentuser) {
		ConcurrentHashMap<String, Session> map = WebSocketServer.getSessionPools();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		Set<String> nameset = new HashSet<String>();
		while (it.hasNext()) {
			String entry = it.next();
			if (!entry.equals(currentuser))
				nameset.add(entry);
		}
		return nameset;
	}
	
	/**
	 * 当前用户
	 */
	@RequestMapping(value = "/currentuser", method = RequestMethod.GET)
	@ResponseBody
	public User currentuser(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		return user;
	}


	//myself
	@RequestMapping("/welcome")
	public String welcome() {
		return "login";
	}

	@RequestMapping("/history")
	public String history() {
		return "order";
	}
}
