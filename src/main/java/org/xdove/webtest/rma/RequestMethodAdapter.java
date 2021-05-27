package org.xdove.webtest.rma;

import java.util.Map;

public interface RequestMethodAdapter<Method> {

    Method getGETMethod();

    Method getHEADMethod();

    Method getPOSTMethod();

    Method getPUTMethod();

    Method getPATCHMethod();

    Method getDELETEMethod();

    Method getOPTIONSMethod();

    Method getTRACEMethod();

}
