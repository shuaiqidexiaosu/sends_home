package com.sjy.config;

import com.sjy.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.Executors;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    /**
     * 开启跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
//                 设置允许的方法
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                // 是否允许携带cookie参数
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 跨域允许时间
                .maxAge(4000);
    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(5)));
        configurer.setDefaultTimeout(30000);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对swagger的请求不进行拦截
        String[] excludePatterns = new String[]{"/user/login"};
        registry.addInterceptor(tokenInterceptor)
                // 排除指定请求
                .addPathPatterns("/**")
                .excludePathPatterns(excludePatterns);

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //配置拦截器访问静态资源
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
