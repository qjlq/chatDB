package boot.spring.controller;

import boot.spring.po.User;
import boot.spring.service.EmpService;
import boot.spring.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/emp")
public class empController {
    @Resource
    private EmpService empService;
    @Resource
    private LoginService userService;

    // 界面登录
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> user = empService.findAll();
        model.addAttribute("users", user);
        return "ManageUser";
    }

    // 界面登录
    @GetMapping("userIn")
    public String userIn() {
        return "redirect:findAll";
    }

    // 增加
    @GetMapping("/toAdd")
    public String toAdd() {
        return "addEmp";
    }

    // 增加
    @PostMapping("/addEmp")
    public String addEmp(User user, HttpSession session) {
        if (user.getPhone().length() == 11) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
            user.setCreate_time(dateFormat.format(date));
            user.setUid(UUID.randomUUID().toString()); // 是javaJDK提供的一个自动生成主键的方法
            empService.add(user);
            return "redirect:findAll";
        } else {
            return "addHint";
        }
    }

    // 删除
    @GetMapping("/Delete")
    public String Delete() {
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(String user_name, HttpSession session) {
        try {
            User user = empService.seek(user_name);
            User user1 = (User) session.getAttribute("manager");
            if (!user1.getUid().equals(user.getUid()) && user.getIs_delete() == 0) {
                user.setIs_delete(1);
                empService.update(user);
                return "redirect:findAll";
            } else {
                return "deleteHint";
            }
        } catch (Exception e) {
            return "deleteHint";
        }

    }

    // 修改用户
    @GetMapping("/find")
    public String find(String username, Model model) {
        try {
            User user = empService.find(username);
            if (user.getIs_delete() == 0) {
                model.addAttribute("user", user);
                return "updateEmp";
            } else {
                return "myselfHint";
            }
        } catch (Exception e) {
            return "myselfHint";
        }

    }

    // 更新修改用户
    @PostMapping("/update")
    public String update(User user, Model model, HttpSession session) {
        try {
            User user2 = empService.seek(user.getUsername());
            user.setIs_delete(user2.getIs_delete());
            user.setCreate_time(user2.getCreate_time());
            user.setUid(user2.getUid());
            if (user.getPhone().length() == 11) {
                empService.update(user);
                return "redirect:findAll";
            } else {
                model.addAttribute("user", user);
                return "updateHint";
            }
        } catch (Exception e) {
            return "updateHint";
        }

    }

    // 查找
    @PostMapping("/seek")
    public String seek(String username, Model model) {
        try {
            User user = empService.seek(username);
            if (user != null && user.getIs_delete() == 0) {
                model.addAttribute("user", user);
                return "seekDate";
            } else {
                return "seekHint";
            }
        } catch (Exception e) {
            return "seekHint";
        }

    }
}
