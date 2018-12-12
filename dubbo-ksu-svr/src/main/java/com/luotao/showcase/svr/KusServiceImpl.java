package com.luotao.showcase.svr;

import com.xdf.showcase.api.KsuService;
import com.xdf.showcase.api.UserService;
import com.xdf.showcase.api.request.UserFindRequest;
import com.xdf.showcase.api.response.UserFindResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ksuService")
public class KusServiceImpl implements KsuService {
    @Autowired
    private UserService userService;

    public KusServiceImpl() {
        System.out.println(321312);
    }

    public UserFindResponse findUsers(UserFindRequest request) {
        UserFindResponse users = userService.findUsers(request);
        return users;
    }
}
