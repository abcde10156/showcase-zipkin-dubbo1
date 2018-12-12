package com.xdf.showcase.api;

import com.xdf.showcase.api.request.UserFindRequest;
import com.xdf.showcase.api.response.UserFindResponse;

public interface KsuService {
    UserFindResponse findUsers(UserFindRequest request);
}
