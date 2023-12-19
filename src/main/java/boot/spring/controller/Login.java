package boot.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.spring.po.User;
import boot.spring.service.LoginService;

@Controller
public class Login {
	@Autowired
	LoginService loginservice;

	@RequestMapping("/loginvalidate")
	public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String pwd, HttpSession httpSession) {
		if (username == null) {
			return "/";
		}
		User user = loginservice.getUserByName(username);
		String realpwd = user.getPassword();
		if (realpwd != null && pwd.equals(realpwd)) {
			user.setPassword("NULL");
			httpSession.setAttribute("user", user);
			return "chatroom";
		} else {
			return "loginfail";
		}			
	}

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("user");
		return "login";
	}
	
}
