package boot.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {
    @GetMapping("/findAll")
    public String toLogin() {
        return "/ManageUser";
    }
    @GetMapping("/index")
    public String toIndex() {
        return "/login";
    }

    @GetMapping("/toRegister")
    public String toRegister() {
        return "/register";
    }

    @GetMapping("/toRegisterHint")
    public String toRegisterHint() {
        return "/registerfail";
    }
}
