package com.itheima.freamework;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SpringContextBeanTest {

    @Test
    public void testBCryptPasswordEncoder() {
        // $2a$10$q.8iAXXf8qIO/KkAj5828eARZbaNa47EMrNksmDNWQmPemPtVYdRG
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }
}
