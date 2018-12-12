package com.luotao.showcase.web;

import com.xdf.showcase.api.KsuService;
import com.xdf.showcase.api.dto.User;
import com.xdf.showcase.api.request.UserFindRequest;
import com.xdf.showcase.api.response.UserFindResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestKsuService {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        KsuService ksuService = (KsuService) applicationContext.getBean("ksuService");
        UserFindResponse users = ksuService.findUsers(new UserFindRequest());
        System.out.println("users.getResult() = " + users.getResult());
        for (User user : users.getResult()) {
            System.out.println("user.getUsername() = " + user.getUsername());
        }
        System.exit(0);
    }
}
