package com.xdf.showcase.api.request;

import java.util.List;

public class UserFindRequest extends BaseRequest {
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
