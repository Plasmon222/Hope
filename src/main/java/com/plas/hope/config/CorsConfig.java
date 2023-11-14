//package com.plas.hope.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @Auther:Plasmon222
// * @Date: 2023/8/24/9:25
// * @Description: 这是配置跨域请求的Cors服务配置类
// */
//@Configuration // 一定不要忽略此注解
//public class CorsConfig implements WebMvcConfigurer {
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**") // 所有接口
////                .allowCredentials(true) // 是否发送 Cookie
////                .allowedOriginPatterns("*") // 支持域
////                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"}) // 支持方法
////                .allowedHeaders("*")
////                .exposedHeaders("*");
////    }
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOriginPatterns("*")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                        .allowedHeaders("*")
//                        .allowCredentials(true);
//            }
//        };
//    }
//}