package org.xdove.webtest.asserts;

import java.util.Map;
import java.util.TreeMap;

public class AssertContext {

    private static final String RESULT = "result";
    private static final String CONTROLLER = "controller";
    private static final String URL = "url";
    private Map<String, Object> c;

    public AssertContext() {
        this.c = new TreeMap<String, Object>();
    }

    public void setResult(Object r) {
        this.c.put(RESULT, r);
    }

    public Object getResult() {
        return c.get(RESULT);
    }

    public void setController(Object c) {
        this.c.put(CONTROLLER, c);
    }

    public Class<?> getController() {
        return (Class) this.c.get(CONTROLLER);
    }

    public void setURL(Object u) {
        this.c.put(URL, u);
    }

    public Object getURL() {
        return this.c.get(URL);
    }
}
