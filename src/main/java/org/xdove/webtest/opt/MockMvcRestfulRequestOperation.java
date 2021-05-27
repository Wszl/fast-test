package org.xdove.webtest.opt;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.xdove.webtest.rma.RequestMethodAdapter;
import org.xdove.webtest.rma.RestfulRequestMethodAdapter;

import java.util.Objects;

public class MockMvcRestfulRequestOperation {

    private MockMvc mvc;
    private RequestMethodAdapter<HttpMethod> method;

    public MockMvcRestfulRequestOperation(MockMvc mvc) {
        assert Objects.nonNull(mvc);
        this.mvc = mvc;
        this.method = new RestfulRequestMethodAdapter();
    }

    public MockMvcRestfulRequestOperation(MockMvc mvc, RequestMethodAdapter<HttpMethod> method) {
        this.mvc = mvc;
        this.method = method;
    }

    public MvcResult get(String url, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getGETMethod(),url).headers(headers))
                .andReturn();
    }

    public MvcResult head(String url, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getHEADMethod(),url).headers(headers))
                .andReturn();
    }

    public MvcResult post(String url, String body, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getPOSTMethod(), url)
                .headers(headers)
                .content(body)
        )
                .andReturn();
    }

    public MvcResult put(String url, String body, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getPUTMethod(), url)
                .headers(headers)
                .content(body)
        )
                .andReturn();
    }

    public MvcResult patch(String url, String body, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getPATCHMethod(), url)
                .headers(headers)
                .content(body)
        )
                .andReturn();
    }

    public MvcResult delete(String url, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getDELETEMethod(),url).headers(headers))
                .andReturn();
    }

    public MvcResult options(String url, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getOPTIONSMethod(),url).headers(headers))
                .andReturn();
    }

    public MvcResult trace(String url, HttpHeaders headers) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.request(method.getTRACEMethod(),url).headers(headers))
                .andReturn();
    }


}
