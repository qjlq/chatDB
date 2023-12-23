package boot.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {
    @GetMapping("/index")
    public String toIndex() {
        return "/register";
    }

    @GetMapping("/toRegisterHint")
    public String toRegisterHint() {
        return "/loginfail";
    }
}
