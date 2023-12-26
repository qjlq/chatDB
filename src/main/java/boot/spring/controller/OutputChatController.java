package boot.spring.controller;

import boot.spring.po.OutputChat;
import boot.spring.po.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import boot.spring.service.OutputChatService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/empChat")
public class OutputChatController {
    @Resource
    OutputChatService outputChatService;

//    @PostMapping("/findAllUser")
//    public String findAllUser(){
//        return "redirect:/UserChat";
//    }


    @RequestMapping("/findAllUser")
    public String findAllUser(Model m) {
        List<OutputChat> outputChats = outputChatService.findAllUser();
//        System.out.println("sss:"+outputChats);
        m.addAttribute("userAll", outputChats);
        return "OutputChat";
    }
    // @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
	// @ResponseBody
	// public User currentuser(HttpSession httpSession) {
	// 	User user = (User) httpSession.getAttribute("user");
	// 	return user;
	//}
}
