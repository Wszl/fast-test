package org.xdove.webtest.rma;

import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class RestfulRequestMethodAdapter implements RequestMethodAdapter<HttpMethod> {


    @Override
    public HttpMethod getGETMethod() {
        return HttpMethod.GET;
    }

    @Override
    public HttpMethod getHEADMethod() {
        return HttpMethod.HEAD;
    }

    @Override
    public HttpMethod getPOSTMethod() {
        return HttpMethod.POST;
    }

    @Override
    public HttpMethod getPUTMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public HttpMethod getPATCHMethod() {
        return HttpMethod.PATCH;
    }

    @Override
    public HttpMethod getDELETEMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    public HttpMethod getOPTIONSMethod() {
        return HttpMethod.OPTIONS;
    }

    @Override
    public HttpMethod getTRACEMethod() {
        return HttpMethod.TRACE;
    }
}
