package org.xdove.webtest;

public abstract class AbstractWebTest {

    protected abstract String baseUrl();

    public abstract void testGet() throws Exception;

    public abstract void testCreate() throws Exception;

    public abstract void testUpdate() throws Exception;

    public abstract void testDelete() throws Exception;

    public abstract void testList() throws Exception;

}
