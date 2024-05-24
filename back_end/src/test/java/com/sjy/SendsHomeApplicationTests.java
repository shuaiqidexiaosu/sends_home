package com.sjy;

import com.alibaba.druid.support.json.JSONWriter;
import com.sjy.entity.User;
import com.sjy.utils.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class SendsHomeApplicationTests {


    //    token建立鉴权测试
    @Test
    void TokenCreateTest() {
        User user = new User();
        user.setUserId("2225122019");

        String token = JwtTokenUtil.createToken(user);

        System.out.println(token);
        System.out.println(JwtTokenUtil.verify(token));
    }

    @Test
    void TimeTest() {
//        Date date = new Date(); // this object contains the current date value
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
//        System.out.println(formatter.format(date));
//        Integer year = Integer.parseInt(formatter.format(date));
//        System.out.println(year);
//        System.out.println(year -4);
        System.out.println(new Date().getYear() + 1900);
    }

}
