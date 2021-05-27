package org.xdove.webtest.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MvcResult;
import org.xdove.webtest.JsonDataConvert;
import org.xdove.webtest.MockMvcRestfulIDFetch;
import org.xdove.webtest.asserts.DefaultMockResultAssert;
import org.xdove.webtest.asserts.ResultAssert;
import org.xdove.webtest.context.RestfulCrudContext;
import org.xdove.webtest.opt.MockMvcRestfulRequestOperation;

import java.io.Serializable;


public abstract class RestfulCRUDControllerTest extends SpringControllerTest implements InitializingBean{

    protected MockMvcRestfulRequestOperation opt;
    private HttpHeaders headers;

    public RestfulCRUDControllerTest() {
        this.resultAssert = new DefaultMockResultAssert();
        this.dataProtocol = new JsonDataConvert();
        this.context = new RestfulCrudContext();
        this.headers = HttpHeaders.writableHttpHeaders(HttpHeaders.EMPTY);
        headers.add(HttpHeaders.CONTENT_TYPE, this.dataProtocol.getMIME());
    }

    @Before
    public void setUp() throws Exception {
        insertNewInstance(newInstance());
    }

    @Test
    public void testGet() throws Exception {
        MvcResult mvcResult = opt.get(baseUrl() + "/" + getInstanceId(), headers);
        getAssert().getCheck(mvcResult);
    }

    @Test
    public void testCreate() throws Exception {
        MvcResult mvcResult = opt.put(baseUrl(), dataProtocol.convert(newInstance()), headers);
        getAssert().createCheck(mvcResult);
    }

    @Test
    public void testUpdate() throws Exception {
        MvcResult mvcResult = opt.patch(baseUrl() + "/" + getInstanceId(), dataProtocol.convert(newInstance()), headers);
        getAssert().updateCheck(mvcResult);
    }

    @Test
    public void testDelete() throws Exception {
        MvcResult mvcResult = opt.delete(baseUrl() + "/" + getInstanceId(), headers);
        getAssert().deleteCheck(mvcResult);
    }

    @Test
    public void testList() throws Exception {
        MvcResult mvcResult = opt.get(baseUrl(), headers);
        getAssert().getCheck(mvcResult);
    }

    protected void insertNewInstance(Object o) throws Exception {
        MvcResult mvcResult = opt.put(baseUrl(), dataProtocol.convert(newInstance()), headers);
        getAssert().createCheck(mvcResult);
    }

    protected abstract Object newInstance();

    protected abstract Object updateInstance();

    protected Serializable getInstanceId() {
        return idFetch.fetch(baseUrl(), headers.toSingleValueMap());
    }
    protected ResultAssert<MvcResult> getAssert() {
        return resultAssert;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.opt = new MockMvcRestfulRequestOperation(this.mvc);
        this.idFetch = new MockMvcRestfulIDFetch(dataProtocol, resultAssert, opt);
    }
}
