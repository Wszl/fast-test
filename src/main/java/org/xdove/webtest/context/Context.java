package org.xdove.webtest.context;

public interface Context {

    Object getContext(String name);

    void addContext(String name, Object value);

}
