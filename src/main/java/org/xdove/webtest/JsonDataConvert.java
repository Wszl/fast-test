package org.xdove.webtest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonDataConvert implements DataProtocol<Object> {
    public String convert(Object o) {
        return JSON.toJSONString(o);
    }

    public Object revert(String p) {
        return JSONObject.parse(p);
    }

    @Override
    public String getMIME() {
        return "application/json";
    }
}
