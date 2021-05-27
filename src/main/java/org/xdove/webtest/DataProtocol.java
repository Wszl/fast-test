package org.xdove.webtest;

public interface DataProtocol<T> {

    String convert(Object o);

    T revert(String p);

    String getMIME();
}
