package org.xdove.webtest;

import com.alibaba.fastjson.JSONArray;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.xdove.webtest.asserts.ResultAssert;
import org.xdove.webtest.opt.MockMvcRestfulRequestOperation;

import java.io.Serializable;
import java.util.Map;

public class MockMvcRestfulIDFetch implements IDFetch {

    private DataProtocol<JSONArray> dataProtocol;
    private ResultAssert<MvcResult> resultAssert;
    private MockMvcRestfulRequestOperation opt;

    public MockMvcRestfulIDFetch(DataProtocol<JSONArray> dataProtocol, ResultAssert<MvcResult> resultAssert, MockMvcRestfulRequestOperation opt) {
        this.dataProtocol = dataProtocol;
        this.resultAssert = resultAssert;
        this.opt = opt;
    }

    public Serializable fetch(String url, Map<String, String> headers) {
        MvcResult mvcResult = null;
        try {
            MultiValueMap mvm = new LinkedMultiValueMap();
            mvm.setAll(headers);
            mvcResult = opt.get(url, new HttpHeaders(mvm));
            resultAssert.getCheck(mvcResult);
            final String strR = mvcResult.getResponse().getContentAsString();
            final JSONArray j = dataProtocol.revert(strR);
            if (j.getJSONObject(0).containsKey("id")) {
                return j.getJSONObject(0).getLong("id");
            } else {
                throw new RuntimeException("unknown data struct for GET " + url);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Map<String, HttpMethod> get() {
        return null;
    }
}
