package org.xdove.webtest;

import org.junit.Test;
import org.xdove.webtest.entity.Example;
import org.xdove.webtest.spring.RestfulCRUDControllerTest;

public class WebTest extends RestfulCRUDControllerTest {

    protected String baseUrl() {
        return "http://localhost:8080/example";
    }

    protected Object newInstance() {
        return new Example("ada");
    }

    protected Object updateInstance() {
        return new Example("leo");
    }

    @Test
    public void test() {
        System.out.println("test");
    }

}
