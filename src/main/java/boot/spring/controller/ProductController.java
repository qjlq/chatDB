package boot.spring.controller;

import boot.spring.po.Product;
import boot.spring.service.OrderService;
import boot.spring.service.ProductService;
import boot.spring.service.SellOrderService;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Resource
    ProductService productService;
    @Resource
    SellOrderService sellOrderService;

    @RequestMapping("/deleteproduct")
    @ResponseBody
    public void deleteproduct(String pid, HttpSession httpSession) {
        productService.deleteProduct(pid);
    }

    @RequestMapping("/sendOrder")
    @ResponseBody
    public void sendOrder(String oid, HttpSession httpSession) {
        sellOrderService.sendOrderByoid(oid);
    }

    @RequestMapping("/receivedOrder")
    @ResponseBody
    public void receivedOrder(String oid, HttpSession httpSession) {
       sellOrderService.receivedOrderByoid(oid);
    }

    //文件上传
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("spicture") MultipartFile file,String name,String content, String price, String quantity, String uid) {
        if (file.isEmpty()) {
            return "empty";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();

        //修改上传完成后的文件名
        String pid = UUID.randomUUID().toString();
        String lid = UUID.randomUUID().toString();//随机生成lid
        System.out.println(("上传的文件名为：" + fileName));
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(("上传的后缀名为：" + suffixName));
        // 文件上传后的路径
        System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/orderPicture/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        fileName = pid + suffixName;
        System.out.println(("后端的文件名为：" + fileName));
        File dest = new File(filePath + fileName);
        Product product = new Product(pid, name, content, fileName, quantity, price, lid, uid);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            System.out.println("上传成功!");
            productService.saveProduct(product); //存入新商品
            return "success";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }

}

