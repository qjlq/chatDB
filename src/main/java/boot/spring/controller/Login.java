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
	LoginService loginservice;   //调用boot.spring.service.LoginService接口

	//接收在login的html上登录的username和password
	@RequestMapping("/loginvalidate")
	//@RequestParam是将请求参数绑定到控制器的方法参数上
	public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String pwd, HttpSession httpSession) {
		if (username == null) {
			return "/";
		}
		User user = loginservice.getUserByName(username);    //调用LoginServiceImpl方法获得名字
		String realpwd = user.getPassword();           //在po.User中获得密码
		if (realpwd != null && pwd.equals(realpwd)) {      //密码匹对，成功运行以下语句
			user.setPassword("NULL");
			//用户信息存到httpSession中
			httpSession.setAttribute("user", user);
			return "chatroom";   //进入到这个html上
		} else {
			return "loginfail";
		}			
	}

	@RequestMapping("/")           //第一次接收登陆界面，去到login的html
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")         //接收退出登录的所展示的界面处理
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("user");              //移除httpSession上登录的账户
		return "login";          //进入到这个html上
	}
	
}
