package boot.spring.controller;

import boot.spring.po.OutputChat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import boot.spring.service.OutputChatService;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "/OutputChat";
    }
}
