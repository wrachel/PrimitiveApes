//package com.example.sping_portfolio.database;
//
//import org.springframework.context.annotation.*;
//import org.springframework.web.servlet.config.annotation.*;
//
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    // set up your own index
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//    }
//
//    /* map path and location for "uploads" outside of application resources
//       ... creates a directory outside "static" folder, "file:uploads"
//       ... CRITICAL, without this uploaded file will not be loaded/displayed by frontend
//     */
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
//    }
//
//}