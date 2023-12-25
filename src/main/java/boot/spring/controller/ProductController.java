package boot.spring.controller;

import boot.spring.po.Product;
import boot.spring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.UUID;

@Controller
public class ProductController {
    @Resource
    ProductService productService;


    //文件上传
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("spicture") MultipartFile file,String name,String content, String price, String quantity) {
        if (file.isEmpty()) {
            return "empty";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();

        //修改上传完成后的文件名
        String pid = UUID.randomUUID().toString();
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

        Product product = new Product(pid, name, content, fileName, quantity, price);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            System.out.println("上传成功!");
            productService.saveProduct(product);
            return "success";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    //文件下载
    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        String fileName = "1.jpg";
        if (fileName != null) {
            //当前是从该工程的static//File//下获取文件 然后下载

            //获取根目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            System.out.println("path:"+path.getAbsolutePath());

            //如果上传目录为/static/File/，则可以如下获取：
            File upload = new File(path.getAbsolutePath(),"static/File/");
            if(!upload.exists()) upload.mkdirs();
//            System.out.println("upload url:"+upload.getAbsolutePath());

            String realPath=upload.getAbsolutePath();
// 也可以使用绝对路径，但是很明显不够灵活
// String realPath = "D:\\programming\\IDEAProject\\springboot-study\\sp06-file\\src\\main\\resources\\static\\File";

            System.out.println(realPath);
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" +  fileName);// 设置文件名,默认同名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
