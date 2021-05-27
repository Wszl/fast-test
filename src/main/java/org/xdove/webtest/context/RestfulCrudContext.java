package org.xdove.webtest.context;

import java.util.HashMap;
import java.util.Map;

public class RestfulCrudContext implements Context {

    private Map<String, Object> c;

    public RestfulCrudContext() {
        this.c = new HashMap<String, Object>();
    }

    public Object getContext(String name) {
        return c.get(name);
    }

    public void addContext(String name, Object value) {
        c.put(name, value);
    }

}
