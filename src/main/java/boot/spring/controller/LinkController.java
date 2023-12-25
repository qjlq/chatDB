package boot.spring.controller;

import boot.spring.po.Product;
import boot.spring.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LinkController {

    @Resource
    LinkService linkService;

    @RequestMapping("/productlist")
    @ResponseBody
    public List<Product> productlist(@RequestParam("currentuserid") String currentuserid) {
        List<Product> products = linkService.getProductsByUid(currentuserid);
        return products; //返回结果
    }
}
