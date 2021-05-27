package org.xdove.webtest.auth;

public interface Authenticate<K, T> {

    K authentication(T t);

}
