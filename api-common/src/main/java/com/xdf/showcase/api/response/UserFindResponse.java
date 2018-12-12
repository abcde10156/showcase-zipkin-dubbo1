package com.xdf.showcase.api.response;

import com.xdf.showcase.api.dto.User;

import java.util.List;

public class UserFindResponse extends BaseResponse {
    private List<User> result;

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }
}
