package com.itheima.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Secured({"ROLE_ADMIN", "ROLE_PRODUCT"}) // SpringSecurity权限控制
//    @RolesAllowed({"ROLE_ADMIN", "ROLE_PRODUCT"}) // JSR250权限控制
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PRODUCT')")             // Spring权限控制
    @RequestMapping("/findAll")
    public String findAll(){
        return "product-list";
    }
}
