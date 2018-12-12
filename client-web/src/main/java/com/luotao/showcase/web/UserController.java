package com.luotao.showcase.web;

import com.xdf.showcase.api.KsuService;
import com.xdf.showcase.api.request.UserFindRequest;
import com.xdf.showcase.api.response.UserFindResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class UserController {

    @Autowired
    KsuService ksuService;

    @RequestMapping("user/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam Map<String, String> param) {
        System.out.println("param = " + param);
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        UserFindRequest request = new UserFindRequest();
        UserFindResponse response = ksuService.findUsers(request);
        result.put("list", response.getResult());
        return result;
    }
}
