package boot.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("edit");
        registry.addViewController("edit.html").setViewName("edit");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/orderPicture/";
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/orderPicture/**").addResourceLocations("file:"+filePath);
    }

}

