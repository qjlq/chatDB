package boot.spring.controller;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import boot.spring.po.*;
import boot.spring.service.HistoryMessageService;
import boot.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.service.LoginService;
import boot.spring.service.WebSocketServer;

@Controller
public class ChatController {

	@Resource
	MessageService messageService;

	@Resource
	HistoryMessageService historyMessageService;
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

	@RequestMapping("/storemessage")
	@ResponseBody
	public SaveMessage storemessage(@RequestParam("uid") String uid,
							 @RequestParam("text") String text,
							 @RequestParam("time") String time) {
		String cid = UUID.randomUUID().toString();
		SaveMessage message = new SaveMessage(cid, uid, text, time);
		System.out.println(message.toString());
		messageService.saveMessage(message);
		return message;
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "login";
	}

	@RequestMapping("/history")
	public String history() {
		return "order";
	}

	@RequestMapping("/profile")
	public String profile(){
		return "profile";
	}

	@RequestMapping("/OutputChat")
	public String OutputChat(){
		return "Outputchat";
	}

	@RequestMapping("/findHistoryMessage")
	@ResponseBody
	public List<HistoryMessage> findHistoryMessage(Model m) {
		List<HistoryMessage> historyMessages = historyMessageService.getHistoryMessage();
//        System.out.println("sss:"+outputChats);
		return historyMessages;
	}
}
