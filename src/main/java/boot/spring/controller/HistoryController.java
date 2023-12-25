package boot.spring.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import boot.spring.po.Order;
import boot.spring.po.Product;
import boot.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.po.User;
import boot.spring.service.OrderService;
import boot.spring.service.ProductService;
import boot.spring.service.WebSocketServer;

import boot.spring.po.User;

@Controller
public class HistoryController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @RequestMapping("/chat")
    public String chat() {
        return "chatroom";
    }

    //加载当前用户的购买历史
    @RequestMapping("/orderhistory")
    @ResponseBody
    public  List<Order> orderhistory(@RequestParam("currentuserid") String currentuserid, HttpSession httpSession) {
        List<Order> orders = orderService.getHistoryByUid(currentuserid);
        return orders; //返回结果
    }

    @RequestMapping("/producthistory")
    @ResponseBody
    public  List<Product> producthistory(@RequestParam("currentuserid") String currentuseridp, HttpSession httpSession) {
        List<Product> products = productService.getHistoryByUid(currentuseridp);
        return products; //返回结果
    }

    @RequestMapping("/myProduct")
    public String myProduct() {
        return "myProduct";
    }

    @RequestMapping("/edit_goods")
    public String edit_goods(){
        return "edit";
    }
}