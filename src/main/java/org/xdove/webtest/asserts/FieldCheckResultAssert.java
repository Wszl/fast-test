package org.xdove.webtest.asserts;

import org.springframework.test.web.servlet.MvcResult;

@Deprecated
public class FieldCheckResultAssert extends DefaultMockResultAssert {

    @Override
    public void getCheck(MvcResult r) {
        super.getCheck(r);
        
    }
}
