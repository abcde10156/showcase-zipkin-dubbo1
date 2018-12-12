package com.luotao.showcase.web;

import com.xdf.showcase.api.UserService;
import com.xdf.showcase.api.dto.User;
import com.xdf.showcase.api.request.UserFindRequest;
import com.xdf.showcase.api.response.UserFindResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println(1232123);
    }

    public UserFindResponse findUsers(UserFindRequest userFindRequest) {
        UserFindResponse userFindResponse = new UserFindResponse();
        User user = new User();
        user.setUserId(1L);
        user.setUsername("zhangsan");
        user.setNickname("zhangsan01");
        user.setPaasword("123456");
        List<User> users = new ArrayList<User>();
        users.add(user);
        userFindResponse.setResult(users);
        return userFindResponse;
    }
}
