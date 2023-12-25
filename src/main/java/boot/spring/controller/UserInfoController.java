package boot.spring.controller;


import boot.spring.po.UserInfo;
import boot.spring.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/profile")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/profileInfo")
    @ResponseBody
    public UserInfo profile(@RequestParam("currentuserid") String currentuserid, HttpSession httpSession){
        UserInfo userInfo = userInfoService.getHistoryUserUid(currentuserid);
        return userInfo;
    }

}



