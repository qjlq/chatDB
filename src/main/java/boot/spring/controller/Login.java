package boot.spring.controller;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boot.spring.utils.ValidateImageCodeUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.spring.po.User;
import boot.spring.service.LoginService;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class Login {
	@Resource
	LoginService loginservice; // 调用boot.spring.service.LoginService接口

	// 接收在login的html上登录的username和password
	@RequestMapping("/loginvalidate")
	// @RequestParam是将请求参数绑定到控制器的方法参数上
	public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String pwd,
			HttpSession httpSession) {
		if (username == null) {
			return "/";
		}
		User user = loginservice.getUserByName(username); // 调用LoginServiceImpl方法获得名字
		try {
			String realpwd = user.getPassword();
			User login = loginservice.ManageLogin(username, pwd);
			// 在po.User中获得密码
			if (realpwd != null && pwd.equals(realpwd)) { // 密码匹对，成功运行以下语句
				user.setPassword("NULL");
				// 用户信息存到httpSession中
				httpSession.setAttribute("user", user);
				return "chatroom"; // 进入到这个html上
			}else if(login != null){
				httpSession.setAttribute("manager", login);
				System.out.println("管理员登录成功");
				return "redirect:/findAll";
			} else {
				return "loginfail";
			}
		} catch (Exception e) {
			return "userNull"; //用户不存在时返回
		}

	}

	// 注册方法
	@PostMapping("/register")
	public String register(User user, String code, HttpSession session) {
		String sessionCode = (String) session.getAttribute("code"); // 生成的验证码
		// 忽略大小写, 比较用户输入的验证码与生成的验证码
		if (sessionCode.equalsIgnoreCase(code) && user.getPhone().length() == 11) { // 输入正确
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
			user.setCreate_time(dateFormat.format(date));
			user.setUid(UUID.randomUUID().toString()); // 是javaJDK提供的一个自动生成主键的方法
			System.out.println(user);
			loginservice.register(user); // 注册
			System.out.println("注册成功");
			return "redirect:/index"; // 注册成功跳转到登录界面
		} else { // 输入错误
			return "redirect:/toRegisterHint"; // 注册失败跳转到注册提示语句
		}
	}

	// 生成验证码
	@GetMapping("/code")
	public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
		// 生成验证码
		String securityCode = ValidateImageCodeUtils.getSecurityCode();
		BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
		// 存入session作用域中
		session.setAttribute("code", securityCode);
		// 响应图片
		ServletOutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}

	@RequestMapping("/") // 第一次接收登陆界面，去到login的html
	public String login() {
		return "login";
	}

	@RequestMapping("/logout") // 接收退出登录的所展示的界面处理
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("user"); // 移除httpSession上登录的账户
		return "login"; // 进入到这个html上
	}

}
