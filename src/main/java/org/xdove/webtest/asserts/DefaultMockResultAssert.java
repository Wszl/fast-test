package org.xdove.webtest.asserts;


import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;

public class DefaultMockResultAssert implements ResultAssert<MvcResult> {

    public void getCheck(MvcResult r) {
        assertEquals(r.getResponse().getStatus(), 200);
    }

    public void updateCheck(MvcResult r) {
        assertEquals(r.getResponse().getStatus(), 200);
    }

    public void createCheck(MvcResult r) {
        assertEquals(r.getResponse().getStatus(), 200);
    }

    public void deleteCheck(MvcResult r) {
        assertEquals(r.getResponse().getStatus(), 200);
    }
}
