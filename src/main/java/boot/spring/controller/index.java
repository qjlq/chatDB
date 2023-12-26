package boot.spring.controller;

import boot.spring.po.User;
import boot.spring.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class index {
    @Resource
    private EmpService empService;
    @GetMapping("/index")
    public String toIndex() {
        return "login";
    }

    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @GetMapping("/toRegisterHint")
    public String toRegisterHint() {
        return "registerfail";
    }
}
