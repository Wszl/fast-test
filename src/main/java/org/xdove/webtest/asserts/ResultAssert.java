package org.xdove.webtest.asserts;

public interface ResultAssert<T> {

    void getCheck(T r);

    void updateCheck(T r);

    void createCheck(T r);

    void deleteCheck(T r);
}
